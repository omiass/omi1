package abhi1;
import java.util.*;

public class NQueen 
{
    static int N;
    
    static boolean isValid( int[][] board, int row, int col) 
    {
        //check for left side
        for (int i = 0; i < col; i++) 
        {
            if (board[row][i] == 1)
                return false;
        }

        //check for left upper diagonal
        for (int i=row, j=col; i>=0 && j>=0; i--, j--)
        {
            if (board[i][j] == 1)
                return false;
        }

        //check for left lower diagonal
        for (int i=row, j=col; j>=0 && i < N; i++, j--)
        {
            if (board[i][j] == 1)
                return false;
        }
        //otherwise placement is valid
        return true; 
    }

    static boolean solve(int[][] board, int col) 
    {
        if (col == N) 
        {
            System.out.println("\n-----Solution-----\n");
            for (int i = 0; i < board.length; i++) 
            {
                for (int j = 0; j < board.length; j++) 
                {
                    System.out.print(" " + board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }

        for (int row = 0; row < N; row++) 
        {
            if (isValid(board, row, col) == true) 
            {
               board[row][col] = 1;
               if (solve(board, col + 1) == true)
               {
                   return true;
               }
               board[row][col] = 0;
            }
         }
         return false;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter N (must other than 2 and 3) : ");
        N = sc.nextInt();
        if(N == 3 || N ==2)
        {
            System.out.println("No Solution");
        }
        int board[][] = new int[N][N];

        solve(board, 0);
        sc.close();
    }
}