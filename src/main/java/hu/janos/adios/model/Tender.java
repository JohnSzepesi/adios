/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.janos.adios.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felhasználó
 */
@Entity
@Table(name = "tender")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tender.findAll", query = "SELECT t FROM Tender t")
    , @NamedQuery(name = "Tender.findByTenderId", query = "SELECT t FROM Tender t WHERE t.tenderId = :tenderId")
    , @NamedQuery(name = "Tender.findByTenderName", query = "SELECT t FROM Tender t WHERE t.tenderName = :tenderName")
    , @NamedQuery(name = "Tender.findByTenderShortname", query = "SELECT t FROM Tender t WHERE t.tenderShortname = :tenderShortname")
    , @NamedQuery(name = "Tender.findByTenderWebpage", query = "SELECT t FROM Tender t WHERE t.tenderWebpage = :tenderWebpage")
    , @NamedQuery(name = "Tender.findByNotificationDeadline", query = "SELECT t FROM Tender t WHERE t.notificationDeadline = :notificationDeadline")
    , @NamedQuery(name = "Tender.findByFinancialDeadline", query = "SELECT t FROM Tender t WHERE t.financialDeadline = :financialDeadline")
    , @NamedQuery(name = "Tender.findByFacultyDeadline", query = "SELECT t FROM Tender t WHERE t.facultyDeadline = :facultyDeadline")
    , @NamedQuery(name = "Tender.findByTenderCenterDeadline", query = "SELECT t FROM Tender t WHERE t.tenderCenterDeadline = :tenderCenterDeadline")
    , @NamedQuery(name = "Tender.findBySubmissionDeadline", query = "SELECT t FROM Tender t WHERE t.submissionDeadline = :submissionDeadline")})
public class Tender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tender_id")
    private Integer tenderId;
    @Size(max = 200)
    @Column(name = "tender_name")
    private String tenderName;
    @Size(max = 30)
    @Column(name = "tender_shortname")
    private String tenderShortname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "tender_webpage")
    private String tenderWebpage;
    @Column(name = "notification_deadline")
    @Temporal(TemporalType.DATE)
    private Date notificationDeadline;
    @Column(name = "financial_deadline")
    @Temporal(TemporalType.DATE)
    private Date financialDeadline;
    @Column(name = "faculty_deadline")
    @Temporal(TemporalType.DATE)
    private Date facultyDeadline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tender_center_deadline")
    @Temporal(TemporalType.DATE)
    private Date tenderCenterDeadline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "submission_deadline")
    @Temporal(TemporalType.DATE)
    private Date submissionDeadline;
    @JoinColumn(name = "funder_id", referencedColumnName = "funder_id")
    @ManyToOne
    private Funder funderId;
    @OneToMany(mappedBy = "tenderId")
    private Collection<Projects> projectsCollection;

    public Tender() {
    }

    public Tender(Integer tenderId) {
        this.tenderId = tenderId;
    }

    public Tender(Integer tenderId, String tenderWebpage, Date tenderCenterDeadline, Date submissionDeadline) {
        this.tenderId = tenderId;
        this.tenderWebpage = tenderWebpage;
        this.tenderCenterDeadline = tenderCenterDeadline;
        this.submissionDeadline = submissionDeadline;
    }

    public Integer getTenderId() {
        return tenderId;
    }

    public void setTenderId(Integer tenderId) {
        this.tenderId = tenderId;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTenderShortname() {
        return tenderShortname;
    }

    public void setTenderShortname(String tenderShortname) {
        this.tenderShortname = tenderShortname;
    }

    public String getTenderWebpage() {
        return tenderWebpage;
    }

    public void setTenderWebpage(String tenderWebpage) {
        this.tenderWebpage = tenderWebpage;
    }

    public Date getNotificationDeadline() {
        return notificationDeadline;
    }

    public void setNotificationDeadline(Date notificationDeadline) {
        this.notificationDeadline = notificationDeadline;
    }

    public Date getFinancialDeadline() {
        return financialDeadline;
    }

    public void setFinancialDeadline(Date financialDeadline) {
        this.financialDeadline = financialDeadline;
    }

    public Date getFacultyDeadline() {
        return facultyDeadline;
    }

    public void setFacultyDeadline(Date facultyDeadline) {
        this.facultyDeadline = facultyDeadline;
    }

    public Date getTenderCenterDeadline() {
        return tenderCenterDeadline;
    }

    public void setTenderCenterDeadline(Date tenderCenterDeadline) {
        this.tenderCenterDeadline = tenderCenterDeadline;
    }

    public Date getSubmissionDeadline() {
        return submissionDeadline;
    }

    public void setSubmissionDeadline(Date submissionDeadline) {
        this.submissionDeadline = submissionDeadline;
    }

    public Funder getFunderId() {
        return funderId;
    }

    public void setFunderId(Funder funderId) {
        this.funderId = funderId;
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
        hash += (tenderId != null ? tenderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tender)) {
            return false;
        }
        Tender other = (Tender) object;
        if ((this.tenderId == null && other.tenderId != null) || (this.tenderId != null && !this.tenderId.equals(other.tenderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.Tender[ tenderId=" + tenderId + " ]";
    }
    
}
