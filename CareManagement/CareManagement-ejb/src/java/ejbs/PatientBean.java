/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Patient;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author André Nunes
 */
@Stateless
@LocalBean
public class PatientBean {

    @PersistenceContext
    private EntityManager em;

    public void createPatient()  {
    }
    
    public List<Patient> getAllPatients() {
        return new LinkedList<>();
    }
    
    public void updatePatient() {
    }

    public void removePatient() {
    }
    
    public void addNeed() {
    }
}
