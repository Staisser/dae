/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "NEEDS",
uniqueConstraints =
@UniqueConstraint(columnNames = {"ID"}))
public class Needs implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String problem;
    
    @NotNull
    private String priority;
    
    //TODO: Por automatico pela Base de Dados
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;
    
    @ManyToMany(mappedBy = "needs")
    private List<Materials> materials;
    
    public Needs(String problem, String priority) {
        this.problem = problem;
        this.priority = priority;
        this.materials = new LinkedList<>();
    }

    public Needs() {
        this.materials = new LinkedList<>();
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public void addMaterial(Materials m){
        this.materials.add(m);
    }
    
    public void removeMaterial(Materials m){
        this.materials.remove(m);
    }

    public List<Materials> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Materials> materials) {
        this.materials = materials;
    }
    
    
}
