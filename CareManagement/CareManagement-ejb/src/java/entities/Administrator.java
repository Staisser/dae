/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Joao_Pinto
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllAdministrators",
    query = "SELECT a FROM Administrator a ORDER BY a.username")})
public class Administrator extends UserAuthentication implements Serializable {  

    protected Administrator() {
        super();
    }

    public Administrator(String username, String password, String name, String email) {
        super(username, password, name, email);
    }
}
