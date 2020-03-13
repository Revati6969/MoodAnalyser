import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

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
    public void givenMessage_WhenNull_ThenShouldReturnCustomException() {
        try {
         MoodAnalyzer MoodAnalyser = new MoodAnalyzer(null);
            MoodAnalyser.analyseMood();
        }
        catch(MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefinedDataType.NULL_EXCEPTION,e.userDefinedObject);
        }
    }

    @Test
    public void GivenEmptyMessage_ShouldReturn_EmptyMoodException()
    {
        try{
            MoodAnalyzer MoodAnalyser = new MoodAnalyzer("");
            MoodAnalyser.analyseMood();
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.UserDefinedDataType.EMPTY_EXCEPTION,e.userDefinedObject);
        }
    }

    @Test
    public void givenObject_WhenEquals_ThenTrue() throws MoodAnalyserException {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer();
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer");
        MoodAnalyzer moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
        boolean result = MoodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }

    @Test
    public void givenClass_WhenWrong_ThenReturnClassNotFound() {
        try {
            MoodAnalyserFactory.getConstructor("Moodanalyser");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefinedDataType.NO_SUCH_CLASS,e.userDefinedObject);
        }
    }

    @Test
    public void givenConstructor_WhenWrong_ThenReturnNoSuchMethod() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefinedDataType.NO_SUCH_METHOD,e.userDefinedObject);
        }
    }

    @Test
    public void givenObject_WhenEqualsWithParameter_ThenTrue() throws MoodAnalyserException {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer("Hello");
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",String.class);
        MoodAnalyzer moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"Hello");
        boolean result = MoodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }
}
