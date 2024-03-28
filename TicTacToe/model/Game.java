package projects.TicTacToe.model;

import projects.TicTacToe.exception.InvalidBotCountException;
import projects.TicTacToe.exception.InvalidPlayerSizeException;
import projects.TicTacToe.exception.InvalidSymbolSizeException;
import projects.TicTacToe.service.winningStrategy.WinningStrategy;

import java.util.*;
import java.util.stream.Stream;

public class Game {

    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardStates;
    private WinningStrategy winningStrategyName;
    private int numberOfSymbols;

    private Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.currentPlayer = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.winningStrategyName = winningStrategy;
        this.numberOfSymbols = players.size();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategyName;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategyName = winningStrategy;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public static Builder builder()
    {
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        private void validateNumberOfPlayers()
        {
            if( (players.size()< dimension-2 ) || ( players.size() >= dimension ) )
            {
                throw new InvalidPlayerSizeException("Player Size can not be greater than Board Size");
            }
        }
        private void validatePlayerSymbols()
        {
            HashSet<Character> symbols = new HashSet<>();
            for(Player player : players)
            {
                symbols.add(player.getSymbol());
            }
            if(symbols.size() != players.size())
            {
                throw new InvalidSymbolSizeException("Their should be unique symbols for all the Players");
            }
        }
        private void validateBotCount()
        {
            int botCount = 0;
            for(Player player : players)
            {
                if(player.getPlayerType().equals("BOT"))
                {
                    botCount++;
                }
            }
            if( botCount > 1)
            {
                throw new InvalidBotCountException("We can have only One Bot in the Game");
            }
        }

        private void validate()
        {
            validateNumberOfPlayers();
            validatePlayerSymbols();
            validateBotCount();
        }

        public Game build()
        {
            validate();
            return new Game(new Board(dimension),players,winningStrategy);
        }

    }
}
