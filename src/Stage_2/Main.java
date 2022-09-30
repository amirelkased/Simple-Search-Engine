package search;

import java.util.Scanner;

import static search.SearchEngine.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new SearchEngine();
        int noOfLines = Integer.parseInt(scanner.next());
        scanner.nextLine();
        for (int i = 0; i < noOfLines; i++) {
            setStringList(scanner.nextLine());
        }
        int query = Integer.parseInt(scanner.next());
        scanner.nextLine();
        for (int i = 0; i < query; i++) {
            search(scanner.nextLine());
        }
    }
}