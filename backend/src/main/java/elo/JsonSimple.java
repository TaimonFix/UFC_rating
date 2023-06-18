package elo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonSimple {

    public EventRoot parse() {
        EventRoot root = new EventRoot();
        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader("parsing/data_new.json")) {
            JSONArray eventJsonArray = (JSONArray) parser.parse(reader);

            List<Event> eventList = new ArrayList<>();
//            for(Object it: eventJsonArray) {
//                JSONObject eventObject = (JSONObject) it;
//
//                String winner = (String) eventObject.get("Winner");
//                String loser = (String) eventObject.get("Loser");
//                String weightClass = (String) eventObject.get("Weight class");
//
//                Event event = new Event(winner, loser, weightClass);
//
//                eventList.add(event);
//            }

            for(int i = eventJsonArray.size() - 1; i >= 0; i--) {
                JSONObject eventObject = (JSONObject) eventJsonArray.get(i);

                String winner = (String) eventObject.get("Winner");
                String loser = (String) eventObject.get("Loser");
                String weightClass = (String) eventObject.get("Weight class");
                boolean draw = (Boolean) eventObject.get("Draw");

                Event event = new Event(winner, loser, weightClass, draw);

                eventList.add(event);
            }

            root.setEvent(eventList);

            System.out.println(eventList.size());
            return root;

        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }

        return null;
    }

    public void pack(RatingRoot root) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Rating rating: root.getRatingList()) {
            jsonObject.put("name", rating.getFighter());
            jsonObject.put("weightClass", rating.getWeightClass());
            jsonObject.put("fightNum", rating.getFightCount());
            jsonObject.put("elo", rating.getRating());
            jsonArray.add(jsonObject);
        }

        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("rating.json"))) {

            writer.write(jsonArray.toJSONString());
        } catch (Exception e) {
            System.out.println("Packing error: " + e.toString());
        }



    }



}
