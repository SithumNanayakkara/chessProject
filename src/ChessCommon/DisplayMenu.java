package ChessCommon;

import ChessUser.ProcessUser;
import java.util.Scanner;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class DisplayMenu 
{
    Scanner scan;
    ProcessUser processUser;
    
    public DisplayMenu() 
    {
        scan = new Scanner(System.in);
        processUser = new ProcessUser();
    }
    /**
     * prints the initial menu leading to the game
     */
    public void printMenu()
    {
        
        String input ;
        
        System.out.println("Welcome to Chess!");
        System.out.println("================="); 
        System.out.print("Press 'N' if you are a new player\nPress 'R' if you are a returning player\nAnswer: ");
        
        do
        {
            input = scan.nextLine();
        }
        while(!this.isValidInput(input));
        
        if(input.equalsIgnoreCase("n"))
        {
             this.printSignUp();
        }
        else
        {
            this.printLogin();
        }
        
        System.out.println("\nHow to Play\n===========");
        System.out.println("- Please enter the initial coordinates and destination coordinates followed by a space in between");
        System.out.println("- Example: \"A2 A4\" to move black pawn from cell A2 to A4");
        System.out.println("\nLegend\n======");
        System.out.println("- White pieces: ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖ ♙");
        System.out.println("- Black pieces: ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜ ♟");
        System.out.println("- Disclaimer, colours are inverted on dark mode!");
    }
    /**
     * prints the sign up page
     */
    public void printSignUp()
    {
        System.out.println("\nLets sign up!");
        System.out.println("============");
        System.out.println("Please enter a new username: ");
        String newUsername;
        newUsername = scan.nextLine();

        System.out.println("Please enter a new password: ");
        String newPassword;
        newPassword = scan.nextLine();

        processUser.newUser(newUsername, newPassword);
    }
    /**
     * prints the login page
     */
    public void printLogin()
    {
        boolean valid = false;
        System.out.println("\nLets Login in!");
        System.out.println("============");
        String exUsername;
        String exPassword;
        do
        {
            System.out.println("Please enter your username:");
            exUsername = scan.nextLine();
            System.out.println("Please enter your password");
            exPassword = scan.nextLine();
            if(processUser.validateUser(exUsername, exPassword))
            {
                break;
            }
            
           
            System.out.println("\nPress \"N\" to sign up or \"R\" try again");
        
            String getInput;
            do
            {
                getInput = scan.nextLine();
            }while(!isValidInput(getInput));

            if(getInput.equalsIgnoreCase("n"))
            {
                printSignUp();
            }
            
        }
        while(!valid);
    }
    /**
     * checks if the input is valid and exits if X
     * @param input
     * @return 
     */
    public boolean isValidInput(String input)
    {
        if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("r"))
        {
            return true;
        }
        else if (input.equalsIgnoreCase("x"))
        {
            System.out.println("Thanks for playing!");
            System.out.println("Exiting...");
            System.exit(0);
        }
        System.out.println("Invalid input, please try again!");
        return false;
    }
    
}
