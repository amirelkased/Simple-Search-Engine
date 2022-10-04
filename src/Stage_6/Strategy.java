package search;

import java.util.*;

interface Strategy {
    List<Integer> printResult(String line, Map<String, ArrayList<Integer>> listMap);
}

class All implements Strategy {

    @Override
    public List<Integer> printResult(String line, Map<String, ArrayList<Integer>> listMap) {
        String[] strings = line.split(" ");
        List<Integer> list = Collections.emptyList();
        for (String it : strings) {
            if (listMap.containsKey(it)) {
                if (list.isEmpty()) {
                    list = new ArrayList<>(listMap.get(it));
                } else {
                    list.retainAll(listMap.get(it));
                }
            }
        }
        return list;
    }
}

class Any implements Strategy {

    @Override
    public List<Integer> printResult(String line, Map<String, ArrayList<Integer>> listMap) {
        String[] strings = line.split(" ");
        Set<Integer> list = null;
        for (String it : strings) {
            if (listMap.containsKey(it)) {
                if (list == null) {
                    list = new HashSet<>(listMap.get(it));
                } else {
                    list.addAll(listMap.get(it));
                }
            }
        }
        assert list != null;
        return list.stream().toList();
    }
}