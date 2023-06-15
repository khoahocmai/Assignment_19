package data;

import tools.MyUtil;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;

public class PubFunc extends Vector<Publisher> {

    public static String fName = "D:\\Chuyên ngành\\Chuyên ngành 3\\LAB211-LinhHX\\Project-LAB\\Assignment_P0019\\src\\texts\\Publishers.dat";
    Scanner sc = new Scanner(System.in);
    Book b;

    public PubFunc() {
        super();
    }

    public int find(String aID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getPubID().equals(aID)) {
                return i;
            }
        }
        return -1;
    }

    public void createPub() {
        Publisher Pub = new Publisher();
        String newPubID, newPubName, newPubPhone;
        int pos;
        boolean flag;
        System.out.println("Input Publisher information: ");
        do {
            newPubID = MyUtil.inputPattern("    Enter PubID", "^P\\d{5}$", "The ID is duplicated");
            pos = find(newPubID);
            if (pos >= 0) {
                System.out.println("ID duplicated!");
            }
            Pub.setPubID(newPubID);
        } while (pos >= 0);
        newPubName = MyUtil.inputPattern("    Enter PName", "\\D*", "Publisher's Name from 5 to 30 characters");
        Pub.setPubName(newPubName);
        newPubPhone = MyUtil.inputPattern("    Enter Phone number", "\\d*", "Publisher's Phone number length from 10 to 12");
        Pub.setPubPhone(newPubPhone);

        this.add(Pub);
        System.out.println("The Publisher is created");
    }

    public void deletePub() {
        String ID, tmp;
        System.out.print("Enter the Publisher’s ID: ");
        ID = sc.nextLine().toUpperCase();
        int pos = find(ID);
        if (pos < 0) {
            System.out.println("Publisher’s ID does not exist");
        } else {
            tmp = this.get(pos).getPubName();
            this.remove(pos);
            System.out.println("This Publisher - " + ID + ": " + tmp + " has been removed");
        }
    }

    public void addFromFile() {
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String name = stk.nextToken().toUpperCase();
                String ID = stk.nextToken().toUpperCase();
                String phone = stk.nextToken().toUpperCase();

                Publisher pub = new Publisher(name, ID, phone);
                this.add(pub);
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
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Publisher x : this) {
                pw.println(x.getPubName() + "," + x.getPubID() + "," + x.getPubPhone());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        Collections.sort(this);
        System.out.println("\t--- PUBLISHER'S LIST ---");
        for (Publisher x : this) {
            x.output();
        }
    }

}
