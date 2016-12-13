/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Joao_Pinto
 */
@Entity
public class Metrics implements Serializable {

    @Id
    private int id;
    
    private int numberOfClicks;
    
    private int numberOfPatients;
    
    //in seconds or minutes
    private int numberOfLoggedTime;

    public Metrics(int numberOfClicks, int numberOfPatients, int numberOfLoggedTime) {
        this.numberOfClicks = numberOfClicks;
        this.numberOfPatients = numberOfPatients;
        this.numberOfLoggedTime = numberOfLoggedTime;
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
    
    
    
}
