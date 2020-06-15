package kr.ac.jejunu.post;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class UserServlet extends GenericServlet {
    private UserDao userDao;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("************* serv *************");
    }

    @Override
    public void destroy() {
        System.out.println("************* dest *************");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("************* init *************");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu.post");
        this.userDao = applicationContext.getBean("userDao", UserDao.class);
        super.init();
    }
}
