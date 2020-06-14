package kr.ac.jejunu.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetStatementStrategy implements StatementStrategy {
    private Integer id;

    public GetStatementStrategy(Integer id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("select * from user_info where id = ?");
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
