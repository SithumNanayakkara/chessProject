package ChessBoard;

import ChessCommon.Colour;
import ChessPiece.Pawn;
import ChessPiece.Queen;
import ChessPiece.King;
import ChessPiece.Bishop;
import ChessPiece.Knight;
import ChessPiece.Rook;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class Board 
{
    static BoardCell [] [] cells ;
    /**
     * initializes an empty 8x8 Array
     */
    public Board()
    {
       cells = new BoardCell [8] [8];
    }
    /**
     * adds pices to the array
     */
    public static void setup()
    {
        
        cells [0][0] = new BoardCell(0,0, new Rook(Colour.Black));
        cells [0][1] = new BoardCell(0,1, new Knight(Colour.Black));
        cells [0][2] = new BoardCell(0,2, new Bishop(Colour.Black));
        cells [0][3] = new BoardCell(0,3, new Queen(Colour.Black));
        cells [0][4] = new BoardCell(0,4, new King(Colour.Black));
        cells [0][5] = new BoardCell(0,5, new Bishop(Colour.Black));
        cells [0][6] = new BoardCell(0,6, new Knight(Colour.Black));
        cells [0][7] = new BoardCell(0,7, new Rook(Colour.Black));
        
        for(int i=0;i<8;i++)
        {
            cells[1][i] = new BoardCell(1,i,new Pawn(Colour.Black));
        }
            
        
        cells [7][0] = new BoardCell(7,0, new Rook(Colour.White));
        cells [7][1] = new BoardCell(7,1, new Knight(Colour.White));
        cells [7][2] = new BoardCell(7,2, new Bishop(Colour.White));
        cells [7][3] = new BoardCell(7,3, new Queen(Colour.White));
        cells [7][4] = new BoardCell(7,4, new King(Colour.White));
        cells [7][5] = new BoardCell(7,5, new Bishop(Colour.White));
        cells [7][6] = new BoardCell(7,6, new Knight(Colour.White));
        cells [7][7] = new BoardCell(7,7, new Rook(Colour.White));
        
        for(int i=0;i<8;i++)
        {
            cells[6][i] = new BoardCell(6,i,new Pawn(Colour.White));
        }
        
        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 8; j++) 
            {
                if(cells [i][j] == null)
                {
                    cells[i][j] = new BoardCell(i, j, null );
                }
            }
        }
    }
    /**
     * gets the cell coordinates
     * @param x
     * @param y
     * @return 
     */
    public BoardCell getCell(int x, int y)
    {
        return cells[x][y];
    }

    
    public BoardCell[][] getCells()
    {
        return cells;
    }

    public static void setCells(BoardCell[][] cells)
    {
        Board.cells = cells;
    }
   
    /**
     * prints the board
     */
    public void printBoard()
    {
        int count =1;
        System.out.println("\n           Chess Board");
        System.out.println("           ===========");
        System.out.println("    A    B   C    D    E   F    G    H");
        System.out.println(" + — — — — — — — — — — — +");
        for(int i = 7; i>=0; i--)
        {
            System.out.print(count + "｜");
            
            for(int j = 0; j<8; j++)
            {
                BoardCell emptyCells = cells[i][j];
                
                
                if(emptyCells.getPiece() == null)
                {
                    System.out.printf(" %s ",emptyCells);
                }
                else
                {
                    System.out.printf(" %s ",emptyCells.getPiece().toString());
                }    
            }
            System.out.print("｜" + count);
            System.out.println();
            count++;
        }
        System.out.println(" + — — — — — — — — — — — +");
        System.out.println("    A    B   C    D    E   F    G    H");
    }
    

    
}