import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;
public class Main {

    //initiates display
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    // clear board
    private static void clearBoard()
    {
        for (int row = 0; ROW > row; row++)
        {
            for (int col = 0; COL > col; col++)
            {
                board[row][col] = "   ";
            }
        }
    }

    // Output's the game board
    private static void display()

    {
        String displayBoard = "";
        for (int r = 0; ROW > r; r++)
        {
            for (int c = 0; COL > c; c++)
            {
                if (c == COL - 1)

                {
                    displayBoard = displayBoard + board[r][c];
                } else

                {
                    displayBoard = displayBoard + board[r][c] + "!";
                }
            }
            if (r != ROW - 1)

            {
                displayBoard = displayBoard + "\n~~~+~~~+~~~\n";
            }

        }
        System.out.println(displayBoard);
    }

    //validates input
    private static boolean isValidMove(int row, int col) {
        return true;


    }

    //Colum win condition
    private static boolean isColWin(String player)
    {

        for (int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player)
                    && board[2][col].equals(player))

            {
                return true;
            }
        }
        return false;
    }

    //row wins
    private static boolean isRowWin(String players)
    {
        for (int row = 0; row < ROW; row++)
        {
            if (board[row][0].equals(players) && board[row][1].equals(players)

                    && board[row][2].equals(players))
            {
                return true;
            }
        }
        return false;
    }

    //diagonal wins
    private static boolean isDiagonalWin(String player)
    {
        if ((board[0][2].equals(player) &&
                board[1][1].equals(player)
                && board[2][0].equals(player)) ||
                (board[0][0].equals(player) && board[1][1].equals(player)
                        && board[2][2].equals(player))) {
            return true;
        } else

        {
            return false;
        }
    }

    // player wins
    private static boolean isWin(String player)

    {
        if (isRowWin(player) || isColWin(player)

                || isDiagonalWin(player))

        {
            return true;
        } else

        {
            return false;
        }
    }


    private static boolean isTie()

    {

        int countX0 = 0;

        if (isTieRows())

        {
            countX0++;
        }
        if (isTieCols())

        {
            countX0++;
        }
        if (isTieDiagDown())
        {
            countX0++;
        }
        if (isTieDiagUp())

        {
            countX0++;
        }

        if (countX0 >= 3)
        {
            return true;
        }
        return false;
    }


    private static boolean isTieRows()
    {
        int countX = 0;
        int countO = 0;
        int w = 0;


        for (int r = 0; r < ROW; r++)
        {

            countX = 0;
            countO = 0;


            for (int c = 0; c < COL; c++)
            {
                if (board[r][c].equals(" X "))
                {
                    countX++;
                } else if (board[r][c].equals(" O "))

                {
                    countO++;
                }
                if (countX >= 1 && countO >= 1)
                {
                    w++;
                }
            }
        }
        if (w >= 3)
        {
            return true;
        } else

        {
            return false;
        }
    }


    private static boolean isTieCols()
    {
        int countX = 0;
        int countO = 0;
        int w = 0;
        for (int r = 0; r < ROW; r++)
        {
            countX = 0;
            countO = 0;
            for (int c = 0; c < COL; c++) {
                if (board[c][r].equals(" X "))
                {
                    countX++;
                } else if (board[c][r].equals(" O "))
                {
                    countO++;
                }
                if (countX >= 1 && countO >= 1)
                {
                    w++;
                }
            }
        }
        if (w > 2)
        {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isTieDiagDown()
    {
        int countX = 0;
        int countO = 0;

        for (int r = 0; r < ROW; r++)
        {
            if (board[r][r].equals(" X "))
            {
                countX++;
            } else if (board[r][r].equals(" O "))
            {
                countO++;
            }
        }
        if (countX >= 1 && countO >= 1)
        {
            return true;
        } else {
            return false;
        }
    }


    private static boolean isTieDiagUp()
    {
        int countX = 0;
        int countO = 0;


        if (board[0][2].equals(" X "))
        {
            countX++;
        } else if (board[0][2].equals(" O "))

        {
            countO++;
        }
        if (board[1][1].equals(" X "))
        {
            countX++;
        } else if (board[1][1].equals(" O "))
        {
            countO++;
        }
        if (board[2][0].equals(" X "))
        {
            countX++;
        } else if (board[2][0].equals(" O "))
        {
            countO++;
        }
        if (countX >= 1 && countO >= 1)
        {
            return true;
        } else

        {
            return false;
        }
    }

    public static void main(String[] args)

    {
        Scanner scan = new Scanner(System.in);

        int row;
        int col;
        int games = 0;

        String fP = "Player #1";
        String sP = "Player #2";

        String fplayer = " X ";
        String splayer = " O ";
        String mover = fplayer;
        String starter;
        int moves;

        System.out.println("  Welcome To: \n" +
                " +-+-+-+-+-+-+-+-+-+-+-+\n" +
                " |T|i|c|-|T|a|c|-|T|o|e|\n" +
                " +-+-+-+-+-+-+-+-+-+-+-+\n");

        do {
            games++;
            moves = 0;
            clearBoard();
            display();
            for (int i = 0; i <= 10; i++)

            { // maximum 9 turns for 9 spaces on the board
                if (i % 2 == 0)
                {
                    mover = fplayer;
                    starter = fP;
                } else

                {
                    mover = splayer;
                    starter = sP;
                }
                System.out.println( starter + " You're Up!");
                do

                {
                    row = SafeInput.getRangedInt(scan, "Input your row position", 1, 3) - 1;
                    col = SafeInput.getRangedInt(scan, "Input your column position", 1, 3) - 1;

                } while (!isValidMove(row, col));

                moves++;
                board[row][col] = mover;
                display();

                //Validates a win
                if (moves > 4)

                {     //Validates a win
                    if (isWin(mover))

                    {
                        System.out.println(mover + " player Wins! Nice try other player!");
                        break;

                    } else if (moves > 6)

                    {
                        if (isTie())

                        { // prompts the draw
                            System.out.println("Raining Cats and Dogs!! It's a Draw!");
                            break;
                        }
                    }
                }
            }
            if (fplayer.equals(" X "))

            {
                fplayer.equals(" X ");
                splayer.equals(" O ");
            } else

            {
                fplayer.equals(" X ");
                splayer.equals(" O ");
            }


            //prompts user to play again
        } while (SafeInput.getYNConfirm(scan,
                "  \n" +
                        " ___       \n" +
                        "____   _____   _____  _____     ____   ___  ___  __ _____ \n" +
                        "(( ___ ((   )) ((   )) ||  )    (( ___ ||=|| || \\/ | ||==  \n" +
                        " \\\\_||  \\\\_//   \\\\_//  ||_//     \\\\_|| || || ||    | ||___\n" +
                        "Do you want to play again? yes or no?  [Y/N] " ));



    }

}