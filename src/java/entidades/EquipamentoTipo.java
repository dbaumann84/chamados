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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author profe
 */
@Entity
@Table(name = "equipamento_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipamentoTipo.findAll", query = "SELECT e FROM EquipamentoTipo e")
    , @NamedQuery(name = "EquipamentoTipo.findByTpeId", query = "SELECT e FROM EquipamentoTipo e WHERE e.tpeId = :tpeId")
    , @NamedQuery(name = "EquipamentoTipo.findByTpeDescricao", query = "SELECT e FROM EquipamentoTipo e WHERE e.tpeDescricao = :tpeDescricao")})
public class EquipamentoTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tpe_id")
    private Integer tpeId;
    @Size(max = 45)
    @Column(name = "tpe_descricao")
    private String tpeDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipamentoTipoTpeId")
    private Collection<EquEquipamento> equEquipamentoCollection;

    public EquipamentoTipo() {
    }

    public EquipamentoTipo(Integer tpeId) {
        this.tpeId = tpeId;
    }

    public Integer getTpeId() {
        return tpeId;
    }

    public void setTpeId(Integer tpeId) {
        this.tpeId = tpeId;
    }

    public String getTpeDescricao() {
        return tpeDescricao;
    }

    public void setTpeDescricao(String tpeDescricao) {
        this.tpeDescricao = tpeDescricao;
    }

    @XmlTransient
    public Collection<EquEquipamento> getEquEquipamentoCollection() {
        return equEquipamentoCollection;
    }

    public void setEquEquipamentoCollection(Collection<EquEquipamento> equEquipamentoCollection) {
        this.equEquipamentoCollection = equEquipamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpeId != null ? tpeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipamentoTipo)) {
            return false;
        }
        EquipamentoTipo other = (EquipamentoTipo) object;
        if ((this.tpeId == null && other.tpeId != null) || (this.tpeId != null && !this.tpeId.equals(other.tpeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tpeDescricao;
    }
    
}
