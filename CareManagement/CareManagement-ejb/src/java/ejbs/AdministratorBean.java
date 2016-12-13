/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Administrator;
import entities.User;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Joao_Pinto
 */
@Stateless
public class AdministratorBean {
    
    @PersistenceContext
    private EntityManager em;

    public void createAdministrator(String username,
            String password,
            String name,
            String email)  {

        try {
            User findAdministrator = em.find(User.class, username);
            if (findAdministrator != null) {
                //aqui temos de criar o tratamento das exceçoes
                return;
            }
            Administrator newAdministrator = new Administrator(username, password, name, email);
            em.persist(newAdministrator);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public List<Administrator> getAllAdministrators() {
        
        try {
            List<Administrator> administrators = em.createNamedQuery("getAllAdministrators").getResultList();
            return administrators;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
          
    }
    
    public void updateAdministrator(String username, String password, String name, String email) {
        try {
            Administrator administrator = em.find(Administrator.class, username);
            if (administrator == null) {
                return;
            }
            if (password != null && !administrator.getPassword().equals(password)) {
                administrator.setPassword(password);
            }
            administrator.setName(name);
            administrator.setEmail(email);
            em.merge(administrator);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public void removeAdministrator(String username) {
        try {
            Administrator administrator = em.find(Administrator.class, username);
            if (administrator == null) {
                return;
            }
            em.remove(administrator);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }

    }
}
