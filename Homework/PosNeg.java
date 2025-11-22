package com.Homework;


import java.util.Scanner;

class PosNeg {
    public static void main(String[] args){
        int a;
        System.out.println("Enter an Number: ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();


        if(a>0)
        {
            System.out.println("ENTERED NUMBER IS POSITIVE!");

        }
        else if (a<0)
        {
            System.out.println("ENTERED NUMBER IS NEGATIVE!");
        }
        else {
            System.out.println("ENTERED NUMBER IS ZERO !");}


    }
}


