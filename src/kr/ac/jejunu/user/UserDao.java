package kr.ac.jejunu.user;

import java.sql.*;

public class UserDao {
    public User get(Integer id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jeju?serverTimezone=Asia/Seoul",
                "jeju", "jejupw");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from character_info where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setStatus(resultSet.getString("status"));
        user.setTired(resultSet.getInt("tired"));
        user.setMental(resultSet.getInt("mental"));
        user.setMoney(resultSet.getInt("money"));
        user.setExp(resultSet.getInt("exp"));
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }
}
