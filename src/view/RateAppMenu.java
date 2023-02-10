package view;

import java.util.Scanner;

/**
 * Menu for rating the MOBLIMA application before exiting the application
 */
public class RateAppMenu implements Menu{

    /**
     * execute() method to run the menu and get rating from user
     */
    public void execute(){
    System.out.println("Please rate our application:");
	System.out.println("----------------------------");
	System.out.println("1.Excellent");
    System.out.println("2.Good");
    System.out.println("3.Average");
    System.out.println("4.Bad");
    System.out.println("5.Unsatisfactory");
    System.out.print("Option: ");
    Scanner sc = new Scanner(System.in);
    int rate =sc.nextInt();
    
    //Exception handling
    while(rate<1 || rate>5){
        System.out.println("Please enter in a valid option!");
        System.out.print("Option: ");
        rate = sc.nextInt();
    }
    System.out.println("Ratings saved");
    System.out.println("Thanks for using the MOBLIMA app!");
    System.out.println("Have a nice day:)");
    }
}
