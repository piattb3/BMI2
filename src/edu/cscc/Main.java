package edu.cscc;

import java.util.Scanner;

/**
 * Benjamin Piatt
 * 03/30/2021
 * Lab 8 - BMI
 */
public class Main {

    private static Scanner in = new Scanner(System.in);
    private static final String INPUT_ERROR = "Input is not valid, try again";


    public static void main(String[] args) {
        double lbs, inches, meters, kgs, bmi;
        String classification;

        System.out.println("Calculate BMI");
        lbs = inptWeight();
        inches = inputHeight();
        kgs = convertToKilograms(lbs);
        meters = convertToMeters(inches);
        bmi = calcBMI(kgs, meters);
        bmiClassification(bmi);
    }

    /**
     * Convert pounds to kilograms
      * @param lbs
     * @return = pounds/2.2046
     */
    public static double convertToKilograms(double lbs){
        return lbs/2.2046;
    }

    /**
     * Convert inches to meters
     * @param inches
     * @return = inches/39.37
     */
    public static double convertToMeters(double inches){
        return inches/39.37;
    }

    /**
     * Calculate the BMI
     * @param weight
     * @param height
     * @return = kilograms/((meters)(meters))
     */
    public static double calcBMI(double weight, double height){
        double bmi = Math.pow(height, 2);
        bmi = weight/bmi;
        return bmi;
    }

    /**
     * Print out the BMI classification and value
     * @param bmi
     * @return = classification of bmi
     */
    public static String bmiClassification(double bmi){
        System.out.println("Your BMI is " + bmi);
        String classification = "";
        if(bmi<18.5){
            classification=("Underweight");
            System.out.println("Your BMI classification is "+classification);
        }
        if(bmi<25&bmi>18.4){
            classification=("Normal");
            System.out.println("Your BMI classification is "+classification);
        }
        if(bmi<30&bmi>24.9){
            classification=("Overweight");
            System.out.println("Your BMI classification is "+classification);
        }
        if(bmi>29.99) {
            classification = ("Obese");
            System.out.println("Your BMI classification is " + classification);
        }
        return classification;
    }

    /**
     * Parse and validate the input
     * @return = parsed and validated input
     */
    private static double inptWeight() {
        boolean isValid = false;
        double dubWeight = 0.0;
        while(!isValid) {
            try {
                System.out.println("Enter weight (lbs): ");
                String weight = in.next();
                dubWeight = Double.parseDouble(weight);
                if(dubWeight > 0){
                    isValid = true;
                }else{
                    System.out.println(INPUT_ERROR);
                }

            }
            catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR);
            }
        }
        return dubWeight;
    }

    /**
     * Parse and validate height
     * @return = validated height
     */
    private static double inputHeight() {

        boolean isValid = false;
        double dubHeight = 0.0;
        while(!isValid) {
            try {
                System.out.println("Enter height (ins): ");
                String height = in.next();
                dubHeight = Double.parseDouble(height);
                if(dubHeight != 0){
                    isValid = true;
                }else{
                    System.out.println(INPUT_ERROR);
                }

            }
            catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR);
            }
        }
        return dubHeight;

    }


}
