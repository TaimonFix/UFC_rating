package elo;

public class Rating {

    private String fighter;
    private String weightClass;
    private String fightCount;
    private String rating;

    public Rating(String fighter, String weightClass, String fightCount, String rating) {
        this.fighter = fighter;
        this.weightClass = weightClass;
        this.fightCount = fightCount;
        this.rating = rating;
    }

    public String getFighter() {
        return fighter;
    }

    public void setFighter(String fighter) {
        this.fighter = fighter;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public String getFightCount() {
        return fightCount;
    }

    public void setFightCount(String fightCount) {
        this.fightCount = fightCount;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
