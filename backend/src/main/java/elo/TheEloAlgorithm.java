package elo;

public class TheEloAlgorithm {
    private double expectedNumber; // ожидаемое количество очков, которое наберёт игрок
    private double resultNumber; // исход: 1 - победа, 0.5 - ничья, 0 - поражение
    private int ratingA; // рейтинг игрока А
    private int ratingB; // рейтинг игрока B

    public TheEloAlgorithm(double resultNumber, int ratingA, int ratingB) {
        this.resultNumber = resultNumber;
        this.ratingA = ratingA;
        this.ratingB = ratingB;
    }

    private static double getExpectedNumber(int ratingA, int ratingB) {
        return 1 / (1 + 10 * (ratingB - ratingA) / 400);
    }

    private static int setNewRating(int ratingA, int resultNumber, int expectedNumber, int fightCount) {
        int k; // коэффициент, зависящий от рейтинга игрока

        if (ratingA >= 2400) {
            k = 10;
        } else if (ratingA <  2400 && fightCount > 3) {
            k = 20;
        } else {
            k = 40;
        }
        return ratingA + k * (resultNumber - expectedNumber);
    }
}
