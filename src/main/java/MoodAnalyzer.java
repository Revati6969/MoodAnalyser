import java.util.Objects;

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

    public String analyseMood() throws MoodAnalyserException
    {
        try {
            if (message.length()==0)
                throw new MoodAnalyserException("Mood should not be empty",MoodAnalyserException.UserDefinedDataType.EMPTY_EXCEPTION);
            else if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException npe)
            {
                throw new MoodAnalyserException("Mood should not be null",MoodAnalyserException.UserDefinedDataType.NULL_EXCEPTION);
            }
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
