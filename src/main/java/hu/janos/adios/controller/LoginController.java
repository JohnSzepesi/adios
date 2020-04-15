package hu.janos.adios.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import hu.janos.adios.model.User;

@Named("loginController")
@SessionScoped
public class LoginController implements Serializable{

    private static final long serialVersionUID = -6983839857205389929L;
    
    @EJB
    private hu.janos.adios.ejb.ILoginManager loginManager;
    
    @EJB
    private hu.janos.adios.ejb.UserFacade userFacade;
    
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String validateUserNamePassword(){
        
        boolean auth = loginManager.authenticate(userName, password);
        
        if(auth){
            if(userName != null && userName.length()!=0){
                User user = userFacade.getUserByName(userName);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("user", user);
            }
            return "/faces/open.xhtml";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Hibás felhasználó jelszó pár",
            "Helyes adatokat adjon meg"));
            
            return "/login";
        }
    
    }
}