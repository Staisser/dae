/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Resources;
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
public class ResourcesBean {

    @PersistenceContext
    private EntityManager em;

    public void createResource()  {
    }
    
    public List<Resources> getAllResources() {
        return new LinkedList<>();
    }
    
    public void updateResource() {
    }

    public void removeResource() {
    }
}
