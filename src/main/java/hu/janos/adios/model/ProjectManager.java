/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.janos.adios.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felhasználó
 */
@Entity
@Table(name = "project_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectManager.findAll", query = "SELECT p FROM ProjectManager p")
    , @NamedQuery(name = "ProjectManager.findByProjectmanagerId", query = "SELECT p FROM ProjectManager p WHERE p.projectmanagerId = :projectmanagerId")
    , @NamedQuery(name = "ProjectManager.findByFullNamePromanag", query = "SELECT p FROM ProjectManager p WHERE p.fullNamePromanag = :fullNamePromanag")
    , @NamedQuery(name = "ProjectManager.findByMobile", query = "SELECT p FROM ProjectManager p WHERE p.mobile = :mobile")
    , @NamedQuery(name = "ProjectManager.findByEmail", query = "SELECT p FROM ProjectManager p WHERE p.email = :email")})
public class ProjectManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projectmanager_id")
    private Integer projectmanagerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "full_name_promanag")
    private String fullNamePromanag;
    @Size(max = 20)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "projectmanagerId")
    private Collection<Projects> projectsCollection;

    public ProjectManager() {
    }

    public ProjectManager(Integer projectmanagerId) {
        this.projectmanagerId = projectmanagerId;
    }

    public ProjectManager(Integer projectmanagerId, String fullNamePromanag, String email) {
        this.projectmanagerId = projectmanagerId;
        this.fullNamePromanag = fullNamePromanag;
        this.email = email;
    }

    public Integer getProjectmanagerId() {
        return projectmanagerId;
    }

    public void setProjectmanagerId(Integer projectmanagerId) {
        this.projectmanagerId = projectmanagerId;
    }

    public String getFullNamePromanag() {
        return fullNamePromanag;
    }

    public void setFullNamePromanag(String fullNamePromanag) {
        this.fullNamePromanag = fullNamePromanag;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Projects> getProjectsCollection() {
        return projectsCollection;
    }

    public void setProjectsCollection(Collection<Projects> projectsCollection) {
        this.projectsCollection = projectsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectmanagerId != null ? projectmanagerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectManager)) {
            return false;
        }
        ProjectManager other = (ProjectManager) object;
        if ((this.projectmanagerId == null && other.projectmanagerId != null) || (this.projectmanagerId != null && !this.projectmanagerId.equals(other.projectmanagerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.ProjectManager[ projectmanagerId=" + projectmanagerId + " ]";
    }
    
}
