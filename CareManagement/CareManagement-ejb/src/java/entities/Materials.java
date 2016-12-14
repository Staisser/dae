/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@Table(name = "MATERIALS",
uniqueConstraints =
@UniqueConstraint(columnNames = {"ID"}))
public class Materials implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "CAREGIVER_MATERIALS_ID")
    private Caregiver caregiver;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "HEALTHCAREPROVIDER_MATERIALS_ID")
    private HealthcareProvider healthcareProvider;
    
    @ManyToMany
    @JoinTable(name = "MATERIALS_NEEDS",
            joinColumns
            = @JoinColumn(name = "MATERIALS_ID", referencedColumnName = "ID"),
            inverseJoinColumns
            = @JoinColumn(name = "NEEDS_ID", referencedColumnName = "ID"))
    private List<Needs> needs;
    
    private String link;
    
    private byte[] bytes;
    
    public Materials(HealthcareProvider healthcareProvider, Caregiver caregiver, String link) {
        this.healthcareProvider = healthcareProvider;
        this.caregiver = caregiver;
        this.link = link;
        this.needs = new LinkedList<>();
    }
    
    public Materials(HealthcareProvider healthcareProvider, String link) {
        this.healthcareProvider = healthcareProvider;
        this.link = link;
        this.needs = new LinkedList<>();
    }
    
    public Materials(HealthcareProvider healthcareProvider, Caregiver caregiver, byte[] bytes) {
        this.healthcareProvider = healthcareProvider;
        this.caregiver = caregiver;
        this.bytes = bytes;
        this.needs = new LinkedList<>();
    }
    
    public Materials(HealthcareProvider healthcareProvider, byte[] bytes) {
        this.healthcareProvider = healthcareProvider;
        this.bytes = bytes;
        this.needs = new LinkedList<>();
    }

    public Materials() {
        this.needs = new LinkedList<>();
    }

    public HealthcareProvider getHealthcareProvider() {
        return healthcareProvider;
    }

    public void setHealthcareProvider(HealthcareProvider healthcareProvider) {
        this.healthcareProvider = healthcareProvider;
    }
    

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    public void addNeed(Needs n){
        this.needs.add(n);
    }
    
    public void removeNeed(Needs n){
        this.needs.remove(n);
    }

    public List<Needs> getNeeds() {
        return needs;
    }

    public void setNeeds(List<Needs> needs) {
        this.needs = needs;
    }
    
}
