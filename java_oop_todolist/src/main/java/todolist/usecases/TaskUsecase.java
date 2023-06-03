package todolist.usecases;

import com.zaxxer.hikari.HikariDataSource;

import todolist.entities.TaskEntity;
import todolist.models.TaskModel;
import todolist.utils.DBConnectionUtil;

public class TaskUsecase {

    private HikariDataSource dataSource;

    private TaskModel taskModel;

    public TaskUsecase() {
        dataSource = DBConnectionUtil.getDataSource();
        taskModel = new TaskModel(dataSource);
    }

    public void GetTaskList(String userid) {
        TaskEntity[] taskList = taskModel.FindAllTask(userid);
        for (TaskEntity task : taskList) {
            System.out.println(task.getId()+" - " + task.getTask());
        }
    }

    public void AddTask(String task, String userid) {
        TaskEntity taskData = new TaskEntity();
        taskData.setTask(task);
        taskData.setUserid(userid);

        taskModel.CreateTask(taskData);
        System.out.println("Create Task Succeed!");
    }

    public void DeleteTask(Integer id) {
        taskModel.DeleteTask(id);
        System.out.println("Delete Task Succeed!");
    }
    
}
