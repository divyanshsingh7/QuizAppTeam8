package com.quiz.login;

import com.quiz.QuizInterface;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login implements QuizInterface {

    NewUser nu = new NewUser();
    int option;
    Scanner scan = new Scanner(System.in);

    @Override
    public void login() {
        String username = nu.getUsername();
        String pd = nu.getPassword();
        System.out.println("Enter the username and password");
        System.out.print("Username: ");
        String loggedName = scan.nextLine();
        System.out.print("Password: ");
        String loggedPd = scan.nextLine();

        if ((loggedName.equals(username)) && (loggedPd.equals(pd)))
            System.out.println("Welcome " + nu.getName() + "! to the quiz app");
        else
            createAccount();
    }
    public void createAccount() {
        try {
            System.out.println("Wrong password! Do you even have a account with us?");
            System.out.println("1. Wanna retry once again");
            System.out.println("2. Create account with us");
            option = scan.nextInt();
            scan.nextLine();                                    //Scanner is skipping nextLine() after using next(). Resolved using stackoverflow -> https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
            if (option == 1)
                login();
            else if (option == 2)
                newUser();
            else {
                System.out.println("You have not used the number displayed on the screen. Please enter the correct number");
                createAccount();
            }
        }
        catch (InputMismatchException ime) {
            System.out.println("You have not used the number. Please enter the correct number");
            scan.nextLine();
            createAccount();
        }
        catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    void newUser()
    {
        System.out.println("You need to add some details:-");
        System.out.print("Enter Name: ");
        String newName = scan.nextLine();
        System.out.print("Enter UserName: ");
        String newUserName = scan.nextLine();
        System.out.print("Enter Password: ");
        String newPassWord = scan.nextLine();

        nu.setName(newName);
        nu.setUsername(newUserName);
        nu.setPassword(newPassWord);

        login();
    }
}
