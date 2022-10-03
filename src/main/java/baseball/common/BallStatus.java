package baseball.common;

public enum BallStatus {
    NOTHING("nothing", "낫싱"),
    BALL("ball", "볼"),
    STRIKE("strike", "스트라이크");

    private final String key;
    private final String status;

    BallStatus(String key, String status) {
        this.key = key;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
