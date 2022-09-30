package search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private static List<String> stringList;

    public SearchEngine() {
        stringList = new ArrayList<>();
    }

    public static void setStringList(String stringLine) {
        stringList.add(stringLine);
    }

    public static void search(String word) {
        boolean flag = false;
        for (String s : stringList) {
            if (s.toLowerCase().contains(word.toLowerCase())) {
                if (!flag) {
                    System.out.println("Found people:");
                    flag = true;
                }
                System.out.println(s);
            }
        }
        if (!flag) {
            System.out.println("No matching people found.");
        }
    }

    public static void printList() {
        System.out.println("=== List of people ===");
        stringList.forEach(System.out::println);
    }
}
