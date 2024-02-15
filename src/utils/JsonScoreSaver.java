package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonScoreSaver
{
    private static final String currentDirectory = System.getProperty("user.dir");
    private static final String filePath = currentDirectory + "/src/scores.json"; // Path to your scores.json file

    // A class representing a player's score
    public static class PlayerScore
    {
        private String name;
        private int xp;

        public PlayerScore(String name, int xp)
        {
            this.name = name;
            this.xp = xp;
        }

        // Getters and setters
        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public int getXp()
        {
            return xp;
        }

        public void setXp(int xp)
        {
            this.xp = xp;
        }
    }

    // Method to add a new score
    public static void addNewScore(String playerName, int xp)
    {
        List<PlayerScore> scores = loadScores(); // Load existing scores
        scores.add(new PlayerScore(playerName, xp)); // Add new score
        saveScores(scores); // Save updated scores back to file
    }

    // Method to load scores from JSON file
    private static List<PlayerScore> loadScores()
    {
        try (FileReader reader = new FileReader(filePath))
        {
            Gson gson = new Gson();
            Type scoreListType = new TypeToken<List<PlayerScore>>()
            {
            }.getType();
            List<PlayerScore> scores = gson.fromJson(reader, scoreListType);
            return scores != null ? scores : new ArrayList<>(); // Return loaded scores or an empty list if none
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list in case of error
        }
    }

    // Method to save scores to JSON file
    private static void saveScores(List<PlayerScore> scores)
    {
        try (FileWriter writer = new FileWriter(filePath))
        {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(scores, writer); // Convert score list to JSON and save
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
