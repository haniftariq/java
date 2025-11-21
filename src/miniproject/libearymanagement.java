package miniproject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// ---------------------- Custom Exceptions ----------------------
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}

class InvalidReturnException extends Exception {
    public InvalidReturnException(String msg) {
        super(msg);
    }
}

// ---------------------- Book Class ----------------------
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }

    @Override
    public String toString() {
        return "Book ID: " + id +
                ", Title: " + title +
                ", Author: " + author +
                ", Status: " + (isIssued ? "Issued" : "Available");
    }
}

// ---------------------- Member Class ----------------------
class Member {
    private String memberId;
    private String name;
    private List<String> borrowedBookIds;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBookIds = new ArrayList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<String> getBorrowedBookIds() { return borrowedBookIds; }

    public void borrowBook(String bookId) {
        borrowedBookIds.add(bookId);
    }

    public void returnBook(String bookId) {
        borrowedBookIds.remove(bookId);
    }
}

// ---------------------- Library Class ----------------------
class Library {
    HashMap<String, Book> inventory = new HashMap<>();
    HashMap<String, Member> members = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getId(), book);
        logOperation("Added Book: " + book.getTitle());
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        logOperation("Added Member: " + member.getName());
    }

    public void issueBook(String bookId, String memberId) throws BookNotAvailableException {
        Book book = inventory.get(bookId);
        Member member = members.get(memberId);

        if (book == null || book.isIssued())
            throw new BookNotAvailableException("Book is not available!");

        if (member == null)
            throw new BookNotAvailableException("Member not found!");

        book.setIssued(true);
        member.borrowBook(bookId);

        logOperation("Issued Book: " + bookId + " to Member: " + memberId);
    }

    public void returnBook(String bookId, String memberId, int daysLate) throws InvalidReturnException {
        Book book = inventory.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null || !member.getBorrowedBookIds().contains(bookId))
            throw new InvalidReturnException("Invalid return attempt!");

        book.setIssued(false);
        member.returnBook(bookId);

        int fine = daysLate * 2;
        logOperation("Returned Book: " + bookId + " by Member: " + memberId + ", Fine: ₹" + fine);

        System.out.println("Book returned successfully. Fine = ₹" + fine);
    }

    public void showInventory() {
        System.out.println("\n---- Library Inventory ----");
        for (Book book : inventory.values()) {
            System.out.println(book);
        }
    }

    public void logOperation(String msg) {
        try (FileWriter fw = new FileWriter("library_log.txt", true)) {
            fw.write(msg + "\n");
        } catch (IOException e) {
            System.out.println("Error logging operation.");
        }
    }
}

// ---------------------- MAIN CLASS ----------------------
public class libearymanagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        library.addBook(new Book(id, title, author));
                        System.out.println("Book added.");
                        break;

                    case 2:
                        System.out.print("Enter Member ID: ");
                        String mid = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String mname = sc.nextLine();

                        library.addMember(new Member(mid, mname));
                        System.out.println("Member added.");
                        break;

                    case 3:
                        System.out.print("Enter Book ID: ");
                        String bId = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        String memId = sc.nextLine();
                        library.issueBook(bId, memId);
                        System.out.println("Book issued.");
                        break;

                    case 4:
                        System.out.print("Enter Book ID: ");
                        String rbId = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        String rmId = sc.nextLine();
                        System.out.print("Days Late: ");
                        int late = sc.nextInt();
                        library.returnBook(rbId, rmId, late);
                        break;

                    case 5:
                        library.showInventory();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
