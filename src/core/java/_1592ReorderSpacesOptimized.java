package core.java;

import java.util.ArrayList;
import java.util.List;

public class _1592ReorderSpacesOptimized {

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces(" practice   makes   perfect"));
    }

    public static String reorderSpaces(String text) {
        if (text == null || text.trim().length() == 0) {
            return text;
        }
        char[] charArray = text.toCharArray();
        int lenSpace = 0;
        List<String> wordList = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch != ' ') {
                wordBuilder.append(ch);
            }
            if (ch == ' ' || i == charArray.length - 1) {
                if (wordBuilder.toString().length() > 0) {
                    wordList.add(wordBuilder.toString());
                    wordBuilder = new StringBuilder();
                }
                if (ch == ' ') {
                    lenSpace++;
                }
            }
        }

        int spaceBetweenWord = lenSpace / (wordList.size() - 1);
        int spaceEndWord = lenSpace % (wordList.size() - 1);
        StringBuilder bet = new StringBuilder();
        for (int k = 0; k < spaceBetweenWord; k++) {
            bet.append(" ");
        }
        StringBuilder end1 = new StringBuilder();
        if (spaceEndWord > 0) {
            for (int k = 0; k < spaceEndWord; k++) {
                end1.append(" ");
            }
        }
        wordBuilder = new StringBuilder();

        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            wordBuilder.append(word);
            if (i == wordList.size() - 1) {
                wordBuilder.append(end1);
            } else {
                wordBuilder.append(bet);
            }
        }
        return wordBuilder.toString();

    }

}