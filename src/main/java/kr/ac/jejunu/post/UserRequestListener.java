package kr.ac.jejunu.post;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

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
