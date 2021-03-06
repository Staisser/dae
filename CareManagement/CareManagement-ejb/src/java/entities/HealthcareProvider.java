/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllHealthcareProviders",
    query = "SELECT m FROM HealthcareProvider m ORDER BY m.username")})

public class HealthcareProvider extends UserAuthentication implements Serializable {
    
    @OneToMany(mappedBy = "healthcareProvider", cascade = CascadeType.REMOVE)
    private LinkedList<Patient> patients;
    
    @OneToMany(mappedBy = "healthcareProvider", cascade = CascadeType.REMOVE)
    private LinkedList<Caregiver> caregivers;
    /*
    @OneToMany(mappedBy = "healthcareProvider", cascade = CascadeType.REMOVE)
    private LinkedList<Materials> materials;*/
    
    protected HealthcareProvider(){
        super();
        this.patients =  new LinkedList<>();
        this.caregivers =  new LinkedList<>();
        //this.materials =  new LinkedList<>();
    }

    public HealthcareProvider(String username, String password, String name, String email) {
        super(username, UserGroup.GROUP.HealthProvider, password, name, email);
        this.patients =  new LinkedList<>();
        this.caregivers =  new LinkedList<>();
        //this.materials =  new LinkedList<>();
    }
    /*
    public void addMaterial(Materials m){
        this.materials.add(m);
    }
    
    public void removeMaterial(Materials m){
        this.materials.remove(m);
    }*/
    
    public void addPatient(Patient p){
        this.patients.add(p);
    }
    
    public void removePatient(Patient p){
        this.patients.remove(p);
    }
    
    public void addCaregiver(Caregiver c){
        this.caregivers.add(c);
    }
    
    public void removeCaregiver(Caregiver c){
        this.caregivers.remove(c);
    }
    
}
