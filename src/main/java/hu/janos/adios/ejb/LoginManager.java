package hu.janos.adios.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import hu.janos.adios.model.User;

@Stateless
public class LoginManager implements ILoginManager{
    
    @PersistenceContext(unitName = "hu.janos_adios_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    

    @Override
    public boolean authenticate(String userName, String password) {
        User user = null;
        try {
            TypedQuery<User> query = em.createNamedQuery("User.findByUsername",User.class);
            query.setParameter("username", userName);
            List<User> resultList = query.getResultList();
                if(query.getResultList().isEmpty())
                    throw new Exception();
            
                    } catch (Exception e) {
                        return false;
                    }
        
        return true;
    }
    
}