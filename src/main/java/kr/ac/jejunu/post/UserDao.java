package kr.ac.jejunu.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User get(Integer id) {
        Object[] params = new Object[] {id};
        String sql = "select * from user_info where id = ?";
        return jdbcTemplate.query(sql, params, rs -> {
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setProfile(rs.getString("profile"));
            }
            return user;
        });
    }

    public User get(String name) {
        Object[] params = new Object[] {name};
        String sql = "select * from user_info where name = ?";
        return jdbcTemplate.query(sql, params, rs -> {
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setProfile(rs.getString("profile"));
            }
            return user;
        });
    }

    public void insert(User user) {
        Object[] params = new Object[] {user.getName(), user.getPassword(), user.getProfile()};
        String sql = "insert into user_info(name, password, profile) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i=0;i<params.length;i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement;
        }, keyHolder);
        user.setId(keyHolder.getKey().intValue());
    }

    public void update(User user) {
        Object[] params = new Object[] {user.getName(), user.getPassword(), user.getProfile(), user.getId()};
        String sql = "update user_info set name = ?, password = ?, profile = ? where id = ?";
        jdbcTemplate.update(sql, params);
    }

    public void delete(Integer id) {
        Object[] params = new Object[] {id};
        String sql = "delete from user_info where id = ?";
        jdbcTemplate.update(sql, params);
    }

}
