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

/**
 *
 * @author Joao_Pinto
 */
@Entity
public class Needs implements Serializable {
    
    @Id
    private int id;
    
    private String problem;
    
    private String priority;
    
    private Date date;
    
    public Needs(String problem, String priority, Date date) {
        this.problem = problem;
        this.priority = priority;
        this.date = date;
    }
    
    
    
    /*
    @Id
    private LinkedList<Materials> materials;
    
    public Needs() {
        this.materials = new LinkedList<>();
    }

    public LinkedList<Materials> getMaterials() {
        return materials;
    }

    public void setMaterials(LinkedList<Materials> materials) {
        this.materials = materials;
    }
*/

    public Needs() {
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
    
    
    
}
