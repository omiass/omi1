package abhi1;
import java.util.*;

class State 
{
    int hr;
    char[][] puzzle = new char[3][3];
    
    State(char[][] puzzle)
    {
        this.puzzle = puzzle;
    }
}
public class astar
{
    static List<State> openList = new ArrayList<>();
    static List<State> closeList = new ArrayList<>();

    //returns heuristic value i.e. number of missplaced tiles
    static int getHeuristic(State currState, State goalState)
    {
        int hr = 0;

        char[][] currPuzzle = currState.puzzle;
        char[][] goalPuzzle = goalState.puzzle;

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(currPuzzle[i][j] != goalPuzzle[i][j])
                    hr++;
            }
        }
        return hr;
    }

    //get position of blank tile
    static int[] getPosition(State state)
    {
        int[] pos = new int[2];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(state.puzzle[i][j] == '-')
                {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }

    static char[][] copyPuzzle(State st)
    {
        char[][] temp = new char[3][3];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                temp[i][j] = st.puzzle[i][j];
            }
        }
        return temp;
    }

    //display closed list
    static void displayPath()
    {
        System.out.println("\nPath to Goal State\n");
        for(State st : closeList)
        {
            System.out.println("\nHueristic value : " + st.hr);
            for(char[] c : st.puzzle)
            {
                System.out.println("      " + c[0] + "  " + c[1] + "  " + c[2]);
            }
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t\\/");
        }
    }

    static void aStar(State starState, State goalState)
    {
        int level = -1;
        openList.add(starState);

        while(!openList.isEmpty() && level < 100)
        {
            level++;

            //Sorting open list based on heuristic function
            Collections.sort(openList, (a , b) ->(a.hr - b.hr));

            System.out.println("\n\n------Level " + level + "------");
            for(State st : openList)
            {
                System.out.println("\nHueristic value : " + st.hr);
                for(char[] c : st.puzzle)
                {
                    System.out.println(c[0] + "  " + c[1] + "  " + c[2]);
                }
            }

            State n = openList.get(0);

            if(n.hr == 0)
            {
                System.out.println("\n!--- Goal State ---!");
                for(char[] c : n.puzzle)
                {
                    System.out.println(c[0] + "  " + c[1] + "  " + c[2]);
                }
                closeList.add(n);
                return;
            }

            int[] pos = new int[2];
            pos = getPosition(n);
            int row = pos[0];
            int col = pos[1];

            if (col + 1 < 3)
            {
                char[][] temp = copyPuzzle(n);
                
                //swapping
                char c = temp[row][col];
                temp[row][col] = temp[row][col + 1];
                temp[row][col+1] = c;

                

                State newState = new State(temp);
                newState.hr = getHeuristic(newState, goalState);
                openList.add(newState);
            }

            if (col - 1 > -1)
            {
                char[][] temp = copyPuzzle(n);

                //swapping
                char c = temp[row][col];
                temp[row][col] = temp[row][col-1];
                temp[row][col-1] = c;
                
                State newState = new State(temp);
                newState.hr = getHeuristic(newState, goalState);
                openList.add(newState);
            }

            if (row + 1 < 3)
            {
                char[][] temp = copyPuzzle(n);

                //swapping
                char c = temp[row][col];
                temp[row][col] = temp[row+1][col];
                temp[row+1][col] = c;

                State newState = new State(temp);
                newState.hr = getHeuristic(newState, goalState);
                openList.add(newState);
            }

            if (row - 1 > -1)
            {
                char[][] temp = copyPuzzle(n);
                //swaping
                char c = temp[row][col];
                temp[row][col] = temp[row-1][col];
                temp[row-1][col] = c;

                State newState = new State(temp);
                newState.hr = getHeuristic(newState, goalState);
                openList.add(newState);
            }

            closeList.add(n);
            openList.remove(0);
        }
    }


    public static void main(String[] args) 
    {    
        char[][] start = {{'1', '2', '3'},
                          {'4', '-', '6'},
                          {'7', '8', '5'}};

        char[][] goal = {{'1', '2', '3'},
                         {'6', '-', '5'},
                         {'4', '7', '8'}};

        

        State startState = new State(start); 
        State goalState = new State(goal); 
        startState.hr = getHeuristic(startState, goalState);

        aStar(startState, goalState);
        // displayPath();
    }
}