package kr.ac.jejunu.post;

import groovyjarjarpicocli.CommandLine;
import lombok.RequiredArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@org.springframework.web.bind.annotation.RestController
@Controller
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestController {
    private final UserDao userDao;
    private final PostDao postDao;

    @GetMapping("/{id}")
    public ModelMap get(@PathVariable("id") Integer id) {
        ModelMap modelMap = new ModelMap();
        Post post = postDao.get(id);
        User user = userDao.get(post.getUser_id());
        modelMap.addAttribute(post);
        modelMap.addAttribute(user);
        return modelMap;
    }

    @PostMapping("/signup")
    public View createUser(String username, String password, String checkPassword){
        String url = "/signup";
        if(password.equals(checkPassword)) {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            userDao.insert(user);
            url = "/";
        }
        return new RedirectView(url);
    }

    @PostMapping("/login")
    public View login(String username, String password, HttpSession session) {
        String url = "/login";
        User user = userDao.get(username);
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
    public View createPost(String title, String content, HttpSession session) {
        String url = "/new";
        Post post = new Post();
        User user = (User) session.getAttribute("user");

        if(user!=null) {
            post.setTitle(title);
            post.setContent(content);
            post.setUser_id(user.getId());
            postDao.insert(post);
            url = "/";
        }
        return new RedirectView(url);
    }
}
