package com.example.demo;

import com.example.demo.DBService.DbService;
import com.example.demo.model.DUser;
import com.example.demo.model.Result;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Demo1Application {
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Hello World");
//        SpringApplication.run(Demo1Application.class, args);
        Result result = new Result();
        Scanner scanner = new Scanner(System.in);
        DbService dbService = new DbService();
        int step = 0;
        while (step != -1) {
            System.out.println("0-Exit,1-Save,2-View,3-Edit,4-Delete");
            step = scanner.nextInt();

            switch (step) {
                case 0:
                    System.out.println("Exit");
                    step = -1;
                    break;
                case 1:
                    System.out.println("Save");
                    System.out.print("Name:");
                    String name = scanner.next();
                    System.out.print("Surname:");
                    String surname = scanner.next();

                    System.out.println(dbService.addUser(name, surname, result).getMessage());
                    break;
                case 2:
                    System.out.println("View");
                    for (DUser user : dbService.getUser()) {
                        System.out.println("ID: " + user.getId() + " Name: " + user.getName() + " Surname: " + user.getSurname());
                    }
                    break;
                case 3:
                    System.out.println("Edit");
                    System.out.print("Id: ");
                    int id = scanner.nextInt();
                    System.out.print("Name:");
                    String EditName = scanner.next();
                    System.out.print("Surname:");
                    String EditSurname = scanner.next();

                    System.out.println(dbService.editUser(id, EditName, EditSurname, result).getMessage());
                    break;
                case 4:
                    System.out.println("Delete");
                    System.out.print("Id: ");
                    System.out.println(dbService.deleteUser(scanner.nextInt()));
                    break;
            }
        }
    }

}
