package com.tatafo;

import com.tatafo.Controllers.DiaryControllers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static java.lang.System.in;

@SpringBootApplication
public class Main {
//    Scanner input = new Scanner(in);
    private static DiaryControllers diaryControllers = new DiaryControllers();
    private static String currentUserName;
    public static void main(String...args) {
        SpringApplication.run(Main.class, args);

//        displayMethod("""
//                1. Register
//                2. Login""");
//        String option = inputMethod("Enter option:  ");
//        if (option.equalsIgnoreCase("1"))
//            register();
//        if (option.equalsIgnoreCase("2"))
//            login();
//        else {
//            displayMethod("Invalid input");
//            main();
//        }
    }

//
//
//    private static void displayMethod(String message) {
//        JOptionPane.showMessageDialog(null, message);
//    }
//
//    private static String inputMethod(String prompt) {
//    return JOptionPane.showInputDialog(null, prompt);
//    }
//
//    private static void register() {
//        try {
//            String userName = inputMethod("Create user name:  ");
//            String password = inputMethod("Create your password:  ");
//            RegisterUserRequest registerUserRequest = new RegisterUserRequest();
//            registerUserRequest.setUserName(userName);
//            registerUserRequest.setPassword(password);
//            diaryControllers.registerUser(registerUserRequest);
//            displayMethod("Registration Successful");
//        } catch (IllegalArgumentException ex) {
//            displayMethod(ex.getMessage());
//        }
//        login();
//    }
//    private static void login() {
//        try {
//            String userName = inputMethod("Enter user name:  ");
//            String password = inputMethod("Enter your password:  ");
//            LoginRequest loginRequest = new LoginRequest();
//            loginRequest.setUserName(userName);
//            loginRequest.setPassword(password);
//            diaryControllers.unlockDiary(loginRequest);
//            currentUserName = userName;
//            displayMethod("Login Successful");
//        } catch (IllegalArgumentException ex) {
//            displayMethod(ex.getMessage());
//        }
//        userPage();
//
//    }
//
//    private static void userPage(){
//        displayMethod("""
//                1. Create Entry
//                2. Find Entry
//                3. update Entry
//                4. Delete Entry
//                5. LogOut""");
//        String option = inputMethod("Enter option:  ");
//        switch (option) {
//            case "1":
//                createEntry();
//                break;
//            case "2":
//                findEntry();
//                break;
//            case "3":
//                updateEntry();
//                break;
//            case "4":
//                deleteEntry();
//                break;
//            case "5":
//                logout();
//        }
//    }
//    private static void createEntry() {
//        String title = inputMethod("Enter title:  ");
//        String body = inputMethod("Enter the contents:  ");
//        diaryControllers.createEntry(currentUserName, title, body);
//        displayMethod("Entry Created Successfully");
//    }
//
//    private static void findEntry() {
//        try {
//            String userName = inputMethod("Enter your username:  ");
//            diaryControllers.findDiary(userName);
//            displayMethod("Account Found");
//        } catch (IllegalArgumentException foundBoo) {
//            displayMethod(foundBoo.getMessage());
//        }
//        userPage();
//    }
//
//    private static void updateEntry() {
//        try {
//            String userName = inputMethod("Enter your username:  ");
//            String title = inputMethod("Enter title:  ");
//            String body = inputMethod("Enter the contents:  ");
//            diaryControllers.updateEntry(currentUserName, title, body);
//        } catch (IllegalArgumentException entryUpdated) {
//            displayMethod(entryUpdated.getMessage());
//        }
//        userPage();
//    }
//
//    private static void deleteEntry() {
//        try {
//            String password = inputMethod("Enter password:  ");
//            diaryControllers.delete(currentUserName, password);
//            displayMethod("Deleted Successfully");
//        } catch (IllegalArgumentException ex) {
//            displayMethod(ex.getMessage());
//        }
//        userPage();
//    }
//    private static void logout() {
//        String lockedDiary = diaryControllers.lock(currentUserName);
//        displayMethod(lockedDiary);
//        exit(5);
//
//    }


}