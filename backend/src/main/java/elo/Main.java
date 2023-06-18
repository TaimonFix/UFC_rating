package elo;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        List<Rating> ratingList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
        Set<String> fighters = weightClassesMap.keySet();
        for (String fighter: fighters) {
            int fightCount = fightersMap.get(fighter);
            int ratingELO = ratingMap.get(fighter);
            String weightClass = weightClassesMap.get(fighter);
            Rating rating = new Rating(fighter, weightClass, fightCount, ratingELO);
            ratingList.add(rating);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", rating.getFighter());
            jsonObject.put("weightClass", rating.getWeightClass());
            jsonObject.put("fightNum", rating.getFightCount());
            jsonObject.put("elo", rating.getRating());


            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toJSONString());
//        System.out.println(ratingList);

        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("parsing/rating.json"))) {
            writer.write(jsonArray.toJSONString());
        } catch (Exception e) {
            System.out.println("Packing error: " + e.toString());
        }
        System.out.println(Collections.max(ratingMap.values()));
    }
}