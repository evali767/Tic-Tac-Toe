import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Use this class to run a TicTacToe game
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        System.out.println("#####   #####   #####" );
        System.out.println("  #       #     #");
        System.out.println("  #       #     #");
        System.out.println("  #       #     #");
        System.out.println("  #     #####   #####");
        System.out.println("<<>><<>><<>><<>><<>><<>>");
        System.out.println("#####     ##    #####");
        System.out.println("  #      #  #   #");
        System.out.println("  #     ######  #");
        System.out.println("  #     #    #  #");
        System.out.println("  #     #    #  #####");
        System.out.println("<<>><<>><<>><<>><<>><<>>");
        System.out.println("#####   #####   #####");
        System.out.println("  #     #   #   #");
        System.out.println("  #     #   #   #####");
        System.out.println("  #     #   #   #");
        System.out.println("  #     #####   #####");
        System.out.println("<<>><<>><<>><<>><<>><<>>");
        System.out.println("Welcome to Tic Tac Toe! This game uses index based numbers meaning the rows and columns range from 0 to 2. Do you want to play against another player or against an AI opponent? (0 for player OR 1 for AI)");
        int play = scan.nextInt();
        
        if (play == 0)
        {
            System.out.println("The first player is automatically x and the second player is automatically o.");
            game.printBoard();
            for (int i = 0; i < 9; i++)
            {
                game.playerMove();
                game.printBoard();
                game.checkWin();
                //i think this happens because three boxes are considered three in a row even if theyre all blank, we can probably fix that by making sure all of the boxes at least equal x or o and arent blank - UPDATE i think i fixed it ?? 
            if (game.getWin())
            {
                break;
            }
            }
        }
        
        else if (play == 1)
        {
            System.out.println("You will be x and the AI opponent will be o. Would you like to go first? (0 for YES OR 1 for NO)");
            int first = scan.nextInt();
            if (first == 0)
            {
                game.printBoard();
                for (int i = 0; i < 4; i++)
                {
                    game.playerMove2();
                    game.printBoard();
                    game.checkWin();
                    if (game.getWin())
                    {
                        break;
                    }
                    game.aiMove();
                    game.printBoard();
                    game.checkWin();
                    if (game.getWin())
                    {
                        break;
                    }
                }
                if (game.getWin() == false)
                {
                   game.playerMove2();
                    game.printBoard();
                    game.checkWin(); 
                }
            }
            else
            {
                game.printBoard();
                for (int j = 0; j < 4; j++)
                {
                    game.aiMove();
                    game.printBoard();
                    game.checkWin();
                    if (game.getWin())
                    {
                        break;
                    }
                    game.playerMove2();
                    game.printBoard();
                    game.checkWin();
                    if (game.getWin())
                    {
                        break;
                    }
                }
                if (game.getWin() == false)
                {
                    game.aiMove();
                    game.printBoard();
                    game.checkWin();
                } 
            }
        }
        

    }

}
