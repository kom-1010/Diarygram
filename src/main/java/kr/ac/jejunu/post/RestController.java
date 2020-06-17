package kr.ac.jejunu.post;

import groovyjarjarpicocli.CommandLine;
import lombok.RequiredArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping
    public User create(@RequestBody User user) {
        userDao.insert(user);
        return user;
    }
}
