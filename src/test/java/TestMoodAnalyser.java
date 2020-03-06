import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyser {
    MoodAnalyzer MoodAnalyser=new MoodAnalyzer();

    @Test
    public void givenMessage_whenResponse_thenSad() {
        String result=MoodAnalyser.analyseMood("I am in Sad Mood");
        Assert.assertEquals("SAD",result);
    }
}
