package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MainController {
    private final PostDao postDao;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Post> posts = postDao.findAll();
        return getModelAndView(modelAndView, posts);
    }

    @RequestMapping("/mine/{user_id}")
    public ModelAndView mine(@PathVariable Integer user_id){
        ModelAndView modelAndView = new ModelAndView("mine");
        List<Post> posts = postDao.findByUser_id(user_id);
        return getModelAndView(modelAndView, posts);
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updatePost(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("post", postDao.findById(id).get());
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

    // posts 의 처음 id와 마지막 id를 modelAndView 에 넣어 반환
    private ModelAndView getModelAndView(ModelAndView modelAndView, List<Post> posts) {
        Integer startId = posts.get(0).getId();
        Integer lastId = posts.get(posts.size() - 1).getId();

        modelAndView.addObject("startId", startId);
        modelAndView.addObject("lastId", lastId);
        return modelAndView;
    }

}
