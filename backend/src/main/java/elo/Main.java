package elo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonSimpleParser parser = new JsonSimpleParser();
        EventRoot root = parser.parse();

//        System.out.println("Root: " + root.toString());

        HashMap<String, Integer> map = root.getFightersMap();

        System.out.println(map);

        System.out.println(map.get("Conor McGregor"));

        List<String> weightClassList = new ArrayList<>();
        System.out.println(root.getWeightClasses(weightClassList));

        HashMap<String, Integer> ratingMap = new HashMap<>();
        ratingMap = root.ratingELO();

        System.out.println(ratingMap);

        System.out.println(ratingMap.get("Khabib Nurmagomedov"));
//        System.out.println(ratingMap.get("Jon Jones"));
//        System.out.println(ratingMap.get("Georges St-Pierre"));

        System.out.println(Collections.max(ratingMap.values()));


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