package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static search.SearchEngine.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        new SearchEngine();
        autoStartPoint(args[1]);
        while (true) {
            System.out.println("""
                    === Menu ===
                    1. Find a person
                    2. Print all people
                    0. Exit
                    """);
            int ope = scanner.nextInt();
            switch (ope) {
                case 1 -> findPerson();
                case 2 -> printList();
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Incorrect option! Try again.");
            }
        }
    }

    private static void findPerson() {
        scanner.nextLine();
        System.out.println("Enter a name or email to search all suitable people.");
        search(scanner.nextLine());
    }

    private static void startPoint(int noOfLines) {
        System.out.println("Enter all people:");
        for (int i = 0; i < noOfLines; i++) {
            setStringList(scanner.nextLine());
        }
    }

    private static void autoStartPoint(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner1 = new Scanner(file);
        while (scanner1.hasNextLine()) {
            setStringList(scanner1.nextLine());
        }
        scanner1.close();
        file.delete();
    }

    private static void doQuery(int query) {
        for (int i = 0; i < query; i++) {
            search(scanner.nextLine());
        }
    }
}
