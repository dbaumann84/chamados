/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author profe
 */
@Entity
@Table(name = "lab_laboratorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabLaboratorio.findAll", query = "SELECT l FROM LabLaboratorio l")
    , @NamedQuery(name = "LabLaboratorio.findByLabId", query = "SELECT l FROM LabLaboratorio l WHERE l.labId = :labId")
    , @NamedQuery(name = "LabLaboratorio.findByLabDescricao", query = "SELECT l FROM LabLaboratorio l WHERE l.labDescricao = :labDescricao")})
public class LabLaboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lab_id")
    private Integer labId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lab_descricao")
    private String labDescricao;
    @Lob
    @Size(max = 65535)
    @Column(name = "lab_observacao")
    private String labObservacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "labId")
    private Collection<MelMelhoria> melMelhoriaCollection;
    @OneToMany(mappedBy = "llabId")
    private Collection<ResReserva> resReservaCollection;

    public LabLaboratorio() {
    }

    public LabLaboratorio(Integer labId) {
        this.labId = labId;
    }

    public LabLaboratorio(Integer labId, String labDescricao) {
        this.labId = labId;
        this.labDescricao = labDescricao;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public String getLabDescricao() {
        return labDescricao;
    }

    public void setLabDescricao(String labDescricao) {
        this.labDescricao = labDescricao;
    }

    public String getLabObservacao() {
        return labObservacao;
    }

    public void setLabObservacao(String labObservacao) {
        this.labObservacao = labObservacao;
    }

    @XmlTransient
    public Collection<MelMelhoria> getMelMelhoriaCollection() {
        return melMelhoriaCollection;
    }

    public void setMelMelhoriaCollection(Collection<MelMelhoria> melMelhoriaCollection) {
        this.melMelhoriaCollection = melMelhoriaCollection;
    }

    @XmlTransient
    public Collection<ResReserva> getResReservaCollection() {
        return resReservaCollection;
    }

    public void setResReservaCollection(Collection<ResReserva> resReservaCollection) {
        this.resReservaCollection = resReservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labId != null ? labId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabLaboratorio)) {
            return false;
        }
        LabLaboratorio other = (LabLaboratorio) object;
        if ((this.labId == null && other.labId != null) || (this.labId != null && !this.labId.equals(other.labId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return labDescricao;
    }
    
}
