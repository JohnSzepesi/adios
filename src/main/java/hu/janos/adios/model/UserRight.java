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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felhasználó
 */
@Entity
@Table(name = "user_right")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRight.findAll", query = "SELECT u FROM UserRight u")
    , @NamedQuery(name = "UserRight.findByUserrightId", query = "SELECT u FROM UserRight u WHERE u.userrightId = :userrightId")
    , @NamedQuery(name = "UserRight.findByUserRightName", query = "SELECT u FROM UserRight u WHERE u.userRightName = :userRightName")})
public class UserRight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userright_id")
    private Integer userrightId;
    @Size(max = 40)
    @Column(name = "user_right_name")
    private String userRightName;
    @OneToMany(mappedBy = "userrightId")
    private Collection<User> userCollection;

    public UserRight() {
    }

    public UserRight(Integer userrightId) {
        this.userrightId = userrightId;
    }

    public Integer getUserrightId() {
        return userrightId;
    }

    public void setUserrightId(Integer userrightId) {
        this.userrightId = userrightId;
    }

    public String getUserRightName() {
        return userRightName;
    }

    public void setUserRightName(String userRightName) {
        this.userRightName = userRightName;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userrightId != null ? userrightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRight)) {
            return false;
        }
        UserRight other = (UserRight) object;
        if ((this.userrightId == null && other.userrightId != null) || (this.userrightId != null && !this.userrightId.equals(other.userrightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.UserRight[ userrightId=" + userrightId + " ]";
    }
    
}
