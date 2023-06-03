package todolist.views;

import java.util.Scanner;

import todolist.usecases.TaskUsecase;

public class TaskView {
    public static void ShowListtodo(String userid) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("============================\n" +
        "User : " + userid +
        "\n List to do \n" +
        "============================");

        TaskUsecase taskUsecase = new TaskUsecase();
        taskUsecase.GetTaskList(userid);

        System.out.println("========================");
        System.out.println("==========MENU=========");
        System.out.println("========================");
        System.out.println("[1] - Add New Task\n" + 
        "[2] - Delete Task\n" + 
        "[0] - Back to Welcome Page\n");
        System.out.println("Input Menu (Number) : ");
        Integer menu = inputScanner.nextInt();

        switch(menu) {
            case 1:
                ShowAddTask(userid);
            break;
            case 2:
                ShowDeleteTask(userid);
            break;
            case 0:
                WelcomeViews.ShowWelcomeView();
            break;
        }
        inputScanner.close();

    }

    private static void ShowAddTask(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("======================\n" +
        "task : ");
        String sTask = inputScanner.nextLine();

        TaskUsecase taskUsecase = new TaskUsecase();
        taskUsecase.AddTask(sTask, userid);

        ShowListtodo(userid);
        inputScanner.close();
    }

    private static void ShowDeleteTask(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("======================\n" +
        "task : ");
        String iTask = inputScanner.nextLine();

        TaskUsecase taskUsecase = new TaskUsecase();
        taskUsecase.AddTask(iTask, userid);

        ShowListtodo(userid);
        inputScanner.close();
    }
 }
