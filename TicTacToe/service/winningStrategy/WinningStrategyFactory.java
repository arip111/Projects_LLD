package projects.TicTacToe.service.winningStrategy;

public class WinningStrategyFactory {

    public static WinningStrategy getWinningStrategy(WinningStrategyName names, int dimension)
    {
        return new Order1WinningStrategy(dimension);
    }
}
