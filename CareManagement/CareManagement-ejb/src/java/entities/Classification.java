/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Joao_Pinto
 */
@Entity
public class Classification implements Serializable {
    
    @Id
    private int id;
    
    private Caregiver caregiver;
    
    private HealthcareProvider healthcareProvider;
    
    private int value;

    public Classification(Caregiver caregiver, HealthcareProvider healthcareProvider, int value) {
        this.caregiver = caregiver;
        this.healthcareProvider = healthcareProvider;
        this.value = value;
    }

    public Classification() {
        
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public HealthcareProvider getHealthcareProvider() {
        return healthcareProvider;
    }

    public void setHealthcareProvider(HealthcareProvider healthcareProvider) {
        this.healthcareProvider = healthcareProvider;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    
    
}
