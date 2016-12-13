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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllCaregivers",
    query = "SELECT m FROM Caregiver m ORDER BY m.username")})
public class Caregiver extends UserAuthentication implements Serializable {
   
    @OneToMany(mappedBy = "caregiver", cascade = CascadeType.REMOVE)
    private LinkedList<Patient> patients;
    
    @OneToMany(mappedBy = "caregiver", cascade = CascadeType.REMOVE)
    private LinkedList<MaterialApplication> materialApplication;
    
    @OneToMany(mappedBy = "caregiver", cascade = CascadeType.REMOVE)
    private LinkedList<Materials> materials;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "caregiver")
    private Metrics metric;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "HEALTHCAREPROVIDER_CAREGIVER_ID")
    private HealthcareProvider healthcareProvider;
    
    public Caregiver(){
        this.patients = new LinkedList<>();     
        this.materialApplication = new LinkedList<>();
        this.materials = new LinkedList<>();
    }
    
    public Caregiver(String username, String password, String name, String email, HealthcareProvider healthcareprovider) {
        super(username, UserGroup.GROUP.Caregiver, password, name, email);
        this.patients = new LinkedList<>();
        this.materialApplication = new LinkedList<>();
        this.materials = new LinkedList<>();
        this.healthcareProvider = healthcareprovider;
    }

    public LinkedList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(LinkedList<Patient> patients) {
        this.patients = patients;
    }

    public LinkedList<MaterialApplication> getMaterialApplication() {
        return materialApplication;
    }

    public void setMaterialApplication(LinkedList<MaterialApplication> materialApplication) {
        this.materialApplication = materialApplication;
    }

    public LinkedList<Materials> getMaterials() {
        return materials;
    }

    public void setMaterials(LinkedList<Materials> materials) {
        this.materials = materials;
    }
    
    public void addMaterial(Materials m){
        this.materials.add(m);
    }
    
    public void removeMaterial(Materials m){
        this.materials.remove(m);
    }
    
    public void addMaterialApplication(MaterialApplication p){
        this.materialApplication.add(p);
    }
    
    public void removeMaterialApplication(MaterialApplication p){
        this.materialApplication.remove(p);
    }
    
    public void addPatient(Patient p){
        this.patients.add(p);
    }
    
    public void removePatient(Patient p){
        this.patients.remove(p);
    }
}
