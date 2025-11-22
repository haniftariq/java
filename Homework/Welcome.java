package com.Homework;
import java.util.Scanner;

public class Welcome {
    public static void main(String args[]) {
        System.out.println("Enter your name:");
        Scanner s=new Scanner(System.in);
        String name=s.next();
        System.out.println("Welcome "+name+ " !");
    }
}

