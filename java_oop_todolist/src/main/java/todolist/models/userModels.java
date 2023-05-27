package todolist.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import todolist.entities.userEntitiy;

public class userModels {
    private DataSource dataSource;
    
    public userModels(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void CreateUser (userEntitiy user) {
        String sql = "INSERT INTO user Values (?, ?, now())";

        try(
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setString(1, user.getUserid());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            // TODO: handle exception
            throw new RuntimeException(ex);
        }
    }
}
