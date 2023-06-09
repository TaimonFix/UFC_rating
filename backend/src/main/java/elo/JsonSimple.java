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

public class JsonSimple implements Json {

    public EventRoot parse() {
        EventRoot root = new EventRoot();
        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader("parsing/data_new.json")) {
            JSONArray eventJsonArray = (JSONArray) parser.parse(reader);

            List<Event> eventList = new ArrayList<>();

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
        JSONArray jsonArray = new JSONArray();
        for (Rating rating: root.getRatingList()) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("name", rating.getFighter());
            jsonObject.put("weightClass", rating.getWeightClass());
            jsonObject.put("fightNum", rating.getFightCount());
            jsonObject.put("elo", rating.getRating());
            jsonArray.add(jsonObject);
        }

        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("parsing/rating.json"))) {
            writer.write(jsonArray.toJSONString());
            System.out.println("Данные упакованы в parsing/rating.json");
        } catch (Exception e) {
            System.out.println("Packing error: " + e.toString());
        }
    }
}
