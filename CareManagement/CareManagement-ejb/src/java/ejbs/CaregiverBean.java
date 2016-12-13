/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Caregiver;
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
public class CaregiverBean {

    @PersistenceContext
    private EntityManager em;

    public void createCaregiver()  {
    }
    
    public List<Caregiver> getAllCaregivers() {
        return new LinkedList<>();
    }
    
    public void updateCaregiver() {
    }

    public void removeCaregiver() {
    }
    
    public void associatePatient() {
    }
    
    public void addProcedure() {
    }
    
    public void associateMaterial() {
    }
}
