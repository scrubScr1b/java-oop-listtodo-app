package todolist.views;

import java.util.Scanner;

public class WelcomeViews {
    public static void main(String[] args) {
        ShowWelcomeView();
    }

    public static void ShowWelcomeView() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Welcome to My Todo List Apps");
        System.out.println("============================\n");
        System.out.println("[1] - Login Page\n" +
        "[2] - Create Account\n" + 
        "[0] - Exit\n");
        System.out.println("Input Menu (Number) : ");
        Integer menu = inputScanner.nextInt();

        switch(menu) {
            case 1:
                System.out.println("Go to Menu Login Page");
                break;
            case 2:
                userViews.ShowUserMain();
                break;
            case 0:
                System.out.println("App Closed");
                break;
        }
        inputScanner.close();
    }
}
