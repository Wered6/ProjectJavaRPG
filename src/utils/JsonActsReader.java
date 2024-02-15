package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class JsonActsReader
{
    private static String filePath;
    private static List<Act> acts;

    static
    {
        // Assuming there is a default file path, otherwise this must be set before using getIntro
        String currentDirectory = System.getProperty("user.dir");
        filePath = currentDirectory + "/src/acts.json";
        loadActs();
    }

    private static void loadActs()
    {
        try (FileReader reader = new FileReader(filePath))
        {
            Gson gson = new Gson();
            ActsWrapper actsWrapper = gson.fromJson(reader, ActsWrapper.class);
            acts = actsWrapper.getActs();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getActTitle(String actNumber)
    {
        Optional<Act> act = acts.stream().filter(a -> a.getActNumber().equals(actNumber)).findFirst();
        return act.map(Act::getActTitle).orElse("Act not found");
    }

    public static String getIntro(String actNumber)
    {
        Optional<Act> act = acts.stream().filter(a -> a.getActNumber().equals(actNumber)).findFirst();
        return act.map(Act::getIntro).orElse("Act not found");
    }

    public static String getOutro(String actNumber)
    {
        Optional<Act> act = acts.stream().filter(a -> a.getActNumber().equals(actNumber)).findFirst();
        return act.map(Act::getOutro).orElse("Act not found");
    }

    // Other static methods...

    public static void setFilePath(String fp)
    {
        filePath = fp;
        loadActs();
    }

    // Inner class to match the JSON structure
    public static class ActsWrapper
    {
        private List<Act> acts;

        public List<Act> getActs()
        {
            return acts;
        }
    }

    static class Act
    {
        private String actNumber;
        private String actTitle;
        private String intro;
        private String outro;

        public String getActNumber()
        {
            return actNumber;
        }

        public void setActNumber(String actNumber)
        {
            this.actNumber = actNumber;
        }

        public String getActTitle()
        {
            return actTitle;
        }

        public void setActTitle(String actTitle)
        {
            this.actTitle = actTitle;
        }

        public String getIntro()
        {
            return intro;
        }

        public void setIntro(String intro)
        {
            this.intro = intro;
        }

        public String getOutro()
        {
            return outro;
        }

        public void setOutro(String outro)
        {
            this.outro = outro;
        }
    }
}
