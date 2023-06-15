package elo;


import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonSimpleParser parser = new JsonSimpleParser();
        EventRoot root = parser.parse();

//        System.out.println("Root: " + root.toString());

        List<Event> list = root.getEvent();
        System.out.println(root.getEvent().get(0));
        System.out.println(root.getEvent().get(0).getWinner());

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