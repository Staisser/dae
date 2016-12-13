/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import ejbs.AdministratorBean;
import ejbs.HealthcareProviderBean;
import entities.Administrator;
import entities.HealthcareProvider;
import entities.User;
import entities.UserAuthentication;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author Joao Pinto
 */
@ManagedBean
@Named(value = "administratorManager")
@SessionScoped
public class UserAuthManager implements Serializable {
    
    private UIComponent component;
    
    private UserAuthentication currentUser;

    private static final Logger LOGGER = Logger.getLogger("web.AdministratorManager");
    
    @EJB
    private AdministratorBean administratorBean;
    @EJB
    private HealthcareProviderBean healthcareProviderBean;
    
    private String newAdministratorUsername;
    private String newAdministratorPassword;
    private String newAdministratorName;
    private String newAdministratorEmail;
    
    
    private String newHealthcareProviderUsername;
    private String newHealthcareProviderPassword;
    private String newHealthcareProviderName;
    private String newHealthcareProviderEmail;
    
    /**
     * Creates a new instance of AdministratorManager
     */
    public UserAuthManager() {
        
    }
    
    /*retorna a pagina para a qual se pretende ir*/
    public String createAdministrator(){
        
        try {
                       
            //mais tarde fazer um find antes de tentar add um user que existe   
            
            administratorBean.createAdministrator(newAdministratorUsername, newAdministratorPassword, newAdministratorName, newAdministratorEmail);
            clearNewAdministrator();
            
            //por default fica na mesma pagina por isso mudamos para dar feedback ao user que correu bem
            //return "index?faces-redirect=true";//informação para o controlador
            return "manage_administrator?faces-redirect=true";//informação para o controlador

            
        } catch (Exception e) {
            LOGGER.warning("Problem creating administrator in method createAdministrator");
            
        }
        return null;
    }  
    
        public String createHealhtcareProvider(){
        
        try {
                       
            //mais tarde fazer um find antes de tentar add um user que existe   
            
            //healthcareProviderBean.createHealthcareProvider(newHealthcareProviderUsername, newHealthcareProviderPassword, newHealthcareProviderName, newHealthcareProviderEmail);
            clearNewHealthcareProvider();
            
            //por default fica na mesma pagina por isso mudamos para dar feedback ao user que correu bem
            return "manage_healthcare_provider?faces-redirect=true";
            
        } catch (Exception e) {
            LOGGER.warning("Problem creating HealtcareProvider in method createHealhtcareProvider");
        }
        return null;
    }  
        
    public List<Administrator> getAllAdministrators() {
        try {
            //return administratorBean.getAll();
        } catch (Exception e) {
            LOGGER.warning("Problem creating administrator in method getAllAdministrators");
        }
        
        return null;
    }
    
    public List<HealthcareProvider> getAllHeatlcareProviders() {
        try {
            //return healthcareProviderBean.getAll();
        } catch (Exception e) {
            LOGGER.warning("Problem creating healthcareProviders in method getAllHeatlcareProviders");
        }
        
        return null;
    }
    
    private void clearNewAdministrator() {
        setNewAdministratorUsername(null);
        setNewAdministratorPassword(null);
        setNewAdministratorName(null);
        setNewAdministratorEmail(null);  
    }
    
    private void clearNewHealthcareProvider() {
        setNewHealthcareProviderUsername(null);
        setNewHealthcareProviderPassword(null);
        setNewHealthcareProviderName(null);
        setNewHealthcareProviderEmail(null);  
    }
    
    public void removeAdministrator(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteAdministratorId");
            String username = param.getValue().toString();
            //administratorBean.remove(username);
        } catch (Exception e) {
            LOGGER.warning("Problem removing student in method removeAdministrator");
        }
    }

    public void removeHealthcareProvider(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteHealthcareProviderId");
            String username = param.getValue().toString();
            //healthcareProviderBean.remove(username);
        } catch (Exception e) {
            LOGGER.warning("Problem removing student in method removeHealthcareProvider");
        }
    }
    
    public String updateAdministrator(){
        
        try {
            //mais tarde fazer um find antes de tentar add um user que existe
           /* administratorBean.update(
                    currentUser.getUsername(),
                    currentUser.getPassword(), 
                    currentUser.getName(), 
                    currentUser.getEmail());*/
            //clearNewStudent(); servia para limpar os dados quando se volta à pagina
            
            //por default fica na mesma pagina por isso mudamos para dar feedback ao user que correu bem
            return "manage_administrator?faces-redirect=true";//informação para o controlador
            
        } catch (Exception e) {
            LOGGER.warning("Problem updating student in method updateAdministrator");
            //return "admin_students_update?faces-redirect=true";
            //return FacesContext.getCurrentInstance();
        }
        return null;
    } 
    
        public String updateHealthcareProvider(){
        
        try {
            //mais tarde fazer um find antes de tentar add um user que existe
          /*  healthcareProviderBean.update(
                    currentUser.getUsername(),
                    currentUser.getPassword(), 
                    currentUser.getName(), 
                    currentUser.getEmail());*/
            //clearNewStudent(); servia para limpar os dados quando se volta à pagina
            
            //por default fica na mesma pagina por isso mudamos para dar feedback ao user que correu bem
            return "manage_healthcare_provider?faces-redirect=true";
            
        } catch (Exception e) {
            LOGGER.warning("Problem updating student in method updateStudent");
            //return FacesContext.getCurrentInstance();
        }
        return null;
    } 
        
    public String cancelAdministratorOperations() {
        clearNewAdministrator();
        return "manage_administrator?faces-redirect=true";
    }

    public String cancelHealthcareProviderOperations() {
        clearNewHealthcareProvider();
        return "manage_healthcare_provider?faces-redirect=true";
    }
    
    public void setNewAdministratorUsername(String newAdministratorUsername) {
        this.newAdministratorUsername = newAdministratorUsername;
    }

    public void setNewAdministratorPassword(String newAdministratorPassword) {
        this.newAdministratorPassword = newAdministratorPassword;
    }

    public void setNewAdministratorName(String newAdministratorName) {
        this.newAdministratorName = newAdministratorName;
    }

    public void setNewAdministratorEmail(String newAdministratorEmail) {
        this.newAdministratorEmail = newAdministratorEmail;
    }


    public String getNewAdministratorUsername() {
        return newAdministratorUsername;
    }

    public String getNewAdministratorPassword() {
        return newAdministratorPassword;
    }

    public String getNewAdministratorName() {
        return newAdministratorName;
    }

    public String getNewAdministratorEmail() {
        return newAdministratorEmail;
    }

    public String getNewHealthcareProviderUsername() {
        return newHealthcareProviderUsername;
    }

    public String getNewHealthcareProviderPassword() {
        return newHealthcareProviderPassword;
    }

    public String getNewHealthcareProviderName() {
        return newHealthcareProviderName;
    }

    public String getNewHealthcareProviderEmail() {
        return newHealthcareProviderEmail;
    }

    public void setNewHealthcareProviderUsername(String newHealthcareProviderUsername) {
        this.newHealthcareProviderUsername = newHealthcareProviderUsername;
    }

    public void setNewHealthcareProviderPassword(String newHealthcareProviderPassword) {
        this.newHealthcareProviderPassword = newHealthcareProviderPassword;
    }

    public void setNewHealthcareProviderName(String newHealthcareProviderName) {
        this.newHealthcareProviderName = newHealthcareProviderName;
    }

    public void setNewHealthcareProviderEmail(String newHealthcareProviderEmail) {
        this.newHealthcareProviderEmail = newHealthcareProviderEmail;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserAuthentication currentUser) {
        this.currentUser = currentUser;
    }
    
    
    
    
    
    
}
