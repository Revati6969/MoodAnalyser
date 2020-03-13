import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static Constructor getConstructor(String className, Class... parameter) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            return  moodAnalyzerClass.getConstructor(parameter);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException("Class not found",MoodAnalyserException.UserDefinedDataType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException("Method not found",MoodAnalyserException.UserDefinedDataType.NO_SUCH_METHOD);
        }
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
