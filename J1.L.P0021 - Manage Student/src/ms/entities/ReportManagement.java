package ms.entities;

import java.util.ArrayList;
import ms.utils.InputValidation;

/**
 *
 * @author lamhnt
 */
public class ReportManagement {

    // declare
    InputValidation iv = new InputValidation();

    public void displayReport(ArrayList<Student> studentList) {
        // check empty list
        if (studentList.isEmpty()) {
            System.err.println("There is no student !!!");
            return;
        }

        ArrayList<Report> reportList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            int totalLearnTime = 0;
            for (Student student : studentList) {
                String stu_ID = student.getId();
                String stu_Name = student.getStudentName();
                String stu_CourseName = student.getCourseName();
                for (Student student_learnAgain : studentList) {
                    if (stu_ID.equalsIgnoreCase(student_learnAgain.getId())
                            && stu_CourseName.equalsIgnoreCase(student_learnAgain.getCourseName())) {
                        totalLearnTime++;
                    }
                }
                if (iv.checkReportExistence(reportList, stu_Name, stu_CourseName, totalLearnTime)) {
                    reportList.add(new Report(stu_Name, stu_CourseName, totalLearnTime));
                }
            }
        }

        // display report
        System.out.println("--- Student Report List ---");
        System.out.printf("%-5s|%-20s|%-15s|%-17s", "No", "Student Name", "Course Name", "Total Learn Time");
        for (int i = 0; i < reportList.size(); i++) {
            System.out.printf("%-5s|%-20s|%-15s|%-17s", i,
                    reportList.get(i).getStudentName(),
                    reportList.get(i).getCourseName(),
                    reportList.get(i).getTotalCourse());
        }
    }
}
