package todolist.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import todolist.entities.userEntitiy;

public class userModels {
    private DataSource dataSource;
    
    public userModels(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void CreateUser (userEntitiy user) {
        String sql = "INSERT INTO user VALUES (?, ?, now())";

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

    public void ChangePassword (userEntitiy user) {
        String sql = "UPDATE user set password = ? WHERE userid = ?";

        try(
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getUserid());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            // TODO: handle exception
            throw new RuntimeException(ex);
        }
    }

    public userEntitiy[] FindAllUser() {
        String sql = "SELECT * FROM user";

        try(
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
        ) {
            List<userEntitiy> list = new ArrayList<>();
            while(resultSet.next()) {
                userEntitiy user = new userEntitiy();
                user.setUserId(resultSet.getString("userid"));
                list.add(user);
            } return list.toArray(new userEntitiy[]{});
        } catch (SQLException ex) {
            // TODO: handle exception
            throw new RuntimeException(ex);
        }
    }

}
