public class MoodAnalyzer {
    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyser");
    }
    private String message;

    public MoodAnalyzer(){
    }

    public MoodAnalyzer(String message)
    {
        this.message=message;
    }

    public String analyseMood(String message)
    {
        this.message=message;
        return analyseMood();
    }

    public String analyseMood ()
    {
        try {
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        }catch (NullPointerException e)
        {
            return "HAPPY";
        }

    }
}
