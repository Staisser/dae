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
public class Materials implements Serializable {

    @Id
    
    private int id;
    
    private HealthcareProvider creator;
    
    private Caregiver caregiver;
    
    private Resources resource;

    public Materials(HealthcareProvider creator, Caregiver caregiver, Resources resouce) {
        this.creator = creator;
        this.caregiver = caregiver;
        this.resource = resource;
    }

    public Materials() {
    }

    public HealthcareProvider getCreator() {
        return creator;
    }

    public void setCreator(HealthcareProvider creator) {
        this.creator = creator;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public Resources getResource() {
        return resource;
    }

    public void setResource(Resources resource) {
        this.resource = resource;
    }
    
    
    
}
