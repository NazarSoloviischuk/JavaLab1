import java.util.HashSet;
import java.util.Set;

public class WordAnalyzer {

    // Повертає кількість різних символів у слові
    private static int countDistinct(String word) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            seen.add(word.charAt(i));
        }
        return seen.size();
    }
    // Шукає слово з мінімальною кількістю різних символів
    public static String[] findWord(String text) {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return new String[0];
        }

        String[] words = trimmed.split("\\s+");

        String best = words[0];
        int minCount = countDistinct(words[0]);

        for (int i = 1; i < words.length; i++) {
            int count = countDistinct(words[i]);
            if (count < minCount) {
                minCount = count;
                best = words[i];
            }
        }

        return new String[] { best };
    }
}