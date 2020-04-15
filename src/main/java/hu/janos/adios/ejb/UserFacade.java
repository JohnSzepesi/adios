package hu.janos.adios.ejb;

import hu.janos.adios.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Felhasználó
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "hu.janos_adios_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User getUserByName(String userName){
    
        User user = null;
        try {
            TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class);
            query.setParameter("userName", userName);
            List<User> resultList = query.getResultList();
            if(resultList.size()!=1){
            throw new Exception();
            }else{
            user= resultList.get(0);
            }
        } catch (Exception e) {
            
        }
        return user;
    }
    
}
