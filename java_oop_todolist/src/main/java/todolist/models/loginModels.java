package todolist.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import todolist.entities.userEntitiy;

public class loginModels {
    private DataSource dataSource;


public loginModels (DataSource dataSource) {
    this.dataSource = dataSource;
}

public boolean CheckUserExists(String userid) {
    String sql = "SELECT * FROM user WHERE userid = ? ";

    try (
        Connection connection = dataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)
    ) {
        stmt.setString(1,userid);
        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()) {
            // User Valid
            resultSet.close();
            return true;
        } else {
            resultSet.close();
            return false;
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}

public boolean UserPasswordValid(userEntitiy user) {
    String sql = "SELECT * FROM user WHERE userid = ? and password = ?";

    try (
        Connection connection = dataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)
    ) {
        stmt.setString(1,user.getUserid());
        stmt.setString(2,user.getPassword());
        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()) {
            // User Valid
            resultSet.close();
            return true;
        } else {
            resultSet.close();
            return false;
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}

}
