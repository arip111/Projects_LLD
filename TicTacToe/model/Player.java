package projects.TicTacToe.model;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Player() {
    }

    public Move makeMove(Board board)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Row");
        int row = sc.nextInt();
        System.out.println("Enter the Column");
        int col = sc.nextInt();

        Cell playedMoveCell = board.getMatrix().get(row).get(col);
        playedMoveCell.setCellState(CellState.FILLED);
        playedMoveCell.setPlayer(this);

        return new Move(playedMoveCell,this);

    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }
}
