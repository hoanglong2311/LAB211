package mc.mains;

import java.util.ArrayList;
import mc.entities.Candidate;
import mc.entities.CandidateManagement;
import mc.utils.Menu;

/**
 *
 * @author lamhnt
 */
public class Main {

    public static void main(String[] args) {
        // declare
        Menu mn = new Menu();
        ArrayList<Candidate> candidateList = new ArrayList<>();
        CandidateManagement cm = new CandidateManagement();

        // main menu
        while (true) {
            int option = mn.mainMenu();
            switch (option) {
                case 1:
                    // create Experience
                    cm.createCandidate(candidateList, 0);
                    break;
                case 2:
                    // create Fresher
                    cm.createCandidate(candidateList, 1);
                    break;
                case 3:
                    // create Internship
                    cm.createCandidate(candidateList, 2);
                    break;
                case 4:
                    // search Candidate
                    cm.searchCandidate(candidateList);
                    break;
                case 5:
                    return;
            }
        }
    }
}
