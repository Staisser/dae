/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@Table(name = "MATERIALS_APPLICATION",
uniqueConstraints =
@UniqueConstraint(columnNames = {"ID"}))
public class MaterialApplication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "PATIENT_MATERIALAPP_ID")
    private Patient patient;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "CAREGIVER_MATERIALAPP_ID")
    private Caregiver caregiver;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "MATERIALS_MATERIALAPP_ID")
    private Materials material;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "NEEDS_MATERIALAPP_ID")
    private Needs need;
    
    //TODO: Por automatico pela Base de Dados
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materials getMaterial() {
        return material;
    }

    public void setMaterial(Materials material) {
        this.material = material;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
