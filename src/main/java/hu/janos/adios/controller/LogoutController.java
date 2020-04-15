package hu.janos.adios.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("logoutController")
@SessionScoped
public class LogoutController implements Serializable{

    private static final long serialVersionUID = -5151634499405308898L;
    
    public String logout(){

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "/login";
    }
}