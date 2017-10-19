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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "equ_equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquEquipamento.findAll", query = "SELECT e FROM EquEquipamento e")
    , @NamedQuery(name = "EquEquipamento.findByEquId", query = "SELECT e FROM EquEquipamento e WHERE e.equId = :equId")
    , @NamedQuery(name = "EquEquipamento.findByEquDescricao", query = "SELECT e FROM EquEquipamento e WHERE e.equDescricao = :equDescricao")
    , @NamedQuery(name = "EquEquipamento.findByEquAtivo", query = "SELECT e FROM EquEquipamento e WHERE e.equAtivo = :equAtivo")
    , @NamedQuery(name = "EquEquipamento.findByEquObservacoes", query = "SELECT e FROM EquEquipamento e WHERE e.equObservacoes = :equObservacoes")})
public class EquEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "equ_id")
    private Integer equId;
    @Size(max = 45)
    @Column(name = "equ_descricao")
    private String equDescricao;
    @Column(name = "equ_ativo")
    private Integer equAtivo;
    @Size(max = 45)
    @Column(name = "equ_observacoes")
    private String equObservacoes;
    @JoinColumn(name = "equipamento_tipo_tpe_id", referencedColumnName = "tpe_id")
    @ManyToOne(optional = false)
    private EquipamentoTipo equipamentoTipoTpeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equEquipamento")
    private Collection<MelMelhoria> melMelhoriaCollection;
    @OneToMany(mappedBy = "equId")
    private Collection<ResReserva> resReservaCollection;

    public EquEquipamento() {
    }

    public EquEquipamento(Integer equId) {
        this.equId = equId;
    }

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public String getEquDescricao() {
        return equDescricao;
    }

    public void setEquDescricao(String equDescricao) {
        this.equDescricao = equDescricao;
    }

    public Integer getEquAtivo() {
        return equAtivo;
    }

    public void setEquAtivo(Integer equAtivo) {
        this.equAtivo = equAtivo;
    }

    public String getEquObservacoes() {
        return equObservacoes;
    }

    public void setEquObservacoes(String equObservacoes) {
        this.equObservacoes = equObservacoes;
    }

    public EquipamentoTipo getEquipamentoTipoTpeId() {
        return equipamentoTipoTpeId;
    }

    public void setEquipamentoTipoTpeId(EquipamentoTipo equipamentoTipoTpeId) {
        this.equipamentoTipoTpeId = equipamentoTipoTpeId;
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
        hash += (equId != null ? equId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquEquipamento)) {
            return false;
        }
        EquEquipamento other = (EquEquipamento) object;
        if ((this.equId == null && other.equId != null) || (this.equId != null && !this.equId.equals(other.equId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return equDescricao;
    }
    
}
