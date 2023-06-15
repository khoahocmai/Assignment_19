package data;

import tools.MyUtil;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class BookFunc extends Vector<Book> {

    public static String bName = "D:\\Chuyên ngành\\Chuyên ngành 3\\LAB211-LinhHX\\Project-LAB\\Assignment_P0019\\src\\texts\\Book.dat";
    Scanner sc = new Scanner(System.in);
    PubFunc pf;

    public BookFunc(PubFunc pf) {
        super();
        this.pf = pf;
    }

    public int find(String aID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBookID().equals(aID)) {
                return i;
            }
        }
        return -1;
    }

    public int findN(String Name) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBookName().contains(Name)) {
                return i;
            }
        }
        return -1;
    }

    public void addFromFile() {
        try {
            File f = new File(bName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String BID = stk.nextToken().toUpperCase();
                String Bname = stk.nextToken().toUpperCase();
                float price = Float.parseFloat(stk.nextToken());
                int quantity = Integer.parseInt(stk.nextToken());
                float SubTotal = Float.parseFloat(stk.nextToken());
                String pubName = stk.nextToken().toUpperCase();
                String status = stk.nextToken().toUpperCase();

                Book b = new Book(BID, Bname, price, quantity, SubTotal, status, pubName);
                this.add(b);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveToFile() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(bName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Book x : this) {
                pw.println(x.getBookID() + "," + x.getBookName() + "," + x.getBookPrice() + ","
                        + x.getQuantity() + "," + x.getSubTotal() + "," + x.getPubName() + "," + x.getStatus());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createBook() {

        String bkID, bookName, status, pubID;
        float bookPrice;
        int quantity, pos;
        boolean flag;
        Book b = new Book();

        System.out.println("Input Book information: ");
        do {
            bkID = MyUtil.inputPattern("    Enter BookID", "^B\\d{5}$", "Book’s Id: “Bxxxxx”, with x is digits");
            pos = find(bkID);
            if (pos >= 0) {
                System.out.println("ID duplicated!");
            }
            b.setBookID(bkID);
        } while (pos >= 0);

        bookName = MyUtil.inputPattern("    Enter BName", "\\D*", "Book's Name from 5 to 30 characters");
        b.setBookName(bookName);
        bookPrice = MyUtil.inputFloat("    Enter Book's price", (float) 0.0);
        b.setBookPrice(bookPrice);
        quantity = MyUtil.inputInt("    Enter Book's quantity", 0);
        b.setQuantity(quantity);
        status = MyUtil.inputToForm("    Enter Book status", "AVAILABLE", "NOT AVAILABLE");
        b.setStatus(status);
        do {
            pubID = MyUtil.inputPattern("    Enter PubID", "^P\\d{5}$", "Publisher’s Id: “Pxxxxx”, with x is digits");
            pos = pf.find(pubID);
            if (pos >= 0) {
                b.setPubName(pf.get(pos).getPubName());
            }
        } while (pos >= 0);
        this.add(b);
        System.out.println("The Book is created");
    }

    public void searchBook() {
        String nameB, IDP;
        int pos, pos2;
        if (this.isEmpty()) {
            System.out.println("The Book's List is empty!");
        }

        System.out.println("Enter name of Book and ID of Publisher");
        System.out.print("ID Pub: ");
        IDP = sc.nextLine().toUpperCase();
        System.out.print("Name book: ");
        nameB = sc.nextLine().toUpperCase();
        pos2 = pf.find(IDP);
        pos = findN(nameB);

        if (pos2 < 0) {
            System.out.println("Have no any Book of that Publisher");
        } else if (pos2 > 0 && pos < 0) {
            System.out.println("Have no any Book of that Publisher");
        } else {
            for (Book x : this) {
                if(x.getBookName().contains(nameB)){
                    x.outputBk();
                }
            }           
        }

//        if (pos < 0 && pos2 < 0) {
//            System.out.println("Have no any Book");
//        } else if (pos > 0 && pos2 < 0) {
//            System.out.println("Wrong ID of Publisher");
//            System.out.println("Information book: ");
//            for (Book x : this) {
//                if (x.getBookName().contains(nameB)) {
//                    x.outputBk();
//                }
//            }
//        } else if (pos < 0 && pos2 > 0) {
//            System.out.println("Wrong name of Book");
//            System.out.println("\nPub ID: " + IDP + " - " + pf.get(pos2).getPubName());
//            System.out.println("Information book: ");
//            for (Book x : this) {
//                if (pf.get(pos2).getPubName().equals(x.getPubName())) {
//                    x.outputBk();
//                }
//            }
//        } else {
//            System.out.println("\nPub ID: " + IDP + " - " + pf.get(pos2).getPubName());
//            System.out.println("Information book: ");
//            if (this.get(pos).getPubName().equals(pf.get(pos2).getPubName())) {                
//                for (Book x : this) {
//                    if (pf.get(pos2).getPubName().equals(x.getPubName())) {
//                        x.outputBk();
//                    }
//                }
//                for (Book x : this) {
//                    if (x.getBookName().contains(nameB)) {
//                        x.outputBk();
//                    }
//                }
//            } else {
//                for (Book x : this) {
//                    if (pf.get(pos2).getPubName().equals(x.getPubName())) {
//                        x.outputBk();
//                    }
//                }
//                for (Book x : this) {
//                    if (x.getBookName().contains(nameB)) {
//                        x.outputBk();
//                    }
//                }
//            }
//
//        }
    }

    public void updateBook() {
        boolean flag = false;
        int L;
        String BookID, bookName, status, pubID, pubName, tmp;
        float bookPrice;
        int quantity;
        System.out.print("Enter Book ID: ");
        BookID = sc.nextLine().toUpperCase();
        int pos = find(BookID);
        if (pos < 0) {
            System.out.println("Book ID not found !!");
        } else {
            Book b = this.get(pos);
            System.out.println("New book information - Enter for skipping");

            do {
                System.out.print("    Enter Bname: ");
                bookName = MyUtil.sc.nextLine().trim();
                if (!bookName.isEmpty()) {
                    flag = false;
                    b.setBookName(bookName);
                }
            } while (flag);

            do {
                System.out.print("    Enter Book's price: ");
                tmp = MyUtil.sc.nextLine().trim();
                if (!tmp.isEmpty()) {
                    flag = false;
                    bookPrice = Float.parseFloat(tmp);
                    b.setBookPrice(bookPrice);
                }
            } while (flag);

            do {
                System.out.print("    Enter Book's quantity: ");
                tmp = MyUtil.sc.nextLine().trim();
                if (!tmp.isEmpty()) {
                    flag = false;
                    quantity = Integer.parseInt(tmp);
                    b.setQuantity(quantity);
                }
            } while (flag);

            do {
                System.out.print("    Enter status: ");
                status = MyUtil.sc.nextLine().trim();
                if (!status.isEmpty()) {
                    flag = false;
                    b.setStatus(status);
                }
            } while (flag);

            do {
                System.out.print("    Enter Publisher's ID: ");
                pubID = MyUtil.sc.nextLine().trim();
                flag = MyUtil.checkBlankStr(pubID);
                if (!flag) {
                    pos = pf.find(pubID);
                    if (pos >= 0) {
                        pubName = pf.get(pos).getPubName();
                        b.setPubName(pubName);
                    }
                }
            } while (!flag);
        }
    }

    public void deleteBook() {
        String input;
        int pos;
        System.out.print("Enter Book's ID: ");
        input = sc.nextLine().toUpperCase();
        pos = find(input);
        if (pos < 0) {
            System.out.println("Have no any Book");
        } else {
            this.remove(pos);
            System.out.println("The Book was removed");
        }
    }

    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        Collections.sort(this);
        System.out.println("\t\t\t\t--- BOOK'S LIST ---");
        for (Book x : this) {
            x.outputBk();
        }
    }

}
