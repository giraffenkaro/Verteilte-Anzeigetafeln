package rmiconnections;

public class RMISecurityManager extends SecurityManager{
    public RMISecurityManager(){
        System.setProperty("java.security.policy", "file:/rmiconnections/rmi.policy");
    }
}

