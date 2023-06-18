package elo;

public interface Json {
    default EventRoot parse() {
        return null;
    }

    default void pack(RatingRoot root) {
    }
}
