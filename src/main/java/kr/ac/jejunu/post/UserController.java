package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;
    private final PostDao postDao;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        Post startPost = postDao.start();
        Post lastPost = postDao.last();

        modelAndView.addObject("startPost", startPost);
        modelAndView.addObject("lastPost", lastPost);
        return modelAndView;
    }

    @RequestMapping("/mine")
    public ModelAndView mine(){
        ModelAndView modelAndView = new ModelAndView("mine");
        Post startPost = postDao.start();
        Post lastPost = postDao.last();

        modelAndView.addObject("startPost", startPost);
        modelAndView.addObject("lastPost", lastPost);
        return modelAndView;
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updatePost(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("update");
        Post post = postDao.get(id);

        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @RequestMapping("/new")
    public void newPost(){
    }

    @RequestMapping("/login")
    public void login(){
    }

    @RequestMapping("/signup")
    public void signup(){
    }

    @RequestMapping("/exception")
    public void Exception() {
        throw new RuntimeException("RuntimeException");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e", e);
        return modelAndView;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public void upload() {
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(MultipartFile file, HttpServletRequest request) throws IOException {
        File path = new File(request.getServletContext().getRealPath("/")+
                "/WEB-INF/static/images/post/" + file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();

        ModelAndView modelAndView = new ModelAndView("upload");
        modelAndView.addObject("image", file.getOriginalFilename());
        return modelAndView;
    }
}
