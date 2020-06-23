package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final PostDao postDao;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        Integer startId = postDao.findAll().get(0).getId();
        Integer lastId = postDao.findAll().get(postDao.findAll().size()-1).getId();

        modelAndView.addObject("startId", startId);
        modelAndView.addObject("lastId", lastId);
        return modelAndView;
    }

    @RequestMapping("/mine")
    public ModelAndView mine(){
        ModelAndView modelAndView = new ModelAndView("mine");
        Integer startId = postDao.findAll().get(0).getId();
        Integer lastId = postDao.findAll().get(postDao.findAll().size()-1).getId();

        modelAndView.addObject("startId", startId);
        modelAndView.addObject("lastId", lastId);
        return modelAndView;
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updatePost(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("update");
        Post post = postDao.findById(id).get();

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
