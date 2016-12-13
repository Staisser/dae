/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Materials;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author André Nunes
 */
@Stateless
@LocalBean
public class MaterialsBean {

    @PersistenceContext
    private EntityManager em;

    public void createMaterial()  {
    }
    
    public List<Materials> getAllMaterials() {
        return new LinkedList<>();
    }
    
    public void updateMaterial() {
    }

    public void removeMaterial() {
    }
}
