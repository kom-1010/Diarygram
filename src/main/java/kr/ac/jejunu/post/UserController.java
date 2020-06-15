package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;
    private final PostDao postDao;

    @RequestMapping("/index")
    public void index(){
    }

    @RequestMapping("/login")
    public void login(){
    }

    @RequestMapping("/mine")
    public void mine(){
    }

    @RequestMapping("/new")
    public void newPost(){
    }

    @RequestMapping("/signup")
    public void signup(){
    }

    @RequestMapping("/single")
    public void single(){
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
