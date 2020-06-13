package kr.ac.jejunu.post;

import java.sql.*;

public class PostDao {
    public static Post get(Integer id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
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
    
    public void insert(Post post) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into post_info(username, password, title, content) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, post.getUsername());
        preparedStatement.setString(2, post.getPassword());
        preparedStatement.setString(3, post.getTitle());
        preparedStatement.setString(4, post.getContent());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        post.setId(resultSet.getInt(1));
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/jeju?serverTimezone=Asia/Seoul"
                , "jeju", "jejupw");
    }
}
