/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Joao_Pinto
 */
@Singleton
@Startup
public class ConfigBean {

    @EJB
    private AdministratorBean administratorBean;
    @EJB
    private HealthcareProviderBean healthcareProviderBean;
    @EJB
    private CaregiverBean caregiverBean;
    @EJB
    private PatientBean patientBean;
    @EJB
    private NeedsBean needsBean;
    @EJB
    private MaterialsBean materialsBean;
    
    @PostConstruct
    public void populateBD() {
        try {
           /* 
            administratorBean.createAdministrator("joao123", "123", "Joao Pinto", "joao@gmail.pt");
            administratorBean.createAdministrator("hugo123", "123", "Hugo Borga", "hugo@gmail.pt");
            
            
            healthcareProviderBean.createHealthcareProvider("andre123", "456", "Andre Santos", "andre@gmail.com");
            healthcareProviderBean.createHealthcareProvider("jose123", "456", "Jose Ramiro", "joana@gmail.com");
            healthcareProviderBean.createHealthcareProvider("ruben23", "456", "Ruben Pereira", "ruben@gmail.com");
        */
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
