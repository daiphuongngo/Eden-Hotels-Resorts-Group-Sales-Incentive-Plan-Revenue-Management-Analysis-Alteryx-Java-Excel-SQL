
/*
 * Name: Phuong Dai Ngo (Liam Ngo)
 * Date: May 03, 2021
 * This program helps user input and check password, number of Salespersons, Sales Revenues by Categories, calculate Average Sales Revenue, print reports
 */
import java.util.Scanner;
public class JavaProjectEdenHotelsResorts {
    /* I: String
     * P: Invoking other specific methods, calculate Sales Revenue for each Salesperson and inserting each into matrix
     * O: void (not returning anything) so there is no output
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------Welcome in Eden Hotels & Resorts----------\n");
        System.out.print("\nEnter the Target Revenue of this month: ");
        int monthlyTargetRevenue = input.nextInt();

        int attempt = 0; // Checking password:
        while (attempt < 3) {
            System.out.print("\nEnter your password: ");
            String password = input.next();
            if (checkPassword(password) == true) {
                System.out.println("\nValid Password\n");
                break;
            } else {
                System.out.println("\nInvalid Password\n");
                attempt++;
            }
        }
        if (attempt == 3) {
            System.out.println("\nMaximum number of attempts exceeded\n");
            System.exit(0); // end the program if exceeding 3 attempts
        }
        // Create two 1D-array to store Salesperson name, number of Salesperson per Incentive Scheme level, Salespersons' total revenue and revenue ratio
        String[] listSalesPerson = new String [enterNumSalesPersons(input)]; // Name List should be in a separate List // check Number of Salesperson // set string length by numSalesperson --> this list contains String values
        double [][] matrixRevenue = new double[listSalesPerson.length][7]; // Enter Revenue and Calculate Total Revenue, Revenue Ratio // create matrix containing Salesperson 's revenues including 6 columns for each categorical revenue, 7th column for total sales revenue // not use enterNumSalesperson() to avoid invoke that method and enter multiple times
        int [] listIncentiveScheme = new int[4]; // Select School

        for (int i = 0; i < matrixRevenue.length; i++) {
            System.out.print("\nEnter Salesperson's name: ");
            listSalesPerson[i] = input.next();
            matrixRevenue = enterRevenue(i, matrixRevenue, "Banquet", 0, input); // added the 5th parameter (Scanner input) to this enterRevenue to generate inputting without having another line of Scanner
            matrixRevenue = enterRevenue(i, matrixRevenue, "Meeting", 1, input);
            matrixRevenue = enterRevenue(i, matrixRevenue, "MICE", 2, input);
            matrixRevenue = enterRevenue(i, matrixRevenue, "Room", 3, input);
            matrixRevenue = enterRevenue(i, matrixRevenue, "F&B", 4, input);
            matrixRevenue = enterRevenue(i, matrixRevenue, "Outside Catering", 5, input);
            matrixRevenue[i][6] = matrixRevenue[i][6] / monthlyTargetRevenue * 100; // calculate Monthly Revenue Ratio per Salesperson
        }

        // Print out maxtrix matrixRevenue:
        for (int i = 0; i < matrixRevenue.length; i++) {
            for (int j = 0; j < matrixRevenue[i].length; j++) {
                System.out.print(matrixRevenue[i][j] + " ");
            }
            System.out.println();
        }
        //Invoke salesReport method
        salesReport(listSalesPerson, matrixRevenue, listIncentiveScheme);
        input.close();
    }
    /*
     * I: String parameter (password)
     * P: Check password if meeting requirements
     * O: Return boolean
     */
    public static boolean checkPassword(String password) { /// specific method
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        if (password.length() < 12) {   // check password length
            return false;
        } else {
            char c;
            int numUpperCaseLetter = 0, numDigit = 0, numSpecialChar = 0;
            for (int i = 0; i < password.length(); i++) {
                c = password.charAt(i);
                if (Character.isUpperCase(c))  numUpperCaseLetter++; // check Uppercase
                else if (Character.isDigit(c)) numDigit++;  // check Digit
                else if (specialCharactersString.contains(Character.toString(c))) numSpecialChar++; // check special char
            }
            if (numUpperCaseLetter < 3) {
                System.out.println("\nPassword must contain at least three upper case letters.\n");
                return false;
            }
            if (numDigit != 4 && numDigit != 3)   {
                System.out.println("\nPassword must contain three or four numbers.\n");
                return false;
            }
            if (numSpecialChar != 2) {
                System.out.println("\nPassword must contain two special characters.\n");
                return false;
            }
        }
        return true; // *** must return true to get the true condition
    }

    /*
     * I: Scanner object
     * P: Check number of Salespersons if within range from 1-15
     * O: Integer parameter (numSalesPersons)
     */
    public static int enterNumSalesPersons(Scanner input) { // Check Number of Salespersons // added Scanner input as a parameter for this method (actually no need to close Scanner running within a specific method)
        int attemptNumSalesPersons = 0, numSalesPersons = 0;
        //Scanner input = new Scanner(System.in);
        while (numSalesPersons <1 || numSalesPersons > 15) {
            System.out.print("Enter the number of Salespersons: "); // must enter new number (first time or again)
            numSalesPersons = input.nextInt();
            if (numSalesPersons < 1 || numSalesPersons > 15) {
                System.out.println("\nNumber of Salespersons must be between 1-15.\n");
                attemptNumSalesPersons++;
            }
            if (numSalesPersons >= 1 && numSalesPersons <= 15) {
                System.out.println("\nNumber of Salespersons: " + numSalesPersons); // --> check length of list Salespersons
                //  input.close();
                return numSalesPersons; // stronger than break to exit // after return, the rest will not be proceeded
            }
            if (attemptNumSalesPersons == 3) {
                System.out.println("\nMaximum number of attempts exceeded.\n");
                System.exit(0);
            }
        }
        return numSalesPersons;
    }
    /*
     * Input: Integer, String, Matrix of Integers (parameter), Scanner object
     * Process: Enter each Sales category's revenue of each Salesperson into a matrix cell, calculate total revenue of each Salesperson by summing up
     * Output: Matrix of Integers (matrix)
     */
    public static double [][] enterRevenue(int salesPersonRowIndex, double [][] matrix, String categoryName, int categoryColumnIndex, Scanner sc) { // added the 5th parameter (Scanner input) to this enterRevenue to generate inputting without having another line of Scanner //public static int calculateRevenue(int revenue) ---> return total revenue/monthly target revenue in the main method;
        System.out.print("\nInput your revenue in " + categoryName + ": ");
        matrix[salesPersonRowIndex][categoryColumnIndex] = sc.nextDouble();
        matrix[salesPersonRowIndex][6] += matrix[salesPersonRowIndex][categoryColumnIndex]; // cumulative sum of Sales Revenue per Salesperson
        return matrix;
    }

    /*
     * I: Array of String (listSalesPerson), Matrix of Integers (matrixSalesRevenue), Array of Integers (Incentive Scheme Levels)
     * P: Print results and reports only
     * O: void
     */
    public static void salesReport(String [] salesPersonName, double [][] matrixRevenue, int [] incentiveSchemeLevel) { // school: number of students accepted in a school // markList: score matrix
        for (int i = 0; i < salesPersonName.length; i++) {
            System.out.print("Salesperson's Name: " + salesPersonName[i]);
            if (matrixRevenue[i][6] >= 125) {
                incentiveSchemeLevel[0]++; // Incentive Scheme Level III
                System.out.println(" is rewarded with Incentive Scheme Level III");
            }
            else if (matrixRevenue[i][6] >=115 && matrixRevenue[i][6] < 125) {
                incentiveSchemeLevel[1]++; // Incentive Scheme Level II
                System.out.println(" is rewarded with Incentive Scheme Level II");
            }
            else if (matrixRevenue[i][6] >= 100 && matrixRevenue[i][6] < 115) {
                incentiveSchemeLevel[2]++; //Incentive Scheme Level I
                System.out.println(" is rewarded with Incentive Scheme Level I");
            }
            else {
                incentiveSchemeLevel[3]++; // Non-rewarded
                System.out.println(" is not rewarded this month");
            }
        }
        System.out.println("Number of rewarded Salespersons with incentives: " + (incentiveSchemeLevel[0] + incentiveSchemeLevel[1] + incentiveSchemeLevel[2])); //
        System.out.println("Number of rewarded Salespersons with Incentive Scheme Level III: " + incentiveSchemeLevel[0]);
        System.out.println("Number of rewarded Salespersons with Incentive Scheme Level II: " + incentiveSchemeLevel[1]);
        System.out.println("Number of rewarded Salespersons with Incentive Scheme Level I: " + incentiveSchemeLevel[2]);
        System.out.println("Number of non-rewarded Salespersons this month: " + incentiveSchemeLevel[3]);
        System.out.println("Ratio of rewarded Salespersons in S&M department: " + ((double)(incentiveSchemeLevel[0] + incentiveSchemeLevel[1] + incentiveSchemeLevel[2]) / matrixRevenue.length)*100 + " %");
    }
}

