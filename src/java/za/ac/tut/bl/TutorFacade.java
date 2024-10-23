/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.models.Tutor;

/**
 *
 * @author sifis
 */
@Stateless
public class TutorFacade extends AbstractFacade<Tutor> implements TutorFacadeLocal {

    @PersistenceContext(unitName = "TutorEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TutorFacade() {
        super(Tutor.class);
    }
    
    public int numMales() {
     Query query = em.createQuery("SELECT COUNT(t) FROM Tutor t WHERE t.gender='M'");
     Long cnt = (Long)query.getSingleResult();
     return cnt.intValue();
             
    }

   
    public int numFemales() {
     Query query = em.createQuery("SELECT COUNT(t) FROM Tutor t WHERE t.gender='F'");
     Long cnt = (Long)query.getSingleResult();
     return cnt.intValue();
    }

    
    public double avgOfMales() {
        Query query = em.createQuery("SELECT AVG(t.age) FROM Tutor t WHERE t.gender='M'");
        Double num = (Double)query.getSingleResult();
        return num;
    }

    
    public double avgOfFemales() {
        Query query = em.createQuery("SELECT AVG(t.age) FROM Tutor t WHERE t.gender='F'");
        Double num = (Double)query.getSingleResult();
        return num;
    }

    public Tutor youngestTutor() {
       Query query = em.createQuery("SELECT t FROM Tutor t WHERE t.age=(SELECT MIN(t2.age) FROM t2)"); 
       Tutor tutor = (Tutor)query.getSingleResult();
       return tutor;
    }
    
}
