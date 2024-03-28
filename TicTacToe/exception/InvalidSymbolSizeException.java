package projects.TicTacToe.exception;

public class InvalidSymbolSizeException extends RuntimeException{
    public InvalidSymbolSizeException() {
    }

    public InvalidSymbolSizeException(String message) {
        super(message);
    }

    public InvalidSymbolSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSymbolSizeException(Throwable cause) {
        super(cause);
    }

    public InvalidSymbolSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
