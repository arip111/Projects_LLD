package projects.TicTacToe;

import projects.TicTacToe.controller.GameController;
import projects.TicTacToe.model.*;
import projects.TicTacToe.service.winningStrategy.WinningStrategy;
import projects.TicTacToe.service.winningStrategy.WinningStrategyName;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome in TicTacToe");
        System.out.println("Enter the Dimension");
        int dimension = sc.nextInt();
        System.out.println("Do you Want BOT ? Y/N");
        String bot = sc.next();
        int id =1;
        List<Player> players = new ArrayList<>();
        if(bot.equalsIgnoreCase("Y"))
        {
            Player botPlayer = new Bot(id++,'$', BotDifficultyLevel.HARD);
            players.add(botPlayer);
        }

        while (id<dimension)
        {
            System.out.println("Please Enter the Player Name");
            String name = sc.next();
            System.out.println("Please Enter the Symbol");
            char symbol = sc.next().charAt(0);
            Player newPlayer = new Player(id++,name,symbol, PlayerType.HUMAN);
            players.add(newPlayer);
        }
        //Collections.shuffle(players);

        Game game = gameController.createGame(dimension,players, WinningStrategyName.OREDERONEWINNINGSTRATEGY);
        int playerIndex = -1;
        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS))
        {
            System.out.println("Board Status");
            gameController.displayBoard(game);
            playerIndex++;
            playerIndex = playerIndex%players.size();
            Move move = gameController.executeMove(game,players.get(playerIndex));
            Player winner = gameController.checkWinner(game,move);
            if(winner != null)
            {
                System.out.println("CONGRATS : WINNER IS "+winner.getName());
                break;
            }
        }
        if(game.getGameStatus().equals(GameStatus.DRAW))
        {
            System.out.println("Game is Draw");
        }
        System.out.println("Final Board Status");
        gameController.displayBoard(game);
        System.out.println("END");

    }
}
