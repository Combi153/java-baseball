package baseball.domain;

public class Ball {

    private final String numberBall;
    private final String threeNumberRegularExpression = "\\d{3}";

    public Ball(String numberBall) {
        validateForm(numberBall);
        validateDuplication(numberBall);
        this.numberBall = numberBall;
    }

    private void validateForm(String numberBall) {
        if (!numberBall.matches(threeNumberRegularExpression)) {
            throw new IllegalArgumentException("세 자리 숫자만 가능합니다.");
        }
    }

    private void validateDuplication(String numberBall) {
        if (hasDuplicates(numberBall)) {
            throw new IllegalArgumentException("숫자가 중복되지 않아야 합니다.");
        }
    }

    private boolean hasDuplicates(String number) {
        return number.length() != number.chars()
                .distinct()
                .count();
    }
}