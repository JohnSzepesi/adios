/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.janos.adios.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felhasználó
 */
@Entity
@Table(name = "projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p")
    , @NamedQuery(name = "Projects.findByProjectsId", query = "SELECT p FROM Projects p WHERE p.projectsId = :projectsId")
    , @NamedQuery(name = "Projects.findByIdentificationNumber", query = "SELECT p FROM Projects p WHERE p.identificationNumber = :identificationNumber")
    , @NamedQuery(name = "Projects.findByTitle", query = "SELECT p FROM Projects p WHERE p.title = :title")
    , @NamedQuery(name = "Projects.findByAcronyme", query = "SELECT p FROM Projects p WHERE p.acronyme = :acronyme")
    , @NamedQuery(name = "Projects.findByStartDate", query = "SELECT p FROM Projects p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "Projects.findByEndDate", query = "SELECT p FROM Projects p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "Projects.findByJobNumber", query = "SELECT p FROM Projects p WHERE p.jobNumber = :jobNumber")
    , @NamedQuery(name = "Projects.findByRemittanceCode", query = "SELECT p FROM Projects p WHERE p.remittanceCode = :remittanceCode")
    , @NamedQuery(name = "Projects.findByDivision", query = "SELECT p FROM Projects p WHERE p.division = :division")
    , @NamedQuery(name = "Projects.findBySource", query = "SELECT p FROM Projects p WHERE p.source = :source")
    , @NamedQuery(name = "Projects.findByEperNumber", query = "SELECT p FROM Projects p WHERE p.eperNumber = :eperNumber")
    , @NamedQuery(name = "Projects.findByTotalAid", query = "SELECT p FROM Projects p WHERE p.totalAid = :totalAid")
    , @NamedQuery(name = "Projects.findByTotalCost", query = "SELECT p FROM Projects p WHERE p.totalCost = :totalCost")
    , @NamedQuery(name = "Projects.findByFirstwsStart", query = "SELECT p FROM Projects p WHERE p.firstwsStart = :firstwsStart")
    , @NamedQuery(name = "Projects.findByFirstwsEnd", query = "SELECT p FROM Projects p WHERE p.firstwsEnd = :firstwsEnd")
    , @NamedQuery(name = "Projects.findBySecondwsStart", query = "SELECT p FROM Projects p WHERE p.secondwsStart = :secondwsStart")
    , @NamedQuery(name = "Projects.findBySecondwsEnd", query = "SELECT p FROM Projects p WHERE p.secondwsEnd = :secondwsEnd")
    , @NamedQuery(name = "Projects.findByThirdwsStart", query = "SELECT p FROM Projects p WHERE p.thirdwsStart = :thirdwsStart")
    , @NamedQuery(name = "Projects.findByThirdwsEnd", query = "SELECT p FROM Projects p WHERE p.thirdwsEnd = :thirdwsEnd")
    , @NamedQuery(name = "Projects.findByFourthwsStart", query = "SELECT p FROM Projects p WHERE p.fourthwsStart = :fourthwsStart")
    , @NamedQuery(name = "Projects.findByFourthwsEnd", query = "SELECT p FROM Projects p WHERE p.fourthwsEnd = :fourthwsEnd")
    , @NamedQuery(name = "Projects.findByFifthwsStart", query = "SELECT p FROM Projects p WHERE p.fifthwsStart = :fifthwsStart")
    , @NamedQuery(name = "Projects.findByFifthwsEnd", query = "SELECT p FROM Projects p WHERE p.fifthwsEnd = :fifthwsEnd")
    , @NamedQuery(name = "Projects.findBySixthwsStart", query = "SELECT p FROM Projects p WHERE p.sixthwsStart = :sixthwsStart")
    , @NamedQuery(name = "Projects.findBySixthwsEnd", query = "SELECT p FROM Projects p WHERE p.sixthwsEnd = :sixthwsEnd")})
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projects_id")
    private Integer projectsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "identification_number")
    private String identificationNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "acronyme")
    private String acronyme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 45)
    @Column(name = "job_number")
    private String jobNumber;
    @Size(max = 45)
    @Column(name = "remittance_code")
    private String remittanceCode;
    @Size(max = 45)
    @Column(name = "division")
    private String division;
    @Size(max = 45)
    @Column(name = "source")
    private String source;
    @Size(max = 45)
    @Column(name = "eper_number")
    private String eperNumber;
    @Column(name = "total_aid")
    private Integer totalAid;
    @Column(name = "total_cost")
    private Integer totalCost;
    @Column(name = "firstws_start")
    @Temporal(TemporalType.DATE)
    private Date firstwsStart;
    @Column(name = "firstws_end")
    @Temporal(TemporalType.DATE)
    private Date firstwsEnd;
    @Column(name = "secondws_start")
    @Temporal(TemporalType.DATE)
    private Date secondwsStart;
    @Column(name = "secondws_end")
    @Temporal(TemporalType.DATE)
    private Date secondwsEnd;
    @Column(name = "thirdws_start")
    @Temporal(TemporalType.DATE)
    private Date thirdwsStart;
    @Column(name = "thirdws_end")
    @Temporal(TemporalType.DATE)
    private Date thirdwsEnd;
    @Column(name = "fourthws_start")
    @Temporal(TemporalType.DATE)
    private Date fourthwsStart;
    @Column(name = "fourthws_end")
    @Temporal(TemporalType.DATE)
    private Date fourthwsEnd;
    @Column(name = "fifthws_start")
    @Temporal(TemporalType.DATE)
    private Date fifthwsStart;
    @Column(name = "fifthws_end")
    @Temporal(TemporalType.DATE)
    private Date fifthwsEnd;
    @Column(name = "sixthws_start")
    @Temporal(TemporalType.DATE)
    private Date sixthwsStart;
    @Column(name = "sixthws_end")
    @Temporal(TemporalType.DATE)
    private Date sixthwsEnd;
    @JoinColumn(name = "funder_id", referencedColumnName = "funder_id")
    @ManyToOne
    private Funder funderId;
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    @ManyToOne
    private Unit unitId;
    @JoinColumn(name = "fundercontact_id", referencedColumnName = "fundercontact_id")
    @ManyToOne
    private FunderContact fundercontactId;
    @JoinColumn(name = "projectstatus_id", referencedColumnName = "projectstatus_id")
    @ManyToOne
    private ProjectStatus projectstatusId;
    @JoinColumn(name = "projectadministrator_id", referencedColumnName = "projectadministrator_id")
    @ManyToOne
    private ProjectAdministrator projectadministratorId;
    @JoinColumn(name = "financialcoordinator_id", referencedColumnName = "financialcoordinator_id")
    @ManyToOne
    private FinancialCoordinator financialcoordinatorId;
    @JoinColumn(name = "projectmanager_id", referencedColumnName = "projectmanager_id")
    @ManyToOne
    private ProjectManager projectmanagerId;
    @JoinColumn(name = "financialstatus_id", referencedColumnName = "financialstatus_id")
    @ManyToOne
    private FinancialStatus financialstatusId;
    @JoinColumn(name = "currency_id", referencedColumnName = "currency_id")
    @ManyToOne
    private Currency currencyId;
    @JoinColumn(name = "tender_id", referencedColumnName = "tender_id")
    @ManyToOne
    private Tender tenderId;

    public Projects() {
    }

    public Projects(Integer projectsId) {
        this.projectsId = projectsId;
    }

    public Projects(Integer projectsId, String identificationNumber, String title, Date startDate, Date endDate) {
        this.projectsId = projectsId;
        this.identificationNumber = identificationNumber;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(Integer projectsId) {
        this.projectsId = projectsId;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAcronyme() {
        return acronyme;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getRemittanceCode() {
        return remittanceCode;
    }

    public void setRemittanceCode(String remittanceCode) {
        this.remittanceCode = remittanceCode;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEperNumber() {
        return eperNumber;
    }

    public void setEperNumber(String eperNumber) {
        this.eperNumber = eperNumber;
    }

    public Integer getTotalAid() {
        return totalAid;
    }

    public void setTotalAid(Integer totalAid) {
        this.totalAid = totalAid;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Date getFirstwsStart() {
        return firstwsStart;
    }

    public void setFirstwsStart(Date firstwsStart) {
        this.firstwsStart = firstwsStart;
    }

    public Date getFirstwsEnd() {
        return firstwsEnd;
    }

    public void setFirstwsEnd(Date firstwsEnd) {
        this.firstwsEnd = firstwsEnd;
    }

    public Date getSecondwsStart() {
        return secondwsStart;
    }

    public void setSecondwsStart(Date secondwsStart) {
        this.secondwsStart = secondwsStart;
    }

    public Date getSecondwsEnd() {
        return secondwsEnd;
    }

    public void setSecondwsEnd(Date secondwsEnd) {
        this.secondwsEnd = secondwsEnd;
    }

    public Date getThirdwsStart() {
        return thirdwsStart;
    }

    public void setThirdwsStart(Date thirdwsStart) {
        this.thirdwsStart = thirdwsStart;
    }

    public Date getThirdwsEnd() {
        return thirdwsEnd;
    }

    public void setThirdwsEnd(Date thirdwsEnd) {
        this.thirdwsEnd = thirdwsEnd;
    }

    public Date getFourthwsStart() {
        return fourthwsStart;
    }

    public void setFourthwsStart(Date fourthwsStart) {
        this.fourthwsStart = fourthwsStart;
    }

    public Date getFourthwsEnd() {
        return fourthwsEnd;
    }

    public void setFourthwsEnd(Date fourthwsEnd) {
        this.fourthwsEnd = fourthwsEnd;
    }

    public Date getFifthwsStart() {
        return fifthwsStart;
    }

    public void setFifthwsStart(Date fifthwsStart) {
        this.fifthwsStart = fifthwsStart;
    }

    public Date getFifthwsEnd() {
        return fifthwsEnd;
    }

    public void setFifthwsEnd(Date fifthwsEnd) {
        this.fifthwsEnd = fifthwsEnd;
    }

    public Date getSixthwsStart() {
        return sixthwsStart;
    }

    public void setSixthwsStart(Date sixthwsStart) {
        this.sixthwsStart = sixthwsStart;
    }

    public Date getSixthwsEnd() {
        return sixthwsEnd;
    }

    public void setSixthwsEnd(Date sixthwsEnd) {
        this.sixthwsEnd = sixthwsEnd;
    }

    public Funder getFunderId() {
        return funderId;
    }

    public void setFunderId(Funder funderId) {
        this.funderId = funderId;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public FunderContact getFundercontactId() {
        return fundercontactId;
    }

    public void setFundercontactId(FunderContact fundercontactId) {
        this.fundercontactId = fundercontactId;
    }

    public ProjectStatus getProjectstatusId() {
        return projectstatusId;
    }

    public void setProjectstatusId(ProjectStatus projectstatusId) {
        this.projectstatusId = projectstatusId;
    }

    public ProjectAdministrator getProjectadministratorId() {
        return projectadministratorId;
    }

    public void setProjectadministratorId(ProjectAdministrator projectadministratorId) {
        this.projectadministratorId = projectadministratorId;
    }

    public FinancialCoordinator getFinancialcoordinatorId() {
        return financialcoordinatorId;
    }

    public void setFinancialcoordinatorId(FinancialCoordinator financialcoordinatorId) {
        this.financialcoordinatorId = financialcoordinatorId;
    }

    public ProjectManager getProjectmanagerId() {
        return projectmanagerId;
    }

    public void setProjectmanagerId(ProjectManager projectmanagerId) {
        this.projectmanagerId = projectmanagerId;
    }

    public FinancialStatus getFinancialstatusId() {
        return financialstatusId;
    }

    public void setFinancialstatusId(FinancialStatus financialstatusId) {
        this.financialstatusId = financialstatusId;
    }

    public Currency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currency currencyId) {
        this.currencyId = currencyId;
    }

    public Tender getTenderId() {
        return tenderId;
    }

    public void setTenderId(Tender tenderId) {
        this.tenderId = tenderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectsId != null ? projectsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        if ((this.projectsId == null && other.projectsId != null) || (this.projectsId != null && !this.projectsId.equals(other.projectsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.Projects[ projectsId=" + projectsId + " ]";
    }
    
}
