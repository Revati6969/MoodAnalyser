public class MoodAnalyserException extends Exception{
    enum UserDefinedDataType
    {
        NULL_EXCEPTION,
        EMPTY_EXCEPTION,
        NO_SUCH_CLASS,
        NO_SUCH_METHOD
    };
    UserDefinedDataType userDefinedObject;
    public MoodAnalyserException(String message, UserDefinedDataType userDefinedObject)
    {
        super(message);
        this.userDefinedObject = userDefinedObject;
    }
}
