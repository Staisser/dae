/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllHealthcareProviders",
    query = "SELECT m FROM HealthcareProvider m ORDER BY m.username")})

public class HealthcareProvider extends UserAuthentication implements Serializable {
    
    
    protected HealthcareProvider(){
        super();
    }
    
    public HealthcareProvider(String username, String password, String name, String email) {
        super(username, password, name, email);
        
    }
    
}
