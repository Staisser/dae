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

/**
 *
 * @author Joao_Pinto
 */
@Entity
public class Resources implements Serializable {

    @Id
    private int id;
    
    private String name;
    
    //PODE SER ENUM [ VIDEO, TEXT, ETC ]
    private String type;

    public Resources(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Resources() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
