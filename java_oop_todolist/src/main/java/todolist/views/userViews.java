package todolist.views;

import todolist.usecases.UserUsecases;
import java.util.Scanner;

public class userViews {

    public static void ShowUserMain() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("========================\n" +
        "List User");

        UserUsecases userUsecases = new UserUsecases();
        userUsecases.GetUserList();

        System.out.println("========================");
        System.out.println("==========MENU=========");
        System.out.println("========================");
        System.out.println("[1] - Add New User Account\n" +
        "[2] - Change Password\n" + 
        "[0] - Back to Welcome Page\n");
        System.out.println("Input Menu (Number) : ");
        Integer menu = inputScanner.nextInt();

        switch(menu) {
            case 1:
                ShowAddUser();
                break;
            case 2:
                ShowChangePassword();
                break;
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
        }
        inputScanner.close();
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
        ShowUserMain();
        inputScanner.close();
    }

    public static void ShowChangePassword() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("===========");
        System.out.println("userid :");
        String sUserId = inputScanner.nextLine();
        System.out.println("password :");
        String sPass = inputScanner.nextLine();

        UserUsecases userUsecases = new UserUsecases();
        userUsecases.ChangePasswordUser(sUserId, sPass);
        ShowUserMain();
        inputScanner.close();
    }
}

