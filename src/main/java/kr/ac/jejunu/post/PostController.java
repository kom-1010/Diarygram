package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.web.bind.annotation.RestController
@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostDao postDao;
    private final UserDao userDao;
    private final FileHandler fileHandler;

    @GetMapping("/{id}")
    public ModelMap getPost(@PathVariable("id") Integer id) {
        ModelMap modelMap = new ModelMap();
        Post post = postDao.findById(id).get();
        User user = userDao.findById(post.getUser_id()).get();

        modelMap.addAttribute(post);
        modelMap.addAttribute(user);

        return modelMap;
    }

    @GetMapping("/{user_id}/{id}")
    public ModelMap getPost(@PathVariable("user_id") Integer userId, @PathVariable("id") Integer id) {
        ModelMap modelMap = new ModelMap();
        Post post = postDao.findByUser_idAndId(userId, id);
        User user = userDao.findById(userId).get();

        modelMap.addAttribute(post);
        modelMap.addAttribute(user);

        return modelMap;
    }

    @PostMapping("")
    public View createPost(MultipartFile image, String title, String content, HttpServletRequest request, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        Post post = new Post();
        String filename = "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String createdAt = simpleDateFormat.format(date);

        post.setTitle(title);
        post.setContent(content);
        post.setUser_id(user.getId());
        post.setLikes(0);
        post.setImage(filename);
        post.setCreated_at(createdAt);
        postDao.save(post);

        filename = fileHandler.getFilename(image, title, post.getId());
        post.setImage(filename);
        postDao.save(post);

        fileHandler.fileSave(request, image, filename, "/WEB-INF/static/images/post/");

        return new RedirectView("/");
    }

    @PostMapping("/update/{id}")
    public View updatePost(@PathVariable("id") Integer id, MultipartFile image, String title, String content, HttpServletRequest request, HttpSession session) throws IOException {
        Post post = postDao.findById(id).get();
        String filename = fileHandler.getFilename(image, title, post.getId());

        post.setTitle(title);
        post.setContent(content);
        post.setImage(filename);
        postDao.save(post);

        fileHandler.fileSave(request, image, filename, "/WEB-INF/static/images/post/");

        return new RedirectView("/");
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Integer id) {
        postDao.delete(postDao.findById(id).get());
    }

    @PutMapping("/like/{id}")
    public void likePost(@PathVariable("id") Integer id) {
        Post post = postDao.findById(id).get();
        post.setLikes(post.getLikes()+1);
        postDao.save(post);
    }
}
