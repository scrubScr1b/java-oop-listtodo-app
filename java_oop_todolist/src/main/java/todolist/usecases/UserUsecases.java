package todolist.usecases;

import java.util.Scanner;

import com.zaxxer.hikari.HikariDataSource;

import todolist.entities.userEntitiy;
import todolist.models.userModels;
import todolist.utils.DBConnectionUtil;

public class UserUsecases {
    private HikariDataSource dataSource;
    private userModels userModels;

    public UserUsecases () {
        dataSource = DBConnectionUtil.getDataSource();
        userModels = new userModels(dataSource);
    }

    public void GetUserList() {
        userEntitiy[] userlist = userModels.FindAllUser();
        for (userEntitiy user : userlist) {
            System.out.println("- "+ user.getUserid());
        }
    }

    public void AddUser(String userid, String pass) {
        userEntitiy userData = new userEntitiy();
        userData.setUserId(userid);
        userData.setPassword(pass);
        userModels.CreateUser(userData);
        System.out.println("Created User Succed!");
    }

    public void ChangePasswordUser(String newuserid, String newpass) {
        userEntitiy userData = new userEntitiy();
        userData.setUserId(newuserid);
        userData.setPassword(newpass);
        userModels.ChangePassword(userData);
        System.out.println("Change Password Succed!");
    }


}
