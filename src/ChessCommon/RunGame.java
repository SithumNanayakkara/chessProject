package ChessCommon;

import ChessBoard.Board;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */

public class RunGame 
{
    public static void main(String[] args) 
    {   
        DisplayMenu dMenu = new DisplayMenu();
        Board board = new Board();
        ProcessMove pMove = new ProcessMove();
        dMenu.printMenu();
        Board.setup();
        boolean gameOver = false;
        boolean valid = false;
        boolean playAgain = true;
        
        while(playAgain)
        {
            while(!gameOver)
            {
                valid = false;
                board.printBoard();
                while(!valid)
                {
                   if(pMove.getUserMove())
                   {
                       gameOver=true;
                       break;
                   }

                   if(pMove.convertToCoordinates() != -1)
                   {
                       valid = true;
                   }
                }
            }
            
            System.out.println("\nPress \"L\" to see game log, \"Y\" to play again, \"X\" to exit");
            Scanner scan = new Scanner(System.in);
            valid = false;
            while(!valid)
            {
                System.out.print("Your input: ");
                String input = scan.next();
                
                if(input.equalsIgnoreCase("x"))
                {
                    System.out.println("Thanks for playing!");
                    System.out.println("Exiting....");
                    System.exit(0);
                }
                else if(input.equalsIgnoreCase("l"))
                {
                    System.out.println("\nGame Log");
                    System.out.println("========");
                    pMove.displayMoves();
                    System.out.println("");
                }
                else if(input.equalsIgnoreCase("y"))
                {
                    valid = true;
                }
                System.out.println("\nPress \"Y\" to play again, \"X\" to exit");
            }
        }
    }   
        
}
