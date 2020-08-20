package ms.mains;

import java.util.ArrayList;
import ms.entities.ReportManagement;
import ms.entities.Student;
import ms.entities.StudentManagement;
import ms.utils.InputValidation;
import ms.utils.Menu;

/**
 *
 * @author lamhnt
 */
public class Main {

    public static void main(String[] args) {
        // declare
        ArrayList<Student> studentList = new ArrayList<>();
        Menu mn = new Menu();
        InputValidation iv = new InputValidation();
        StudentManagement sm = new StudentManagement();
        ReportManagement rm = new ReportManagement();
        int count = 0;

        // main menu
        while (true) {
            mn.mainMenu();
            int option = iv.validateMenuOption(1, 5);
            switch (option) {
                case 1:
                    sm.createStudent(count, studentList);
                    break;
                case 2:
                    sm.findAndSort(studentList);
                    break;
                case 3:
                    sm.updateOrDelete(studentList, count);
                    break;
                case 4:
                    rm.displayReport(studentList);
                    break;
                case 5:
                    return;
            }
        }
    }
}
