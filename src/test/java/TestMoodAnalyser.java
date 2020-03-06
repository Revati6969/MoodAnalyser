import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyser {

    MoodAnalyzer MoodAnalyser=new MoodAnalyzer();

    @Test
    public void givenMessage_whenResponse_thenSad() {
        String result=MoodAnalyser.analyseMood("I am in Sad Mood");
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_whenResponse_thenHappy() {
        String result1=MoodAnalyser.analyseMood("I am in Any Mood");
        Assert.assertEquals("HAPPY",result1);
    }

}
