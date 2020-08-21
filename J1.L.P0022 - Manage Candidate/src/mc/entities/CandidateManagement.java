package mc.entities;

import java.util.ArrayList;
import java.util.Scanner;
import mc.utils.InputValidation;

/**
 *
 * @author lamhnt
 */
public class CandidateManagement {

    // declare
    Scanner sc = new Scanner(System.in);
    InputValidation iv = new InputValidation();
    ExperienceManagement em = new ExperienceManagement();

    // Create Candidate
    public void createCandidate(ArrayList<Candidate> candidateList, int candidateType) {
        // general candidate
        System.out.print("Enter ID: ");
        String candidateID = iv.checkCandidateID();
        System.out.print("Enter First Name: ");
        String firstName = iv.checkName();
        System.out.print("Enter Last Name: ");
        String lastName = iv.checkName();
        System.out.print("Enter Birth Year: ");
        int birthYear = iv.checkBirthYear();
        System.out.print("Enter Address: ");
        String address = iv.checkAddress();
        System.out.print("Enter Phone: ");
        String phone = iv.checkPhone();
        System.out.print("Enter Email: ");
        String email = iv.checkEmail();

        Candidate newCandidate = new Candidate(candidateID, firstName, lastName, birthYear, address, phone, email, candidateType);
        if (iv.checkIDExistence(candidateList, candidateID)) {
            switch (candidateType) {
                case 0:
                    em.createExperience(candidateList, newCandidate);
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        } else {
            return;
        }
    }
}
