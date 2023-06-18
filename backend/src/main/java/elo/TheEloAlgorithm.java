package elo;

public class TheEloAlgorithm {
    private double expectedNumber; // ожидаемое количество очков, которое наберёт игрок
    private double resultNumber; // исход: 1 - победа игрока, 0.5 - ничья, 0 - поражение игрока
    private int ratingA; // рейтинг игрока А
    private int ratingB; // рейтинг игрока B

    public TheEloAlgorithm(int ratingA, int ratingB) {
        this.ratingA = ratingA;
        this.ratingB = ratingB;
    }

    public double getExpectedNumber(int ratingA, int ratingB) {
        double expectedNumber;
        if (ratingA == ratingB) {
            expectedNumber = 1.0;
        } else {
            expectedNumber = 1 / (1 + Math.pow(10,  (double) (ratingB - ratingA) / 400));
        }
        return expectedNumber;
    }

    public int setNewRating(int rating, double resultNumber, double expectedNumber, int fightCount) {
        int k; // коэффициент, зависящий от рейтинга игрока

        if (rating >= 250) {
            k = 10;
        } else if (fightCount >= 3) {
            k = 20;
        } else {
            k = 40;
        }
        return (int) (rating + k * (resultNumber - expectedNumber));
    }
}
