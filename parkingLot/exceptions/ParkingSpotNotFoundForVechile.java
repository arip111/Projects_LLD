package projects.parkingLot.exceptions;

public class ParkingSpotNotFoundForVechile extends RuntimeException{
    public ParkingSpotNotFoundForVechile() {
    }

    public ParkingSpotNotFoundForVechile(String message) {
        super(message);
    }

    public ParkingSpotNotFoundForVechile(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingSpotNotFoundForVechile(Throwable cause) {
        super(cause);
    }

    public ParkingSpotNotFoundForVechile(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
