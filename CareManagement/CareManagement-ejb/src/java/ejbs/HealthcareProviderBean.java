/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;


import entities.HealthcareProvider;
import entities.HealthcareProvider;
import entities.User;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Joao_Pinto
 */
@Stateless
public class HealthcareProviderBean {
    
    @PersistenceContext
    private EntityManager em;

    public void createHealthcareProvider()  {
    }
    
    public List<HealthcareProvider> getAllHealthcareProviders() {
        return new LinkedList<>();
    }
    
    public void updateHealthcareProvider() {
    }

    public void removeHealthcareProvider() {
    }
    
    public void associatePatient() {
    }
    
    public void associateCaregiver() {
    }
}
