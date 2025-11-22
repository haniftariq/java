package com.day4;

 class EncapsulationDemo {
}
class Student {
    private int rno;
    private String name;
    private int[] marks;


    public Student(int rno, String name, int[] marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    public int getRno() {
        return rno;
    }

    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }

    public double getAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public void display() {
        System.out.println("Reg No: " + rno);
        System.out.println("Name  : " + name);
        System.out.print("Marks : ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nAverage: " + String.format("%.2f", getAverage()));
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Student s1 = new Student(404, "chinrasu", new int[]{35,35,35,35,35});
        s1.display();
    }
}

