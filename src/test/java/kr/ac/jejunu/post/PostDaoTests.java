package kr.ac.jejunu.post;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class PostDaoTests {

    private static PostDao postDao;

    @BeforeAll
    public static void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        postDao = applicationContext.getBean("postDao", PostDao.class);
    }

    String title = "Hi!";
    String content = "My name is Youngsu";
    Integer user_id = 2;

    @Test
    public void get() {
        Integer id = 1;
        String title = "Hello";
        String content = "My name is Jinsu!";
        Integer user_id = 1;
        String created_at = "2020-06-13 19:52:41";

        Post post = postDao.get(id);
        assertThat(post.getId(), is(id));
        assertThat(post.getTitle(), is(title));
        assertThat(post.getContent(), is(content));
        assertThat(post.getUser_id(), is(user_id));
        assertThat(post.getCreated_at(), is(created_at));
    }

    @Test
    public void insert() {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUser_id(user_id);
        postDao.insert(post);
        assertThat(post.getId(), greaterThan(0));

        Post insertedPost = postDao.get(post.getId());
        assertThat(insertedPost.getTitle(), is(title));
        assertThat(insertedPost.getContent(), is(content));
        assertThat(insertedPost.getUser_id(), is(user_id));
    }

    @Test
    public void update() {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUser_id(user_id);
        postDao.insert(post);

        String updatedTitle = "Bye";
        String updatedContent = "My name is Jongchul";
        Integer updatedUser_id = 3;

        post.setTitle(updatedTitle);
        post.setContent(updatedContent);
        post.setUser_id(updatedUser_id);
        postDao.update(post);

        Post updatedPost = postDao.get(post.getId());
        assertThat(updatedPost.getTitle(), is(updatedTitle));
        assertThat(updatedPost.getContent(), is(updatedContent));
        assertThat(updatedPost.getUser_id(), is(updatedUser_id));
    }

    @Test
    public void delete() {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUser_id(user_id);
        postDao.insert(post);

        postDao.delete(post.getId());

        Post deletedPost = postDao.get(post.getId());
        assertThat(deletedPost, IsNull.nullValue());
    }
}
