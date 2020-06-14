package kr.ac.jejunu.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Post get(Integer id) {
        Object[] params = new Object[] {id};
        String sql = "select * from post_info where id = ?";
        return jdbcTemplate.query(sql, params, rs -> {
            Post post = null;
            if (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setUser_id(rs.getInt("user_id"));
                post.setCreated_at(rs.getString("created_at"));
            }
            return post;
        });
    }

    public void insert(Post post) {
        Object[] params = new Object[] {post.getTitle(), post.getContent(), post.getUser_id()};
        String sql = "insert into post_info(title, content, user_id) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i=0;i<params.length;i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement;
        }, keyHolder);
        post.setId(keyHolder.getKey().intValue());
    }

    public void update(Post post) {
        Object[] params = new Object[] {post.getTitle(), post.getContent(), post.getUser_id(), post.getId()};
        String sql = "update post_info set title = ?, content = ?, user_id = ? where id = ?";
        jdbcTemplate.update(sql, params);
    }

    public void delete(Integer id) {
        Object[] params = new Object[] {id};
        String sql = "delete from post_info where id = ?";
        jdbcTemplate.update(sql, params);
    }
}
