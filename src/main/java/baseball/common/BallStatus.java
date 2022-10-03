package baseball.common;

public enum BallStatus {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String status;

    BallStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
