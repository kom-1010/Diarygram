package kr.ac.jejunu.post;

import groovyjarjarpicocli.CommandLine;
import lombok.RequiredArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@Controller
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestController {
    private final UserDao userDao;
    private final PostDao postDao;
    private final ChatDao chatDao;

    @GetMapping("/{id}")
    public ModelMap getPost(@PathVariable("id") Integer id) {
        ModelMap modelMap = new ModelMap();
        Post post = postDao.findById(id).get();
        User user = userDao.findById(post.getUser_id()).get();
        modelMap.addAttribute(post);
        modelMap.addAttribute(user);
        return modelMap;
    }

    @GetMapping("chat/{post_id}")
    public ModelMap getChat(@PathVariable("post_id") Integer post_id) {
        ModelMap modelMap = new ModelMap();
        List<Chat> chat = chatDao.findByPost_id(post_id);
        List<User> user = new ArrayList<>();
        for(int i = 0, n = chat.size(); i < n; i++) user.add(userDao.findById(chat.get(i).getUser_id()).get());

        modelMap.addAttribute(chat);
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

    @PostMapping("/signup")
    public View createUser(MultipartFile profile, String username, String password, String checkPassword, HttpServletRequest request) throws IOException {
        String url = "/signup";

        if(password.equals(checkPassword)) {
            String orgFilename = profile.getOriginalFilename();
            String ext = orgFilename.substring(orgFilename.lastIndexOf("."));
            String filename = username + ext;

            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setProfile(filename);
            userDao.save(user);

            File path = new File(request.getServletContext().getRealPath("/")+
                    "/WEB-INF/static/images/user/" + filename);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(profile.getBytes());
            bufferedOutputStream.close();

            url = "/";
        }
        return new RedirectView(url);
    }

    @PostMapping("/login")
    public View login(String username, String password, HttpSession session) {
        String url = "/login";
        User user = userDao.findByName(username);
        if(user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                url = "/";
            }
        }
        return new RedirectView(url);
    }

    @RequestMapping("/logout")
    public View logout(HttpSession session) {
        session.removeAttribute("user");
        return new RedirectView("/");
    }

    @PostMapping("/new")
    public View createPost(MultipartFile image, String title, String content, HttpServletRequest request, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        Post post = new Post();
        String filename = "";

        post.setTitle(title);
        post.setContent(content);
        post.setUser_id(user.getId());
        post.setLikes(0);
        post.setImage(filename);
        postDao.save(post);

        String orgFilename = image.getOriginalFilename();
        String ext = orgFilename.substring(orgFilename.lastIndexOf("."));
        filename = post.getId()+ "_" + title + ext;

        post.setImage(filename);
        postDao.save(post); //원래는 update 였던 것

        File path = new File(request.getServletContext().getRealPath("/")+
                "/WEB-INF/static/images/post/" + filename);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(image.getBytes());
        bufferedOutputStream.close();

        return new RedirectView("/");
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Integer id) {
        postDao.delete(id);
    }

    @PutMapping("/{id}")
    public void likePost(@PathVariable("id") Integer id) {
        postDao.like(id);
    }

    @PostMapping("/update/{id}")
    public View updatePost(@PathVariable("id") Integer id, MultipartFile image, String title, String content, HttpServletRequest request, HttpSession session) throws IOException {
        Post post = postDao.findById(id).get();
        String orgFilename = image.getOriginalFilename();
        String ext = orgFilename.substring(orgFilename.lastIndexOf("."));
        String filename = post.getId()+ "_" + title + ext;

        post.setTitle(title);
        post.setContent(content);
        post.setImage(filename);

        postDao.save(post); //원래는 update 였던 것

        File path = new File(request.getServletContext().getRealPath("/")+
                "/WEB-INF/static/images/post/" + filename);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(image.getBytes());
        bufferedOutputStream.close();

        return new RedirectView("/");
    }

    @PostMapping("/chat")
    public void createChat(String content, Integer postId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Chat chat = new Chat();
        chat.setContent(content);
        chat.setPost_id(postId);
        chat.setUser_id(user.getId());

        chatDao.save(chat);
    }
}
