package rmiconnections;

public class RMISecurityManager extends SecurityManager{
    public RMISecurityManager(){
        System.setProperty("java.security.policy", "rmipolicy");
    }
}

