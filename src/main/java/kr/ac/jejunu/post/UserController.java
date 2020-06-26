package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@org.springframework.web.bind.annotation.RestController
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserDao userDao;
    private final FileHandler fileHandler;

    @PostMapping("/signup")
    public View createUser(MultipartFile profile, String username, String password, String checkPassword, HttpServletRequest request, HttpSession session) throws IOException {
        String url = "/signup";

        if(password.equals(checkPassword)) {
            User user = new User();
            String filename = "";

            user.setName(username);
            user.setPassword(password);
            user.setProfile(filename);
            userDao.save(user);

            filename = fileHandler.getFilename(profile, username, user.getId());
            user.setProfile(filename);
            userDao.save(user);

            fileHandler.fileSave(request, profile, filename, "/WEB-INF/static/images/user/");

            session.setAttribute("user", user);

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

    @PostMapping("/profile/{id}")
    public View updateProfile(@PathVariable("id") Integer id, MultipartFile profile, String username, HttpServletRequest request, HttpSession session) throws IOException {
        User user = userDao.findById(id).get();
        String filename = fileHandler.getFilename(profile, username, id);

        user.setName(username);
        user.setProfile(filename);
        userDao.save(user);

        fileHandler.fileSave(request, profile, filename, "/WEB-INF/static/images/user/");

        session.setAttribute("user", user);

        return new RedirectView("/");
    }

}
