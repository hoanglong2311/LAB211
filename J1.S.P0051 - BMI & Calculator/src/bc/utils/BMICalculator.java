package bc.utils;

import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class BMICalculator {

    // declare
    Scanner sc = new Scanner(System.in);
    InputValidation iv = new InputValidation();

    // return BMI status
    public String bmiStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat - should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    // calculate BMI
    public void calculateBMI() {
        // declare
        double weight;
        double height;
        double bmi;

        // input Weight & Height
        System.out.print("Enter Weight(kg): ");
        weight = iv.validatePositiveDouble();

        System.out.print("Enter Height(cm): ");
        height = iv.validatePositiveDouble();

        // BMI
        bmi = (weight * 10000) / (height * height);
        System.out.printf("BMI Number: %.2f\n", bmi);
        System.out.println("BMI Status: " + bmiStatus(bmi));
    }
}
