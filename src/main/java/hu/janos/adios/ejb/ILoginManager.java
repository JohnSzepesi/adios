package hu.janos.adios.ejb;

import javax.ejb.Local;

@Local
public interface ILoginManager {
    
    boolean authenticate(String userName, String password);
    
}