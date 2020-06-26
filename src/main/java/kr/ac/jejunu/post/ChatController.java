package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatDao chatDao;
    private final UserDao userDao;

    @GetMapping("/{post_id}")
    public ModelMap getChat(@PathVariable("post_id") Integer post_id) {
        ModelMap modelMap = new ModelMap();
        List<Chat> chat = chatDao.findByPost_id(post_id);
        List<User> user = new ArrayList<>();

        for (int i = 0, n = chat.size(); i < n; i++) user.add(userDao.findById(chat.get(i).getUser_id()).get());

        modelMap.addAttribute(chat);
        modelMap.addAttribute(user);

        return modelMap;
    }

    @PostMapping("")
    public Chat createChat(@RequestBody Chat chat, HttpSession session) {
        User user = (User) session.getAttribute("user");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String createdAt = simpleDateFormat.format(date);

        chat.setUser_id(user.getId());
        chat.setCreated_at(createdAt);
        chatDao.save(chat);

        return chat;
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable("id") Integer id) {
        chatDao.delete(chatDao.findById(id).get());
    }

}
