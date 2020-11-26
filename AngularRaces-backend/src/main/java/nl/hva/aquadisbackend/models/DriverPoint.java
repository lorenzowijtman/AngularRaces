package nl.hva.aquadisbackend.models;

public class DriverPoint {
    private RacedriverEntity driver;
    private int score;

    public DriverPoint(RacedriverEntity driver, int score) {
        this.driver = driver;
        this.score = score;
    }

    public RacedriverEntity getDriver() {
        return driver;
    }

    public void setDriver(RacedriverEntity driver) {
        this.driver = driver;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
