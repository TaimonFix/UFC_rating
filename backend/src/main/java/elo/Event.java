package elo;

import java.util.HashMap;
import java.util.List;

public class Event {
    private String winner;
    private String loser;
    private String weightClass;

    public Event(String winner, String loser, String weightClass) {
        this.winner = winner;
        this.loser = loser;
        this.weightClass = weightClass;
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

    public HashMap<String, Integer> rating(HashMap<String, Integer> fightersMap, HashMap<String, Integer> ratingMap) {
//        HashMap<String, Integer> ratingMap = new HashMap<>();


        if (!ratingMap.containsKey(winner)) {
            ratingMap.put(winner, 0);
        }

        if (!ratingMap.containsKey(loser)) {
            ratingMap.put(loser, 0);
        }

        int ratingA = ratingMap.get(winner);
        int ratingB = ratingMap.get(loser);

        TheEloAlgorithm elo = new TheEloAlgorithm(ratingA, ratingB);

        double expectedNumberA = elo.getExpectedNumber(ratingA, ratingB);
        double expectedNumberB = elo.getExpectedNumber(ratingB, ratingA);

        int fightCountA = fightersMap.get(winner);
        int fightCountB = fightersMap.get(loser);

        ratingA = elo.setNewRating(ratingA, 1, expectedNumberA, fightCountA);
        ratingB = elo.setNewRating(ratingB, 0, expectedNumberB, fightCountB);

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
                '}';
    }
}
