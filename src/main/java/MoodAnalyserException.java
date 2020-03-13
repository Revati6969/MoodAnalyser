public class MoodAnalyserException extends Exception{
    enum UserDefinedDataType
    {
        NULL_EXCEPTION,
        EMPTY_EXCEPTION
    };
    UserDefinedDataType userDefinedObject;
    public MoodAnalyserException(String message, UserDefinedDataType userDefinedObject)
    {
        super(message);
        this.userDefinedObject = userDefinedObject;
    }
}
