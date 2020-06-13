package kr.ac.jejunu.post;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class PostDaoTests {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String username = "jinsu";
        String password = "1111";
        String title = "hello!";
        String content = "hello world";
        String created_at = "2020-06-13 10:17:24";
        PostDao postDao = new PostDao();
        Post post = postDao.get(id);
        assertThat(post.getId(), is(id));
        assertThat(post.getUsername(), is(username));
        assertThat(post.getPassword(), is(password));
        assertThat(post.getTitle(), is(title));
        assertThat(post.getContent(), is(content));
        assertThat(post.getCreated_at(), is(created_at));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        String username = "youngsu";
        String password = "2222";
        String title = "hello!";
        String content = "hello world";

        Post post = new Post();
        post.setUsername(username);
        post.setPassword(password);
        post.setTitle(title);
        post.setContent(content);
        PostDao postDao = new PostDao();
        postDao.insert(post);
        assertThat(post.getId(), greaterThan(0));

        Post insertedPost = PostDao.get(post.getId());
        assertThat(insertedPost.getUsername(), is(username));
        assertThat(insertedPost.getPassword(), is(password));
        assertThat(insertedPost.getTitle(), is(title));
        assertThat(insertedPost.getContent(), is(content));
    }
}
