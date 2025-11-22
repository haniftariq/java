package com.Homework;


import java.util.Scanner;
public class Wipro {
    public static void main(String[] args) {
        String a;
        String b;
        System.out.println("enter your company:");

        Scanner sc=new Scanner(System.in);

        a = sc.nextLine();
        System.out.println("enter your company Location:");

        Scanner s=new Scanner(System.in);
        b = s.nextLine();
        System.out.printf(a+" technologies "  +b);
    }
}

