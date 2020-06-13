package kr.ac.jejunu.post;

import java.sql.*;

public class PostDao {
    public Post get(Integer id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jeju?serverTimezone=Asia/Seoul"
            , "jeju", "jejupw");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from post_info where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Post post = new Post();
        post.setId(resultSet.getInt("id"));
        post.setUsername(resultSet.getString("username"));
        post.setPassword(resultSet.getString("password"));
        post.setTitle(resultSet.getString("title"));
        post.setContent(resultSet.getString("content"));
        post.setCreated_at(resultSet.getString("created_at"));
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return post;
    }
}
