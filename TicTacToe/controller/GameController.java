package projects.TicTacToe.controller;

import projects.TicTacToe.model.*;
import projects.TicTacToe.service.winningStrategy.WinningStrategy;
import projects.TicTacToe.service.winningStrategy.WinningStrategyFactory;
import projects.TicTacToe.service.winningStrategy.WinningStrategyName;

import java.util.*;

public class GameController {

    public Game createGame(int dimension, List<Player> players, WinningStrategyName winningStrategyName)
    {
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(WinningStrategyFactory.getWinningStrategy(winningStrategyName,dimension))
                .build();
    }
    public void displayBoard(Game game)
    {
        game.getCurrentBoard().displayBoard();
    }
    public GameStatus getGameStatus(Game game)
    {
        return game.getGameStatus();
    }
    public Move executeMove(Game game, Player player)
    {
        return player.makeMove(game.getCurrentBoard());
    }
    public Player checkWinner(Game game, Move lastPlayedMove)
    {
        return game.getWinningStrategy().checkWinner(game.getCurrentBoard(),lastPlayedMove, game);
    }
    public Board undoMove(Game game, Move lasePlayedMove)
    {
        return null;
    }
    public void replayGame(Game game)
    {

    }


}
