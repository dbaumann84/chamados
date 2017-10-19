/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author profe
 */
@Entity
@Table(name = "res_reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResReserva.findAll", query = "SELECT r FROM ResReserva r")
    , @NamedQuery(name = "ResReserva.findByResId", query = "SELECT r FROM ResReserva r WHERE r.resId = :resId")
    , @NamedQuery(name = "ResReserva.findByResDataHora", query = "SELECT r FROM ResReserva r WHERE r.resDataHora = :resDataHora")
    , @NamedQuery(name = "ResReserva.findByResDataReservaInicial", query = "SELECT r FROM ResReserva r WHERE r.resDataReservaInicial = :resDataReservaInicial")
    , @NamedQuery(name = "ResReserva.findByResDataReservaFinal", query = "SELECT r FROM ResReserva r WHERE r.resDataReservaFinal = :resDataReservaFinal")})
public class ResReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "res_id")
    private Integer resId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resDataHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_data_reserva_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resDataReservaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_data_reserva_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resDataReservaFinal;
    @Lob
    @Size(max = 65535)
    @Column(name = "res_observacao")
    private String resObservacao;
    @JoinColumn(name = "equ_id", referencedColumnName = "equ_id")
    @ManyToOne
    private EquEquipamento equId;
    @JoinColumn(name = "llab_id", referencedColumnName = "lab_id")
    @ManyToOne
    private LabLaboratorio llabId;
    @JoinColumn(name = "usu_usuario_id_usuario", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private UsuUsuario usuUsuarioIdUsuario;

    public ResReserva() {
    }

    public ResReserva(Integer resId) {
        this.resId = resId;
    }

    public ResReserva(Integer resId, Date resDataHora, Date resDataReservaInicial, Date resDataReservaFinal) {
        this.resId = resId;
        this.resDataHora = resDataHora;
        this.resDataReservaInicial = resDataReservaInicial;
        this.resDataReservaFinal = resDataReservaFinal;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Date getResDataHora() {
        return resDataHora;
    }

    public void setResDataHora(Date resDataHora) {
        this.resDataHora = resDataHora;
    }

    public Date getResDataReservaInicial() {
        return resDataReservaInicial;
    }

    public void setResDataReservaInicial(Date resDataReservaInicial) {
        this.resDataReservaInicial = resDataReservaInicial;
    }

    public Date getResDataReservaFinal() {
        return resDataReservaFinal;
    }

    public void setResDataReservaFinal(Date resDataReservaFinal) {
        this.resDataReservaFinal = resDataReservaFinal;
    }

    public String getResObservacao() {
        return resObservacao;
    }

    public void setResObservacao(String resObservacao) {
        this.resObservacao = resObservacao;
    }

    public EquEquipamento getEquId() {
        return equId;
    }

    public void setEquId(EquEquipamento equId) {
        this.equId = equId;
    }

    public LabLaboratorio getLlabId() {
        return llabId;
    }

    public void setLlabId(LabLaboratorio llabId) {
        this.llabId = llabId;
    }

    public UsuUsuario getUsuUsuarioIdUsuario() {
        return usuUsuarioIdUsuario;
    }

    public void setUsuUsuarioIdUsuario(UsuUsuario usuUsuarioIdUsuario) {
        this.usuUsuarioIdUsuario = usuUsuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResReserva)) {
            return false;
        }
        ResReserva other = (ResReserva) object;
        if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ResReserva[ resId=" + resId + " ]";
    }
    
}
