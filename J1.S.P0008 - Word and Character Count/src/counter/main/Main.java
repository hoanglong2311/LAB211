package counter.main;

import counter.utils.Counter;
import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class Main {

    public static void main(String[] args) {
        // declare
        Scanner sc = new Scanner(System.in);
        Counter counter = new Counter();
        String content = null;
        String cont;

        do {
            // insert content
            content = Counter.insertContent();

            // analyze content and display result
            counter.analyzeContent(content);

            // continue or not
            System.out.print("Do you want to continue (y/other)? ");
            cont = sc.nextLine();
        } while (cont.equalsIgnoreCase("y"));
    }
}
