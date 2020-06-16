package kr.ac.jejunu.post;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@Controller("/uesrServlet")
@WebServlet(urlPatterns = "/hello")
public class UserServlet extends GenericServlet {

    @Override
    public void destroy() {
        System.out.println("************* init *************");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("************* init *************");
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service!!!!");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<h1>");
        stringBuffer.append("Hello world!");
        stringBuffer.append("</h1>");
        stringBuffer.append("</html>");
        res.getWriter().println(stringBuffer.toString());
    }
}
