package projects.TicTacToe.service.winningStrategy;

import projects.TicTacToe.model.*;

public interface WinningStrategy {

    Player checkWinner(Board board, Move lastMove, Game game);
}
