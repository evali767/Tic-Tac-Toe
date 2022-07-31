import java.util.Scanner;
public class TicTacToe {

    //the gameboard
    private String[][] gameBoard = new String[3][3];
    private boolean player1x = true;
    private boolean win = false;
    //private boolean draw = true;

    public TicTacToe() {
        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[r].length; c++) {
                gameBoard[r][c] = " ";
            }
        }
    }

    //part a: print the board
    public void printBoard() {
        for(int a = 0;a<gameBoard.length;a++)
        {
            for(int b = 0;b<gameBoard[a].length;b++)
            {
                System.out.print(" " + gameBoard[a][b] + " ");
                if(b != 2)
                {
                    System.out.print("|");
                }
            }
            System.out.println();
            if(a != 2)
            {
                System.out.println("-----------");
            }
        }
        //Eva did this 

    }

    //part b: playerMove
    public void playerMove() {
        Scanner scan = new Scanner(System.in);  

        System.out.println("What row do you want to put your symbol in?");
        int r = scan.nextInt();
        System.out.println("What column do you want to put your symbol in?");
        int c = scan.nextInt();
        while ((r >2 || r < 0) || (c >2 || c < 0) || !(gameBoard[r][c].equals(" ")))
        {
            System.out.println("That position does not work, please choose another position.");
            System.out.println("What row do you want to put your symbol in?");
            r = scan.nextInt();
            System.out.println("What column do you want to put your symbol in?");
            c = scan.nextInt();
        }
        
        if (gameBoard[r][c].equals(" "))
        {
            if (player1x)
            {
                gameBoard[r][c] = "x";
                player1x = false;
            }
            else {
                gameBoard[r][c] = "o";
                player1x = true;
            }
        }
        //Angel did this
    }

    //part c: checkWin
    public void checkWin() {
        boolean draw = true;
        for(int i = 0;i<gameBoard.length;i++)
        {
            if((gameBoard[i][0].equals (gameBoard[i][1])) && (gameBoard[i][1] .equals (gameBoard[i][2])) && ((gameBoard[i][0] .equals ("x")) || (gameBoard[i][0] .equals ("o"))))
            {
                System.out.println(gameBoard[i][1] + " wins!");
                win = true;
                draw= false;
            }
        }
        for(int x = 0;x<gameBoard[0].length;x++)
        {
            if((gameBoard[0][x].equals (gameBoard[1][x])) && (gameBoard[1][x] .equals (gameBoard[2][x])) && (gameBoard[0][x] .equals ("x") || (gameBoard[0][x] .equals ("o"))))
            {
                System.out.println(gameBoard[0][x] + " wins!");
                win = true;
                draw = false;
            }
        }
        if ((gameBoard[0][0].equals(gameBoard[1][1])) && (gameBoard[1][1].equals(gameBoard[2][2])) && (gameBoard[0][0].equals(gameBoard[2][2])) && (gameBoard[1][1] .equals ("x") || (gameBoard[1][1] .equals ("o"))))
        {
            System.out.println(gameBoard[0][0] + " wins!");
            win = true;
            draw = false;
        }
        if((gameBoard[0][2].equals(gameBoard[1][1])) && (gameBoard[1][1].equals(gameBoard[2][0])) && (gameBoard[0][2] .equals ("x") || (gameBoard[0][2] .equals ("o"))))
        {
            System.out.println(gameBoard[0][2] + " wins!");
            win = true;
            draw = false;
        }
        boolean full = true;
        for(int a = 0;a<gameBoard.length;a++)
        {
            for(int b = 0;b<gameBoard[0].length;b++)
            {
             if(gameBoard[a][b] .equals (" "))
             {
                full = false;
             }   
            }
        }
        if (full && draw)
        {
            System.out.println("It's a draw!");
        }

    }

    public boolean getWin()
    {
        return win;
    }

    /*public boolean getDraw()
    {
        return draw;
    }*/

    //This method allows for the AI opponent to move, it randomly inputs the symbol in the game.
    public void aiMove()
    {
        int r1 = (int)(Math.random() * 3);
        int c1 = (int)(Math.random() * 3);
        while (!(gameBoard[r1][c1].equals(" ")))
        {
            r1 = (int)(Math.random() * 3);
            c1 = (int)(Math.random() * 3);
        }
        gameBoard[r1][c1] = "o";
        
    }

    //This method allows for the player to move if they choose to play against an AI opponent.
    public void playerMove2()
    {
        Scanner scan = new Scanner(System.in);  

        System.out.println("What row do you want to put your symbol in?");
        int r = scan.nextInt();
        System.out.println("What column do you want to put your symbol in?");
        int c = scan.nextInt();
        while ((r >2 || r < 0) || (c >2 || c < 0) || !(gameBoard[r][c].equals(" ")))
        {
            System.out.println("That position does not work, please choose another position.");
            System.out.println("What row do you want to put your symbol in?");
            r = scan.nextInt();
            System.out.println("What column do you want to put your symbol in?");
            c = scan.nextInt();
        }
        gameBoard[r][c] = "x";
    }
}
