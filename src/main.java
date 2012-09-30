import java.io.IOException;
import java.util.Random;

class PositionState
{
    private int x_coord, y_coord, z_coord;
    
    public void allotPosition(int x, int y, int z)
    {
        x_coord = x;
        y_coord = y;
        z_coord = z;
    }
    
    public int getPosition (String pos)
    {
        if (pos == "x")
        {
            return x_coord;
        }
        else if (pos == "y")
        {
            return y_coord;
        }
        else
        {
            return z_coord;
        }
    }
}

class TicTacToeAI
{
    private static PositionState[] Cross = new PositionState[14];
    private static PositionState[] Zero = new PositionState[14];
    private static int gamesCross, gamesZero;
    
    public static void main (String argc[]) throws IOException
    {
        char player;
        boolean win = false;
        int prev = 0;
        
        for (int i =0; i<14; i++)
        {
            Cross[i] = new PositionState();
            Zero[i] = new PositionState();
        }
        
        gamesCross = 0;
        gamesZero = 0;
        
        System.out.println("Enter who plays first(Cross'X' or Zero'O')");
        player = (char)System.in.read();
        
        while (win == false)
        {
            
            if (player == 'X' || player == 'x')
            {
                System.out.println("Next player is Cross");
                if (gamesCross == 0)
                {
                    if (gamesZero == 0)
                    {
                        Random rnd = new Random();
                        
Cross[gamesCross].allotPosition(rnd.nextInt(3),rnd.nextInt(3),rnd.nextInt(3));
                    
                        int x = Cross[gamesCross].getPosition("x");
                        int y = Cross[gamesCross].getPosition("y");
                        int z = Cross[gamesCross].getPosition("z");
                    
                        System.out.println(x + "," + y + "," + z);
                        player = 'o';
                        prev = gamesCross;
                        gamesCross++;
                     }
                     
                     else if (gamesZero == 1)
                     {
                        Random rnd = new Random();
                        
                        int prev_x = Zero[prev].getPosition("x");
                        int prev_y = Zero[prev].getPosition("y");
                        int prev_z = Zero[prev].getPosition("z");
                        int x = 0, y = 0, z = 0;
                        boolean same = true;
                        //System.out.println(prev_x);
                        while (same == true)
                        {
                            x = rnd.nextInt(3);
                            y = rnd.nextInt(3);
                            z = rnd.nextInt(3);
                            //System.out.println(x);
                            if (x != prev_x)
                            {
                                if (y != prev_y)
                                {
                                    if (z != prev_z)
                                    {
                                        same = false;
                                    }
                                }
                            }
                        }
                        Cross[gamesCross].allotPosition(x, y, z);
                        prev = gamesCross;
                        gamesCross++;
                        player = 'o';
                        System.out.println(x + "," + y + "," + z);
                        
                     }
                }
                else if (gamesCross == 1)
                {
                    if (gamesZero == 1)
                    {
                        secondAllot('x', prev);
                        prev = gamesCross;
                        System.out.println(prev);
                        gamesCross++;
                        player = 'o';
                        win = true;
                    }
                    else if (gamesZero == 2)
                    {
                        blockPos('x', prev);
                        prev = gamesCross;
                        System.out.println(prev);
                        gamesCross++;
                        player = 'o';
                        win = true;
                    }
                }
                else
                {
                    win = checkWinPosition('x', prev);
                    prev = gamesCross;
                    gamesCross++;
                    player = 'o';
                }
            }
            else if (player == 'O' || player == 'o')
            {
                System.out.println("Next player is Zero");
                if (gamesZero == 0)
                {
                    if (gamesCross == 0)
                    {
                        Random rnd = new Random();
                       
Zero[gamesZero].allotPosition(rnd.nextInt(3),rnd.nextInt(3),rnd.nextInt(3));
                    
                        int x = Zero[gamesZero].getPosition("x");
                        int y = Zero[gamesZero].getPosition("y");
                        int z = Zero[gamesZero].getPosition("z");
                    
                        System.out.println(x + "," + y + "," + z);
                        player = 'x';
                        prev = gamesZero;
                        gamesZero++;
                     }
                     else if (gamesCross == 1)
                     {
                        Random rnd = new Random();
                        
                        int prev_x = Zero[prev].getPosition("x");
                        int prev_y = Zero[prev].getPosition("y");
                        int prev_z = Zero[prev].getPosition("z");
                        int x = 0, y = 0, z = 0;
                        boolean same = true;
                        
                        while (same == true)
                        {
                            x = rnd.nextInt(3);
                            y = rnd.nextInt(3);
                            z = rnd.nextInt(3);
                            if (x != prev_x)
                            {
                                if (y != prev_y)
                                {
                                    if (z != prev_z)
                                    {
                                        same = false;
                                    }
                                }
                            }
                        }
                        
                        Zero[gamesZero].allotPosition(x, y, z);
                        prev = gamesZero;
                        gamesZero++;
                        System.out.println(x + "," + y + "," + z);
                     }
                }
                else if (gamesZero == 1)
                {
                    if (gamesCross == 1)
                    {
                        secondAllot('o', prev);
                        prev = gamesZero;
                        System.out.println(prev);
                        gamesZero++;
                        player = 'x';
                        win = true;
                    }
                    else if (gamesCross == 2)
                    {
                        blockPos('o', prev);
                        System.out.println(prev);
                        prev = gamesZero;
                        gamesZero++;
                        player = 'x';
                        win = true;
                    }
                }
                else
                {
                    win = checkWinPosition('x', prev);
                    prev = gamesZero;
                    gamesZero++;
                    player = 'x';
                }
            }
            else
            {
                System.out.println("Enter the correct choice.");
                System.out.println("Enter who plays first(Cross'X'/Zero'O')");
                player = (char)System.in.read();
            }
        }
    }
    
    private static void secondAllot(char player, int prev)
    {
        System.out.println("Currently doesn't do anything...");
        System.out.println(prev);
    }
    
    private static void blockPos(char player, int prev)
    {
        System.out.println("Currently doesn't do anything...");
        System.out.println(prev);
    }
    
    private static boolean checkWinPosition(char player, int prev)
    {
        System.out.println("Currently doesn't do anything...");
        System.out.println(prev);
        return true;
    }
}