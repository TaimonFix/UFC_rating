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

        System.out.println("Root: " + root.toString());

        HashMap<String, Integer> fightersMap = root.getFightersMap();
//        System.out.println(fightersMap);
//        System.out.println(fightersMap.get("Conor McGregor"));

        List<String> weightClassList = root.getWeightClasses();
//        System.out.println(weightClassList);

        HashMap<String, Integer> ratingMap = root.getRatingMap();
//        System.out.println(ratingMap);

        HashMap<String, String> weightClassesMap = root.getWeightClassesMap();
//        System.out.println(weightClassesMap);


        System.out.println(ratingMap.get("Khabib Nurmagomedov"));
        System.out.println(ratingMap.get("Jon Jones"));



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

//        ratingRoot.createRatingList(fightersMap, ratingMap, weightClassesMap);
//        System.out.println(ratingList);
//        System.out.println("RatingRoot: " + ratingRoot.toString());
//        List<Event> list = root.getEvent();
//        System.out.println(root.getEvent().get(0));
//        System.out.println(root.getEvent().get(0).getWinner());

//        System.out.println(list.get(0).getWinner());
//
//        String name = "Mackenzie Dern";
//
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put(name, 2);
//        map.put("name", 1);
//        map.put("surname", 3);
//
//        int i = 1;
//        if (map.containsKey(name)) {
//            map.put(name, i + 3);
//        }
//        System.out.println(map.toString());
    }
}