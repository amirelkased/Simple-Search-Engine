package search;

import java.util.Scanner;

import static search.SearchEngine.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int index = search(scanner.nextLine(), scanner.nextLine());
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println(index);
        }
    }
}