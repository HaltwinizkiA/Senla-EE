package сom.senlainc.injection.exception;



public class InjectionException extends RuntimeException  {
    public InjectionException(String messege ){
//        new logger.Logger().log(messege);
    }
    public InjectionException(String messege ,Throwable cause){
//        new logger.Logger().log(messege,cause );
    }
    public InjectionException(Class clazz,Throwable cause){
//        new logger.Logger().log(clazz,cause );
    }
}
