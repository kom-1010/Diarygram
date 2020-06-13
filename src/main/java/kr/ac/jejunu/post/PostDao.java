package kr.ac.jejunu.post;

import java.sql.*;

public class PostDao {
    private final ConnectionMaker connectionMaker = new ConnectionMaker();

    public Post get(Integer id) throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from post_info where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Post post = new Post();
        post.setId(resultSet.getInt("id"));
        post.setTitle(resultSet.getString("title"));
        post.setContent(resultSet.getString("content"));
        post.setUser_id(resultSet.getInt("user_id"));
        post.setCreated_at(resultSet.getString("created_at"));
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return post;
    }

    public void insert(Post post) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into post_info(title, content, user_id) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, post.getTitle());
        preparedStatement.setString(2, post.getContent());
        preparedStatement.setInt(3, post.getUser_id());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        post.setId(resultSet.getInt(1));
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
