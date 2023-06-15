package menu;

import tools.MyUtil;
import java.util.Scanner;

public class Menu {

    String[] arr;
    int n;

    public Menu(int size) {
        if (size < 0) {
            size = 10;
        }
        arr = new String[size];
    }

    public void add(String ope) {
        if (n < arr.length) {
            arr[n++] = ope;
        }
    }

    public int getChoice() {
        int choice = 0;
        if (n > 0) {
            System.out.println("\t--- Menu Option ---");
            System.out.println("I. Publishers’ management");
            for (int i = 0; i < 4; i++) {
                System.out.println("    " + (i + 1) + " - " + arr[i]);
            }
            System.out.println("II. Books management");
            for (int i = 4; i < n; i++) {
                System.out.println("    " + (i + 1) + " - " + arr[i]);
            }
            Scanner sc = new Scanner(System.in);
            choice = MyUtil.getChoice();
        }
        return choice;
    }
}
