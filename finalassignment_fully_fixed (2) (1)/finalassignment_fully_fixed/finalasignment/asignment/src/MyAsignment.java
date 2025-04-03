import logging.AssignmentLogger;


public class MyAsignment {

    public MyAsignment (){
        AssignmentLogger.logConstructor(this);
    }
    public static void main(String[] args){
        AssignmentLogger.logMain();

        new MyAsignment();
    }

    private static void name() {
        AssignmentLogger.logStaticMethodEntry();
        AssignmentLogger.logStaticMethodExit();
    }
}
