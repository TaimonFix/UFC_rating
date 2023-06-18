package elo;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class RatingRoot {

    public List<Rating> ratingList;

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public void createRatingList(HashMap<String, Integer> fightersMap, HashMap<String, Integer>
            ratingMap, HashMap<String, String> weightClassesMap) {
        Set<String> fighters = weightClassesMap.keySet();
        for (String fighter: fighters) {
            int fightCount = fightersMap.get(fighter);
            int ratingELO = ratingMap.get(fighter);
            String weightClass = weightClassesMap.get(fighter);
            Rating rating = new Rating(fighter, weightClass, fightCount, ratingELO);
            ratingList.add(rating);
        }
    }

    @Override
    public String toString() {
        return "RatingRoot{" +
                "ratingList=" + ratingList +
                '}';
    }
}
