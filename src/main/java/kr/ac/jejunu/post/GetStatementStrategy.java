package kr.ac.jejunu.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        Integer id = (Integer) object;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("select * from user_info where id = ?");
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
