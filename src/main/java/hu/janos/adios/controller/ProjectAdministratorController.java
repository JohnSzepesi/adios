package hu.janos.adios.controller;

import hu.janos.adios.model.ProjectAdministrator;
import hu.janos.adios.controller.util.JsfUtil;
import hu.janos.adios.controller.util.JsfUtil.PersistAction;
import hu.janos.adios.ejb.ProjectAdministratorFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("projectAdministratorController")
@SessionScoped
public class ProjectAdministratorController implements Serializable {

    @EJB
    private hu.janos.adios.ejb.ProjectAdministratorFacade ejbFacade;
    private List<ProjectAdministrator> items = null;
    private ProjectAdministrator selected;

    public ProjectAdministratorController() {
    }

    public ProjectAdministrator getSelected() {
        return selected;
    }

    public void setSelected(ProjectAdministrator selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProjectAdministratorFacade getFacade() {
        return ejbFacade;
    }

    public ProjectAdministrator prepareCreate() {
        selected = new ProjectAdministrator();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProjectAdministratorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProjectAdministratorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProjectAdministratorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProjectAdministrator> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ProjectAdministrator getProjectAdministrator(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ProjectAdministrator> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProjectAdministrator> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProjectAdministrator.class)
    public static class ProjectAdministratorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProjectAdministratorController controller = (ProjectAdministratorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "projectAdministratorController");
            return controller.getProjectAdministrator(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProjectAdministrator) {
                ProjectAdministrator o = (ProjectAdministrator) object;
                return getStringKey(o.getProjectadministratorId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProjectAdministrator.class.getName()});
                return null;
            }
        }

    }

}
