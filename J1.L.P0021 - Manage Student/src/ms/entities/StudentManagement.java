package ms.entities;

import java.util.ArrayList;
import java.util.Collections;
import ms.utils.InputValidation;

/**
 *
 * @author lamhnt
 */
public class StudentManagement {

    // declare
    InputValidation iv = new InputValidation();

    // create student
    public void createStudent(int count, ArrayList<Student> list) {
        if (count > 3) {
            System.out.print("Do you want to continue (y/n)? ");
            if (!iv.checkYesNo()) {
                return;
            }
        }

        while (true) {
            System.out.print("Enter ID: ");
            String studentID = iv.checkStudentID();
            System.out.print("Enter Name: ");
            String studentName = iv.checkStudentName();
            if (!iv.checkStudentExistence(list, studentID, studentName)) {
                System.err.println("Existed ID !!!");
                continue;
            }
            System.out.print("Enter Semester: ");
            String semester = iv.checkSemester();
            System.out.print("Enter Course: ");
            String courseName = iv.checkCourseName();

            // check whether student had registered or not
            if (iv.checkRegistered(list, studentID, studentName, semester, courseName)) {
                list.add(new Student(studentID, studentName, semester, courseName));
                count++;
                System.out.println("Registered !!!");
                return;
            } else {
                System.err.println("Student already registered !!!");
            }
        }
    }

    // Find By Name Student List
    public ArrayList<Student> findStudentByName(ArrayList<Student> list) {
        ArrayList<Student> studentFindByName_list = new ArrayList<>();
        System.out.print("Enter Student Name to search: ");
        String searchName = iv.checkStudentName();
        for (Student student : list) {
            if (student.getStudentName().contains(searchName)) {
                studentFindByName_list.add(student);
            }
        }
        return studentFindByName_list;
    }

    public void findAndSort(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("There is no student !!!");
            return;
        }

        ArrayList<Student> studentFindByName_list = findStudentByName(list);
        if (studentFindByName_list.isEmpty()) {
            System.err.println("Not found !!!");
        } else {
            Collections.sort(studentFindByName_list);
            System.out.printf("%-15s|%-15s|%-15s\n", "Student Name", "Semester", "Course Name");
            for (Student student : studentFindByName_list) {
                student.displayInfo();
            }
        }
    }
}
