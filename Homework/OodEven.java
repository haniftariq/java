package com.Homework;


import java.util.Scanner;


public class OodEven {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int remain = n % 2;
        if (remain == 0) {
            System.out.println("Enterted number is Even!");
        }
        else {
            System.out.println("Entered number is Odd!");

        }
    }



}
