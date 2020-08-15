package counter.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author lamhnt
 */
public class Counter {

    // declare
    public Map<Character, Integer> charCounter = new HashMap<>();
    public Map<String, Integer> wordCounter = new HashMap<>();

    // insert content
    public static String insertContent() {
        Scanner sc = new Scanner(System.in);
        String content = null;

        try {
            System.out.print("Your content: ");
            content = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Please enter again your content!");
            System.out.print("Your content: ");
        }

        return content;
    }

    // count word and character
    public void analyzeContent(String content) {
        // analyze char
        for (char c : content.toCharArray()) {
            // do nothing if there is a spacebar
            if (Character.isSpaceChar(c)) {
                continue;
            }

            // first time see that char
            if (!charCounter.containsKey(c)) {
                charCounter.put(c, 1);
            } else { // second time
                charCounter.put(c, (charCounter.get(c) + 1));
            }
        }
        System.out.println(charCounter);

        // analyze word
        StringTokenizer st = new StringTokenizer(content);
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            // first time see that word
            if (!wordCounter.containsKey(word)) {
                wordCounter.put(word, 1);
            } else { // second time
                wordCounter.put(word, (wordCounter.get(word) + 1));
            }
        }
        System.out.println(wordCounter);
    }
}
