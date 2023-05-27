package todolist.views;

import todolist.usecases.UserUsecases;
import java.util.Scanner;

public class userViews {

    public static void ShowUserMain() {
        Scanner inputScanner = new Scanner(System.in);

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
                UserUsecases.ShowAddUser();
                break;
            case 2:
                
                break;
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
        }
        inputScanner.close();
    }
    
}
