package elo;

import java.util.HashMap;

public class Event {
    private String winner;
    private String loser;
    private String weightClass;
    private boolean draw;

    public Event(String winner, String loser, String weightClass, boolean draw) {
        this.winner = winner;
        this.loser = loser;
        this.weightClass = weightClass;
        this.draw = draw;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public void putFighters(HashMap<String, Integer> fightersMap) {
        if (fightersMap.containsKey(winner)) {
            fightersMap.put(winner, fightersMap.get(winner) + 1);
        } else {
            fightersMap.put(winner, 1);
            }

        if (fightersMap.containsKey(loser)) {
            fightersMap.put(loser, fightersMap.get(loser) + 1);
        } else {
            fightersMap.put(loser, 1);
        }
    }

    public void putWeightClasses(HashMap<String, String> weightClassesMap) {
        weightClassesMap.put(winner, weightClass);
        weightClassesMap.put(loser, weightClass);
    }

    public HashMap<String, Integer> rating(HashMap<String, Integer> fightersMap, HashMap<String, Integer> ratingMap) {

        if (!ratingMap.containsKey(winner)) {
            ratingMap.put(winner, 200);
        }

        if (!ratingMap.containsKey(loser)) {
            ratingMap.put(loser, 200);
        }

        int ratingA = ratingMap.get(winner);
        int ratingB = ratingMap.get(loser);

        TheEloAlgorithm elo = new TheEloAlgorithm(ratingA, ratingB);

        double expectedNumberA = elo.getExpectedNumber(ratingA, ratingB);
        double expectedNumberB = elo.getExpectedNumber(ratingB, ratingA);

        int fightCountA = fightersMap.get(winner);
        int fightCountB = fightersMap.get(loser);

        double resultNumberA;
        double resultNumberB;

        if (draw) {
            resultNumberA = 0.5;
            resultNumberB = 0.5;
        } else {
            resultNumberA = 1;
            resultNumberB = 0;
        }

        ratingA = elo.setNewRating(ratingA, resultNumberA, expectedNumberA, fightCountA);
        ratingB = elo.setNewRating(ratingB, resultNumberB, expectedNumberB, fightCountB);

        ratingMap.put(winner, ratingA);
        ratingMap.put(loser, ratingB);

        return ratingMap;
    }

    @Override
    public String toString() {
        return "Event{" +
                "winner='" + winner + '\'' +
                ", loser='" + loser + '\'' +
                ", weightClass='" + weightClass + '\'' +
                ", draw=" + draw +
                '}';
    }
}
