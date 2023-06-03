package todolist.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import todolist.entities.TaskEntity;

public class TaskModel {
    private DataSource dataSource;

    public TaskModel(DataSource datasSource) { this.dataSource = datasSource; }

    public TaskEntity[] FindAllTask(String userid) {
        String sql = "SELECT * FROM task WHERE userid =?";
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) { 
            stmt.setString(1, userid);
            ResultSet resultSet = stmt.executeQuery();
            List<TaskEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                TaskEntity task = new TaskEntity();
                task.setId(resultSet.getInt("id"));
                task.setTask(resultSet.getString("task"));
                task.setUserid(resultSet.getString("userid"));
                list.add(task);
            }
            return list.toArray(new TaskEntity[]{});
        } catch (SQLException ex) {
            // TODO: handle exception
            throw new RuntimeException(ex);
        }
    }

    public void CreateTask(TaskEntity task) {
        String sql = "INSERT INTO task (task, userid, created_at) VALUES (?, ?, now())";
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setString(1, task.getTask());
            stmt.setString(2, task.getUserid());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            // TODO: handle exception
            throw new RuntimeException(ex);
        }
    }

    public void DeleteTask(Integer taskid) {
        String sql = "DELETE FROM task WHERE id = ?";
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setInt(1, taskid);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            // TODO: handle exception
            throw new RuntimeException(ex);
        }
    }
}
