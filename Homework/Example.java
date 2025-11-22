package com.Homework;

class Example {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("banana , apple , grapes");
        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1)
                    System.out.print(","); // Print comma between arguments
            }
        }
    }
}

