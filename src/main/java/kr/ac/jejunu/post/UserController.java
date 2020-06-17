package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;
    private final PostDao postDao;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping("/login")
    public void login(){
    }

    @RequestMapping("/mine/")
    public ModelAndView mine(@PathVariable("user") User user){
        ModelAndView modelAndView = new ModelAndView("mine");
        return modelAndView;
    }

    @RequestMapping("/new")
    public void newPost(){
    }

    @RequestMapping("/signup")
    public void signup(){
    }

    @RequestMapping("/single/{id}")
    public ModelAndView single(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("single");
        Post post = postDao.get(id);
        User user = userDao.get(post.getUser_id());
        modelAndView.addObject("post", post);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/user")
    public ModelAndView getPost(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Post post = postDao.get(id);
        User user = userDao.get(post.getUser_id());
        modelAndView.addObject("post", post);
        modelAndView.addObject("user", user);
        return modelAndView;
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
