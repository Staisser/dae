/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "CLASSIFICATIONS",
uniqueConstraints =
@UniqueConstraint(columnNames = {"ID"}))
public class Classification implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "CAREGIVER_CLASSIFICATION_ID")
    private Caregiver caregiver;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "TOOL_CLASSIFICATION_ID")
    private EvaluationTools evaluationTool;
    
    @NotNull
    private int value;

    //TODO: Por automatico pela Base de Dados
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

    public Classification(Caregiver caregiver, EvaluationTools evaluationTool, int value) {
        this.caregiver = caregiver;
        this.evaluationTool = evaluationTool;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EvaluationTools getEvaluationTool() {
        return evaluationTool;
    }

    public void setEvaluationTool(EvaluationTools evaluationTool) {
        this.evaluationTool = evaluationTool;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
