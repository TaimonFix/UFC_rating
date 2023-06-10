package elo;

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
}
