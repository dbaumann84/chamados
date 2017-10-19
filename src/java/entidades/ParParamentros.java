/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author profe
 */
@Entity
@Table(name = "par_paramentros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParParamentros.findAll", query = "SELECT p FROM ParParamentros p")
    , @NamedQuery(name = "ParParamentros.findByParId", query = "SELECT p FROM ParParamentros p WHERE p.parId = :parId")
    , @NamedQuery(name = "ParParamentros.findByParDescricao", query = "SELECT p FROM ParParamentros p WHERE p.parDescricao = :parDescricao")
    , @NamedQuery(name = "ParParamentros.findByParValor", query = "SELECT p FROM ParParamentros p WHERE p.parValor = :parValor")})
public class ParParamentros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "par_id")
    private Integer parId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "par_descricao")
    private String parDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "par_valor")
    private int parValor;
    @Lob
    @Size(max = 65535)
    @Column(name = "par_observacao")
    private String parObservacao;

    public ParParamentros() {
    }

    public ParParamentros(Integer parId) {
        this.parId = parId;
    }

    public ParParamentros(Integer parId, String parDescricao, int parValor) {
        this.parId = parId;
        this.parDescricao = parDescricao;
        this.parValor = parValor;
    }

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public String getParDescricao() {
        return parDescricao;
    }

    public void setParDescricao(String parDescricao) {
        this.parDescricao = parDescricao;
    }

    public int getParValor() {
        return parValor;
    }

    public void setParValor(int parValor) {
        this.parValor = parValor;
    }

    public String getParObservacao() {
        return parObservacao;
    }

    public void setParObservacao(String parObservacao) {
        this.parObservacao = parObservacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parId != null ? parId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParParamentros)) {
            return false;
        }
        ParParamentros other = (ParParamentros) object;
        if ((this.parId == null && other.parId != null) || (this.parId != null && !this.parId.equals(other.parId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ParParamentros[ parId=" + parId + " ]";
    }
    
}
