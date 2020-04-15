package hu.janos.adios.controller;

import hu.janos.adios.model.FinancialCoordinator;
import hu.janos.adios.controller.util.JsfUtil;
import hu.janos.adios.controller.util.JsfUtil.PersistAction;
import hu.janos.adios.ejb.FinancialCoordinatorFacade;

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

@Named("financialCoordinatorController")
@SessionScoped
public class FinancialCoordinatorController implements Serializable {

    @EJB
    private hu.janos.adios.ejb.FinancialCoordinatorFacade ejbFacade;
    private List<FinancialCoordinator> items = null;
    private FinancialCoordinator selected;

    public FinancialCoordinatorController() {
    }

    public FinancialCoordinator getSelected() {
        return selected;
    }

    public void setSelected(FinancialCoordinator selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FinancialCoordinatorFacade getFacade() {
        return ejbFacade;
    }

    public FinancialCoordinator prepareCreate() {
        selected = new FinancialCoordinator();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FinancialCoordinatorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FinancialCoordinatorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FinancialCoordinatorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<FinancialCoordinator> getItems() {
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

    public FinancialCoordinator getFinancialCoordinator(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<FinancialCoordinator> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<FinancialCoordinator> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = FinancialCoordinator.class)
    public static class FinancialCoordinatorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FinancialCoordinatorController controller = (FinancialCoordinatorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "financialCoordinatorController");
            return controller.getFinancialCoordinator(getKey(value));
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
            if (object instanceof FinancialCoordinator) {
                FinancialCoordinator o = (FinancialCoordinator) object;
                return getStringKey(o.getFinancialcoordinatorId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FinancialCoordinator.class.getName()});
                return null;
            }
        }

    }

}
