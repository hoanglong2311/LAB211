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
    FresherManagement fm = new FresherManagement();
    InternshipManagement im = new InternshipManagement();

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
                    fm.createFresher(candidateList, newCandidate);
                    break;
                case 2:
                    im.createInternship(candidateList, newCandidate);
                    break;
            }
        } else {
            return;
        }
    }

    // Display All Candidate
    public void displayAll(ArrayList<Candidate> candidateList) {
        // Experience
        System.out.println("--- Experience Candidate ---");
        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateType() == 0) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        // Fresher
        System.out.println("--- Fresher Candidate ---");
        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateType() == 1) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        // Internship
        System.out.println("--- Internship Candidate ---");
        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateType() == 2) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

    // Search Candidate
    // By First Name/Last Name
    public void searchCandidate(ArrayList<Candidate> candidateList) {
        displayAll(candidateList);
        System.out.print("Enter Name to Search: ");
        String searchName = iv.checkName();
        System.out.print("Enter Candidate Type: ");
        int candidateType = iv.validateMenuOption(0, 2);
        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateType() == candidateType
                    && (candidate.getFirstName().contains(searchName)
                    || candidate.getLastName().contains(searchName))) {
                System.out.println(candidate.toString());
            }
        }
    }
}
