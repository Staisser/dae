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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllPatients",
    query = "SELECT a FROM Patient a ORDER BY a.username")})
public class Patient extends User {

    private LinkedList<Needs> needs;
    
    public Patient() {
        super();
        this.needs = new LinkedList<>();
    }
    
    public Patient(String username, String name, String email) {
        super(username, name, email);
        this.needs = new LinkedList<Needs>();
        
    }

    public LinkedList<Needs> getNeeds() {
        return needs;
    }

    public void setNeeds(LinkedList<Needs> needs) {
        this.needs = needs;
    }
    
    public void addNeed(Needs n){
        this.needs.add(n);
    }
    
    public void removeNeed(Needs n){
        this.needs.remove(n);
    }

    
}
