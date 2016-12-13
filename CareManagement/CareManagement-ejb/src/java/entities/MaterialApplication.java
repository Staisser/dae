/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Joao_Pinto
 */
@Entity
public class MaterialApplication implements Serializable {

    @Id
    private int id;
    
    private Patient patient;
    
    private Caregiver caregiver;
    
    private Materials material;
    
    private Needs need;

    public MaterialApplication(Patient patient, Caregiver caregiver, Materials material, Needs need) {
        this.patient = patient;
        this.caregiver = caregiver;
        this.material = material;
        this.need = need;
    }

    public MaterialApplication() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public Needs getNeed() {
        return need;
    }

    public void setNeed(Needs need) {
        this.need = need;
    }
    
    
}
