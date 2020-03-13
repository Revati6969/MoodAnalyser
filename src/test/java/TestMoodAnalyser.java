import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyser {

    @Test
    public void givenMessage_WhenResponse_ThenSad() throws MoodAnalyserException {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer("I am in Sad Mood");
        Assert.assertEquals("SAD",MoodAnalyser.analyseMood());
    }

    @Test
    public void givenMessage_WhenResponse_ThenHappy() throws MoodAnalyserException {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer("I am in any Mood");
        Assert.assertEquals("HAPPY",MoodAnalyser.analyseMood());
    }

    @Test
    public void givenNull_WhenNull_ThenThrowException() throws MoodAnalyserException{
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer(null);
        Assert.assertEquals("HAPPY",MoodAnalyser.analyseMood());
    }

    @Test
    public void givenMessage_WhenNull_ThenShouldReturnCustomException() {
        try {
         MoodAnalyzer MoodAnalyser = new MoodAnalyzer(null);
            MoodAnalyser.analyseMood();
        }
        catch(MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefinedDataType.NULL_EXCEPTION,e.userDefinedObject);
        }
    }




}
