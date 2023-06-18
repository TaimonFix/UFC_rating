package elo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        JsonSimple parser = new JsonSimple();
        EventRoot root = parser.parse();

//        System.out.println("Root: " + root.toString());

        HashMap<String, Integer> fightersMap = root.getFightersMap();
        List<String> weightClassList = root.getWeightClasses();
        HashMap<String, Integer> ratingMap = root.getRatingMap();
        HashMap<String, String> weightClassesMap = root.getWeightClassesMap();

        RatingRoot ratingRoot = new RatingRoot();
        ratingRoot.createRatingList(fightersMap, ratingMap, weightClassesMap);

        JsonSimple packer = new JsonSimple();
        packer.pack(ratingRoot);
    }
}