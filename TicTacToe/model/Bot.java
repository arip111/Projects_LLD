package projects.TicTacToe.model;

import projects.TicTacToe.service.botPlayingStrategy.BotPlayingStartegyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, "Jessi", symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        return BotPlayingStartegyFactory.botStartegy().makeMove(board,this);
    }
}
