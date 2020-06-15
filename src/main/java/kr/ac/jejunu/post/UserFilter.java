package kr.ac.jejunu.post;

import javax.servlet.*;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter Init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter Before");
        chain.doFilter(request, response);
        System.out.println("Filter After");

    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy");
    }
}
