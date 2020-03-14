public class MoodAnalyserException extends Exception{
    enum UserDefinedDataType
    {
        NULL_EXCEPTION,
        EMPTY_EXCEPTION,
        NO_SUCH_CLASS,
        NO_SUCH_METHOD,
        NO_SUCH_FIELD,
        INVOCATION_TARGET_EXCEPTION,
        ILLEGAL_ACCESS_EXCEPTION
    };
    UserDefinedDataType userDefinedObject;
    public MoodAnalyserException(String message, UserDefinedDataType userDefinedObject)
    {
        super(message);
        this.userDefinedObject = userDefinedObject;
    }
}
