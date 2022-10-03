package search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private static Map<Integer, String> stringList;
    private static Map<String, ArrayList<Integer>> listMap;

    public SearchEngine() {
        stringList = new HashMap<>();
        listMap = new HashMap<>();
    }

    public static void setStringList(int id, String stringLine) {
        stringList.put(id, stringLine);
        freq(id, stringLine.toLowerCase());
    }

    public static void printList() {
        System.out.println("=== List of people ===");
        stringList.forEach((k, v) -> System.out.println(v));
    }

    public static void freq(int id, String line) {
        for (String it : Arrays.stream(line.split(" ")).collect(Collectors.toSet())) {
            listMap.putIfAbsent(it, new ArrayList<>());
            listMap.get(it).add(id);
        }
    }

    public static void searchListMap(String key) {
        if (listMap.containsKey(key)) {
            int noOfDist = listMap.get(key).size();
            System.out.printf("%d persons found:\n", noOfDist);
            for (Integer id : listMap.get(key)) {
                System.out.println(stringList.get(id));
            }
        } else {
            System.out.println("No matching people found.");
        }
    }
}
