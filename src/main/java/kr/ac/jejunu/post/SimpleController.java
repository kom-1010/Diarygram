package kr.ac.jejunu.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class SimpleController implements Controller {
    private final UserDao userDao;
    private final PostDao postDao;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = userDao.get(Integer.valueOf(request.getParameter("id")));
        Post post = postDao.get(Integer.valueOf(request.getParameter("id")));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("post", post);
        return modelAndView;
    }
}
