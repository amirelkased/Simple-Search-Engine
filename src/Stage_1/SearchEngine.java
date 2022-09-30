package search;

public class SearchEngine {

     static int search(String line, String word) {
        String[] splitLine = line.split(" ");
        for (int i = 0; i < splitLine.length; i++) {
            if (word.equals(splitLine[i])) {
                return i + 1;
            }
        }
        return -1;
    }
}
