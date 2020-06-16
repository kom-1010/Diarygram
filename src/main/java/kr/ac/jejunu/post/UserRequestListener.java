package kr.ac.jejunu.post;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class UserRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request Destroy");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request Init");
    }
}
