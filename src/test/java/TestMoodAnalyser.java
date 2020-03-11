import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyser {

    MoodAnalyzer MoodAnalyser=new MoodAnalyzer();

    @Test
    public void givenMessage_WhenResponse_ThenSad() {
        String result=MoodAnalyser.analyseMood("I am in Sad Mood");
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_WhenResponse_ThenHappy() {
        String result1=MoodAnalyser.analyseMood("I am in Any Mood");
        Assert.assertEquals("HAPPY",result1);
    }

    @Test
    public void givenNull_WhenResponse_ThenHappy() {
        String result1=MoodAnalyser.analyseMood(null);
        Assert.assertEquals("HAPPY",result1);
    }



}
