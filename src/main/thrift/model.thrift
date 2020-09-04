namespace java com.example.demoMultiController

struct TSumRequest {
    1: required i32 firstNumber,
    2: required i32 secondNumber
}

struct TResult {
    1: required i32 value
}


enum TServiceErrorCode {
    ILLEGAL_INPUT,
    INTERNAL_ERROR
}

exception TServiceException {
    1: required TServiceErrorCode errorCode,
    2: required string message
}

exception TInternalErrorException {
}
