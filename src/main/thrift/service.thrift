namespace java com.example.demoMultiController

include "model.thrift"

service THelloWorldService {
   model.TResult sum(1:model.TSumRequest sumRequest)
        throws (1:model.TServiceException serviceException);
}


