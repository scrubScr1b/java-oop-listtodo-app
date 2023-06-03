package todolist.entities;

public class TaskEntity {
    private Integer id;

    private String task;

    private String userid;


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id =id;}
    public String getUserid() {return userid;}
    public void setUserid(String userid) {this.userid = userid;}
    public String getTask() {return task;}
    public void setTask(String task) {this.task = task;}
}
