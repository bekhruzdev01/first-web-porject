package com.example.demo;

import com.example.demo.DBService.DbService;
import com.example.demo.model.Result;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class Demo1Application {
    @SneakyThrows
    public static void main(String[] args){
        System.out.println("Hello World");
//        SpringApplication.run(Demo1Application.class, args);
        Result result = new Result();
        Scanner scanner = new Scanner(System.in);
        DbService dbService = new DbService();
        int step = 0;
        while (step !=-1) {
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
            }
        }
    }

}
