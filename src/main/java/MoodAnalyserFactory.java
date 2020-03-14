import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static MoodAnalyzer createMoodAnalyserObject(Constructor constructor,Object... objects) throws  MoodAnalyserException {
        try {
            return (MoodAnalyzer) constructor.newInstance(objects);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeMethod(Object moodAnalyserObject, String analyseMood) throws MoodAnalyserException {
        try {
            Class objectClass = moodAnalyserObject.getClass();
            Method moodMethod = objectClass.getMethod(analyseMood);
            Object result = moodMethod.invoke(moodAnalyserObject);
            return result;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException("Method not found",MoodAnalyserException.UserDefinedDataType.NO_SUCH_METHOD);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void moodAnalyserField(Object object, String message, String fieldValue) throws MoodAnalyserException {

        try {
            Class<?> classObject = object.getClass();
            Field declaredField = classObject.getDeclaredField(message);
            declaredField.set(object,fieldValue);
        } catch (NoSuchFieldException e) {
           throw new MoodAnalyserException("Field not found",MoodAnalyserException.UserDefinedDataType.NO_SUCH_FIELD);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
