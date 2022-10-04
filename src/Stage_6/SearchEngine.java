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

    public static void searchStrategy(String key, String strategy) {
        List<Integer> printLines = new ArrayList<>();
        Strategy strategy1;
        switch (strategy) {
            case "ALL" -> {
                strategy1 = new All();
                printLines = strategy1.printResult(key, listMap);
            }
            case "ANY" -> {
                strategy1 = new Any();
                printLines = strategy1.printResult(key, listMap);
            }
            case "NONE" -> {
                strategy1 = new Any();
                printLines = invertedList(strategy1.printResult(key, listMap));
            }
        }
        assert printLines != null;
        if (printLines.size() > 0) {
            System.out.printf("%d persons found:\n", printLines.size());
            for (Integer id : printLines) {
                System.out.println(stringList.get(id));
            }
        } else {
            System.out.println("No matching people found.");
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

    public static List<Integer> invertedList(List<Integer> list) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= stringList.size(); i++) {
            if (!list.contains(i)) {
                temp.add(i);
            }
        }
        return temp;
    }
}
