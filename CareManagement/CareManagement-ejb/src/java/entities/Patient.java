/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllPatients",
            query = "SELECT a FROM Patient a ORDER BY a.username")})
public class Patient extends User {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CAREGIVER_ID")
    private Caregiver caregiver;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "HEALTHCAREPROVIDER_PATIENT_ID")
    private HealthcareProvider healthcareProvider;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    private LinkedList<Needs> needs;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    private LinkedList<MaterialApplication> materialApplications;

    public Patient() {
        super();
        this.needs = new LinkedList<>();
    }

    public Patient(String username, UserGroup.GROUP group, String name, String email, HealthcareProvider hcp, Caregiver caregiver) {
        super(username, group, name, email);
        this.needs = new LinkedList<>();
        this.materialApplications = new LinkedList<>();
        this.healthcareProvider = hcp;
        this.caregiver = caregiver;
    }

    public LinkedList<Needs> getNeeds() {
        return needs;
    }

    public void setNeeds(LinkedList<Needs> needs) {
        this.needs = needs;
    }

    public void addNeed(Needs n) {
        this.needs.add(n);
    }

    public void removeNeed(Needs n) {
        this.needs.remove(n);
    }

    public void addMaterialApplication(MaterialApplication m) {
        this.materialApplications.add(m);
    }

    public void removeMaterialApplication(MaterialApplication m) {
        this.materialApplications.remove(m);
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

    
}
