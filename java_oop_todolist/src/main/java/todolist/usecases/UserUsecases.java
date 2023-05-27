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

    public void AddUser(String userid, String pass) {
        userEntitiy userData = new userEntitiy();
        userData.setUserId(userid);
        userData.setPassword(pass);
        userModels.CreateUser(userData);
        System.out.println("Created User Succed!");
    }

    public static void ShowAddUser() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("===========");
        System.out.println("userid :");
        String sUserId = inputScanner.nextLine();
        System.out.println("password :");
        String sPass = inputScanner.nextLine();

        UserUsecases userUsecases = new UserUsecases();
        userUsecases.AddUser(sUserId, sPass);
        inputScanner.close();
    }
}
