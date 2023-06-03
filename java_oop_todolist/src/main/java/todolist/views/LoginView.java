package todolist.views;

import java.util.Scanner;

import todolist.usecases.LoginUsecase;

public class LoginView {

    public static void ShowLoginPage() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("=========================\n"+
        "Login Page\n"+
        "=========================");

        System.out.println("USER ID :");
        String userid = inputScanner.nextLine();

        System.out.println("PASSWORD :");
        String pass = inputScanner.nextLine();

        LoginUsecase loginUsecase = new LoginUsecase();
        String sValidate = loginUsecase.LoginValidate(userid, pass);

        if (sValidate.equals("")) {
            System.out.println("LOGIN SUCCESS !!!");
            TaskView.ShowListtodo(userid);
        } else {
            System.out.println();
            System.out.println("LOGIN FAILED - " +sValidate);
        }
        System.out.println("========================");
        System.out.println("==========MENU=========");
        System.out.println("========================");
        System.out.println("[1] - Login Page\n" + 
        "[0] - Back to Welcome Page\n");
        System.out.println("Input Menu (Number) : ");
        Integer menu = inputScanner.nextInt();

        switch(menu) {
            case 1:
                ShowLoginPage();
            break;
            case 0:
                WelcomeViews.ShowWelcomeView();
            break;
        }
        inputScanner.close();

    }
    
}
