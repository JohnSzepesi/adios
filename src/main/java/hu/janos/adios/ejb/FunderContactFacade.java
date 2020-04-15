/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.janos.adios.ejb;

import hu.janos.adios.model.FunderContact;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felhasználó
 */
@Stateless
public class FunderContactFacade extends AbstractFacade<FunderContact> {

    @PersistenceContext(unitName = "hu.janos_adios_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FunderContactFacade() {
        super(FunderContact.class);
    }
    
}
