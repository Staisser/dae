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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllCaregivers",
    query = "SELECT m FROM Caregiver m ORDER BY m.username")})
public class Caregiver extends UserAuthentication implements Serializable {
   
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private LinkedList<Patient> patients;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private LinkedList<MaterialApplication> procedures;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private LinkedList<Materials> materials;
    
    public Caregiver(){
        this.patients = new LinkedList<>();     
        this.procedures = new LinkedList<>();
        this.materials = new LinkedList<>();
    }
    
    public Caregiver(String username, String password, String name, String email) {
        super(username, password, name, email);
        this.patients = new LinkedList<>();
        this.procedures = new LinkedList<>();
        this.materials = new LinkedList<>();
    }

    public LinkedList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(LinkedList<Patient> patients) {
        this.patients = patients;
    }

    public LinkedList<MaterialApplication> getProcedures() {
        return procedures;
    }

    public void setProcedures(LinkedList<MaterialApplication> procedures) {
        this.procedures = procedures;
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
    
    public void addProcedure(MaterialApplication p){
        this.procedures.add(p);
    }
    
    public void removeProcedure(MaterialApplication p){
        this.procedures.remove(p);
    }
    
    public void addPatient(Patient p){
        this.patients.add(p);
    }
    
    public void removePatient(Patient p){
        this.patients.remove(p);
    }
}
