package ms.utils;

import java.util.ArrayList;
import java.util.Scanner;
import ms.entities.Student;

/**
 *
 * @author lamhnt
 */
public class InputValidation {

    // declare
    Scanner sc = new Scanner(System.in);

    // check input option menu
    public int validateMenuOption(int firstOption, int lastOption) {
        // declare
        int option;

        while (true) {
            try {
                option = Integer.parseInt(sc.nextLine().trim());
                if (option < firstOption || option > lastOption) {
                    throw new NumberFormatException();
                }
                return option;
            } catch (NumberFormatException e) {
                System.out.println("Option must between " + firstOption + " and " + lastOption);
                System.out.print("Your choice: ");
            }
        }
    }

    // check user input string
    // not empty
    public String checkString() {
        // declare
        String content;

        while (true) {
            content = sc.nextLine().trim();
            if (content.isEmpty()) {
                System.err.println("Must not be empty !!!");
                System.out.print("Enter content again: ");
            } else {
                return content;
            }
        }
    }

    // check user continue option (Y/N)
    public boolean checkYesNo() {
        // declare
        String option;

        while (true) {
            option = checkString();
            // yes option
            if (option.equalsIgnoreCase("Y")) {
                return true;
            }
            // no option
            if (option.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.print("Do you want to continue (y/n)? ");
        }
    }

    // check student ID format
    public String checkStudentID() {
        // declare
        String studentID;

        while (true) {
            studentID = checkString();
            if (!studentID.matches("^[SE]{2}[0-9]{5,6}")) {
                System.err.println("Student ID Format: SE62917 or SE135678 !!!");
                System.out.print("Enter ID: ");
            } else {
                return studentID;
            }
        }
    }

    // check student Name
    public String checkStudentName() {
        // declare
        String studentName;

        while (true) {
            studentName = checkString();
            if (studentName.length() > 50) {
                System.err.println("Student name is too long!");
                System.out.print("Enter Name: ");
            } else if (!studentName.matches("[A-Za-z ]*")) {
                System.err.println("Student Name contains only alphabet and 1 white space after each word!");
                System.out.print("Enter Name: ");
            } else {
                return studentName;
            }
        }
    }

    // check student Existence
    public boolean checkStudentExistence(ArrayList<Student> list, String studentID, String studentName) {
        for (Student student : list) {
            if (studentID.equalsIgnoreCase(student.getId())
                    && !studentName.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    // check student Semester
    public String checkSemester() {
        // declare
        String semester;

        while (true) {
            semester = sc.nextLine().trim();
            if (!semester.matches("^[1-9]{1}")) {
                System.err.println("Semester must from 1 to 9");
                System.out.print("Enter Semester: ");
            } else {
                return semester;
            }
        }
    }

    // check Course Name
    public String checkCourseName() {
        while (true) {
            String courseName = checkString();
            if (courseName.equalsIgnoreCase("java")
                    || courseName.equalsIgnoreCase(".net")
                    || courseName.equalsIgnoreCase("c/c++")) {
                return courseName;
            } else {
                System.err.println("There are only three courses: Java, .Net, C/C++");
                System.out.print("Enter Course: ");
            }
        }
    }

    // check whether student registered or not
    public boolean checkRegistered(ArrayList<Student> list, String studentID, String studentName, String semester, String courseName) {
        for (Student student : list) {
            if (studentID.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }
}
