package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
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
}
