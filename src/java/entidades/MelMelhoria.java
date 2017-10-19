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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "mel_melhoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MelMelhoria.findAll", query = "SELECT m FROM MelMelhoria m")
    , @NamedQuery(name = "MelMelhoria.findByMelId", query = "SELECT m FROM MelMelhoria m WHERE m.melMelhoriaPK.melId = :melId")
    , @NamedQuery(name = "MelMelhoria.findByMelDataHora", query = "SELECT m FROM MelMelhoria m WHERE m.melDataHora = :melDataHora")
    , @NamedQuery(name = "MelMelhoria.findByEquId", query = "SELECT m FROM MelMelhoria m WHERE m.melMelhoriaPK.equId = :equId")
    , @NamedQuery(name = "MelMelhoria.findByMelResolvido", query = "SELECT m FROM MelMelhoria m WHERE m.melResolvido = :melResolvido")})
public class MelMelhoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MelMelhoriaPK melMelhoriaPK;
    @Lob
    @Size(max = 65535)
    @Column(name = "mel_observacao")
    private String melObservacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mel_data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date melDataHora;
    @Lob
    @Size(max = 65535)
    @Column(name = "mel_resposta")
    private String melResposta;
    @Column(name = "mel_resolvido")
    private Integer melResolvido;
    @JoinColumn(name = "equ_id", referencedColumnName = "equ_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EquEquipamento equEquipamento;
    @JoinColumn(name = "lab_id", referencedColumnName = "lab_id")
    @ManyToOne(optional = false)
    private LabLaboratorio labId;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private UsuUsuario usuId;

    public MelMelhoria() {
    }

    public MelMelhoria(MelMelhoriaPK melMelhoriaPK) {
        this.melMelhoriaPK = melMelhoriaPK;
    }

    public MelMelhoria(MelMelhoriaPK melMelhoriaPK, Date melDataHora) {
        this.melMelhoriaPK = melMelhoriaPK;
        this.melDataHora = melDataHora;
    }

    public MelMelhoria(int melId, int equId) {
        this.melMelhoriaPK = new MelMelhoriaPK(melId, equId);
    }

    public MelMelhoriaPK getMelMelhoriaPK() {
        return melMelhoriaPK;
    }

    public void setMelMelhoriaPK(MelMelhoriaPK melMelhoriaPK) {
        this.melMelhoriaPK = melMelhoriaPK;
    }

    public String getMelObservacao() {
        return melObservacao;
    }

    public void setMelObservacao(String melObservacao) {
        this.melObservacao = melObservacao;
    }

    public Date getMelDataHora() {
        return melDataHora;
    }

    public void setMelDataHora(Date melDataHora) {
        this.melDataHora = melDataHora;
    }

    public String getMelResposta() {
        return melResposta;
    }

    public void setMelResposta(String melResposta) {
        this.melResposta = melResposta;
    }

    public Integer getMelResolvido() {
        return melResolvido;
    }

    public void setMelResolvido(Integer melResolvido) {
        this.melResolvido = melResolvido;
    }

    public EquEquipamento getEquEquipamento() {
        return equEquipamento;
    }

    public void setEquEquipamento(EquEquipamento equEquipamento) {
        this.equEquipamento = equEquipamento;
    }

    public LabLaboratorio getLabId() {
        return labId;
    }

    public void setLabId(LabLaboratorio labId) {
        this.labId = labId;
    }

    public UsuUsuario getUsuId() {
        return usuId;
    }

    public void setUsuId(UsuUsuario usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (melMelhoriaPK != null ? melMelhoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MelMelhoria)) {
            return false;
        }
        MelMelhoria other = (MelMelhoria) object;
        if ((this.melMelhoriaPK == null && other.melMelhoriaPK != null) || (this.melMelhoriaPK != null && !this.melMelhoriaPK.equals(other.melMelhoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MelMelhoria[ melMelhoriaPK=" + melMelhoriaPK + " ]";
    }
    
}
