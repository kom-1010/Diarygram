package kr.ac.jejunu.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public PostDao postDao() {
        return new PostDao(connectionMaker());
    }

    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}
