package com.day7;

import java.io.IOException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        try {
            String s=null;
            System.out.println(s.length());
        }
        catch (ArithmeticException e){
            System.out.println("Arithmetic Exception "+e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException: "+e.getMessage());
        }catch(Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
        finally {
            sc.close();
        }
        System.out.println("Last line of the program");
    }
}
