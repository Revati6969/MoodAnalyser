import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static Constructor getConstructor(String className) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            return  moodAnalyzerClass.getConstructor();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException("Class not found",MoodAnalyserException.UserDefinedDataType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyzer createMoodAnalyserObject(Constructor constructor) throws  MoodAnalyserException {
        try {
            return (MoodAnalyzer) constructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
