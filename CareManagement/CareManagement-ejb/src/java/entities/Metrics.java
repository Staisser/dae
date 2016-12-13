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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@Table(name = "METRICS",
uniqueConstraints =
@UniqueConstraint(columnNames = {"ID"}))
public class Metrics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int numberOfClicks;
    
    private int numberOfPatients;
    
    //in seconds or minutes
    private int numberOfLoggedTime;
    
    @OneToOne
    @JoinColumn(name = "CAREGIVER_ID")
    @NotNull (message="A Metric needs to be associated to a Caregiver")
    private Caregiver caregiver;

    public Metrics(int numberOfClicks, int numberOfPatients, int numberOfLoggedTime, Caregiver caregiver) {
        this.numberOfClicks = numberOfClicks;
        this.numberOfPatients = numberOfPatients;
        this.numberOfLoggedTime = numberOfLoggedTime;
        this.caregiver = caregiver;
    }

    public Metrics() {
    }

    public int getNumberOfClicks() {
        return numberOfClicks;
    }

    public void setNumberOfClicks(int numberOfClicks) {
        this.numberOfClicks = numberOfClicks;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    public int getNumberOfLoggedTime() {
        return numberOfLoggedTime;
    }

    public void setNumberOfLoggedTime(int numberOfLoggedTime) {
        this.numberOfLoggedTime = numberOfLoggedTime;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
