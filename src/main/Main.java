package main;

import menu.Menu;
import data.PubFunc;
import data.BookFunc;
import tools.MyUtil;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu(11);
        menu.add("Create a Publisher");
        menu.add("Delete the Publisher");
        menu.add("Save the Publishers list to file");
        menu.add("Print the Publisher list from the file");
        menu.add("Create a Book");
        menu.add("Search the Book");
        menu.add("Update a Book");
        menu.add("Delete the Book");
        menu.add("Save the Books list to file");
        menu.add("Print the Books list from the file");
        menu.add("Quit");

        PubFunc list = new PubFunc();
        BookFunc list2 = new BookFunc(list);
        list.addFromFile();
        list2.addFromFile();
        boolean changed = false, kt;
        int choice;
        do {
            System.out.println("\n\tBOOK STORE MANAGEMENT");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.createPub();
                    changed = true;
                    break;
                case 2:
                    list.deletePub();
                    changed = true;
                    break;
                case 3:
                    list.saveToFile();
                    changed = true;
                    System.out.println("\nThe Publisher's infor has been saved");
                    break;
                case 4:
                    list.printList();
                    break;
                case 5:
                    list2.createBook();
                    changed = true;
                    break;
                case 6:
                    list2.searchBook();
                    break;
                case 7:
                    list2.updateBook();
                    changed = true;
                    break;
                case 8:
                    list2.deleteBook();
                    changed = true;
                    break;
                case 9:
                    list2.saveToFile();
                    changed = true;
                    System.out.println("\nThe Book's infor has been saved");                    
                    break;
                case 10:
                    list2.printAll();
                    break;
                default:
            }
            System.out.println("\nDo you want to go back menu?");
            kt = MyUtil.checkBool("User choose");           
        } while (kt);
        if (changed) {
            System.out.println("Save all changed Y/N?: ");
            System.out.print("User choose: ");
            String response = sc.nextLine().toUpperCase();
            if (response.startsWith("Y")) {
                list.saveToFile();
                list2.saveToFile();
            }
        }
        System.out.println("\n\tThe program is finished !!");
    }
}
