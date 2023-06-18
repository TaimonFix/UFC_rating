package elo;

public class Rating {

    private String fighter;
    private String weightClass;
    private int fightCount;
    private int rating;

    public Rating(String fighter, String weightClass, int fightCount, int rating) {
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

    public int getRating() {
        return rating;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public int getFightCount() {
        return fightCount;
    }

    public void setFightCount(int fightCount) {
        this.fightCount = fightCount;
    }



    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "fighter='" + fighter + '\'' +
                ", weightClass='" + weightClass + '\'' +
                ", fightCount='" + fightCount + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
