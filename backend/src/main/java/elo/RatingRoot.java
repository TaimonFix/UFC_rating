package elo;

import java.util.List;

public class RatingRoot {

    public List<Rating> ratingList;

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    @Override
    public String toString() {
        return "RatingRoot{" +
                "ratingList=" + ratingList +
                '}';
    }
}
