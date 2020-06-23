package kr.ac.jejunu.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.awt.print.Pageable;
import java.sql.*;
import java.util.List;


public interface PostDao extends JpaRepository<Post, Integer> {
    @Query("select p from post_info p where p.user_id = ?1 and p.id = ?2")
    Post findByUser_idAndId(Integer userId, Integer id);

    @Query("update post_info p set p.likes = p.likes + 1 where p.id = ?1")
    void like(Integer id);

    @Query("delete from post_info p where p.id = ?1")
    void delete(Integer id);



//    // post_info 테이블의 id를 입력하여 가져온다.
//    public Post get(Integer id) {
//        Object[] params = new Object[] {id};
//        String sql = "select * from post_info where id = ?";
//        return jdbcTemplate.query(sql, params, rs -> {
//            Post post = null;
//            if (rs.next()) {
//                post = new Post();
//                post.setId(rs.getInt("id"));
//                post.setTitle(rs.getString("title"));
//                post.setContent(rs.getString("content"));
//                post.setUser_id(rs.getInt("user_id"));
//                post.setCreated_at(rs.getString("created_at"));
//                post.setLikes(rs.getInt("likes"));
//                post.setImage(rs.getString("image"));
//            }
//            return post;
//        });
//    }
//
//    // post_info 테이블의 user_id와 id를 입력하여 가져온다.
//    public Post get(Integer userId, Integer id) {
//        Object[] params = new Object[] {id, userId};
//        String sql = "select * from post_info where id = ? and user_id = ?";
//        return jdbcTemplate.query(sql, params, rs -> {
//            Post post = null;
//            if (rs.next()) {
//                post = new Post();
//                post.setId(rs.getInt("id"));
//                post.setTitle(rs.getString("title"));
//                post.setContent(rs.getString("content"));
//                post.setUser_id(rs.getInt("user_id"));
//                post.setCreated_at(rs.getString("created_at"));
//                post.setLikes(rs.getInt("likes"));
//                post.setImage(rs.getString("image"));
//            }
//            return post;
//        });
//    }
//
//    // post_info 테이블의 마지막 행을 가져온다.
//    public Post start() {
//        String sql = "select * from post_info limit 1";
//        return jdbcTemplate.query(sql, rs -> {
//            Post post = null;
//            if (rs.next()) {
//                post = new Post();
//                post.setId(rs.getInt("id"));
//                post.setTitle(rs.getString("title"));
//                post.setContent(rs.getString("content"));
//                post.setUser_id(rs.getInt("user_id"));
//                post.setCreated_at(rs.getString("created_at"));
//                post.setLikes(rs.getInt("likes"));
//                post.setImage(rs.getString("image"));
//            }
//            return post;
//        });
//    }
//
//    // post_info 테이블의 마지막 행을 가져온다.
//    public Post last() {
//        String sql = "select * from post_info order by id desc limit 1";
//        return jdbcTemplate.query(sql, rs -> {
//            Post post = null;
//            if (rs.next()) {
//                post = new Post();
//                post.setId(rs.getInt("id"));
//                post.setTitle(rs.getString("title"));
//                post.setContent(rs.getString("content"));
//                post.setUser_id(rs.getInt("user_id"));
//                post.setCreated_at(rs.getString("created_at"));
//                post.setLikes(rs.getInt("likes"));
//                post.setImage(rs.getString("image"));
//            }
//            return post;
//        });
//    }
//
//    public void insert(Post post) {
//        Object[] params = new Object[] {post.getTitle(), post.getContent(), post.getUser_id(), post.getImage()};
//        String sql = "insert into post_info(title, content, user_id, image) values (?, ?, ?, ?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(con -> {
//            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            for (int i=0;i<params.length;i++) {
//                preparedStatement.setObject(i+1, params[i]);
//            }
//            return preparedStatement;
//        }, keyHolder);
//        post.setId(keyHolder.getKey().intValue());
//    }
//
//    public void update(Post post) {
//        Object[] params = new Object[] {post.getTitle(), post.getContent(), post.getLikes(), post.getImage(), post.getId()};
//        String sql = "update post_info set title = ?, content = ?, likes = ?, image = ? where id = ?";
//        jdbcTemplate.update(sql, params);
//    }
//
//    public void like(Integer id) {
//        Object[] params = new Object[] {id};
//        String sql = "update post_info set likes = likes + 1 where id = ?";
//        jdbcTemplate.update(sql, params);
//    }
//
//    public void delete(Integer id) {
//        Object[] params = new Object[] {id};
//        String sql = "delete from post_info where id = ?";
//        jdbcTemplate.update(sql, params);
//    }
}
