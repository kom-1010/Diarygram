package kr.ac.jejunu.post;

import groovyjarjarpicocli.CommandLine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@Controller
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestController {
    private final UserDao userDao;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userDao.get(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        userDao.insert(user);
        return user;
    }
}
