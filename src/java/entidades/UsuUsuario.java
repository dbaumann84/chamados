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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author profe
 */
@Entity
@Table(name = "usu_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuUsuario.findAll", query = "SELECT u FROM UsuUsuario u")
    , @NamedQuery(name = "UsuUsuario.findByUsuId", query = "SELECT u FROM UsuUsuario u WHERE u.usuId = :usuId")
    , @NamedQuery(name = "UsuUsuario.findByUsuNomeCompleto", query = "SELECT u FROM UsuUsuario u WHERE u.usuNomeCompleto = :usuNomeCompleto")
    , @NamedQuery(name = "UsuUsuario.findByUsuEmail", query = "SELECT u FROM UsuUsuario u WHERE u.usuEmail = :usuEmail")
    , @NamedQuery(name = "UsuUsuario.findByUsuSenha", query = "SELECT u FROM UsuUsuario u WHERE u.usuSenha = :usuSenha")
    , @NamedQuery(name = "UsuUsuario.findByUsuAdmin", query = "SELECT u FROM UsuUsuario u WHERE u.usuAdmin = :usuAdmin")
    , @NamedQuery(name = "UsuUsuario.findByUsuTelefone", query = "SELECT u FROM UsuUsuario u WHERE u.usuTelefone = :usuTelefone")})
public class UsuUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id")
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usu_nome_completo")
    private String usuNomeCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usu_email")
    private String usuEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usu_senha")
    private String usuSenha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_admin")
    private int usuAdmin;
    @Size(max = 45)
    @Column(name = "usu_telefone")
    private String usuTelefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private Collection<MelMelhoria> melMelhoriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuUsuarioIdUsuario")
    private Collection<ResReserva> resReservaCollection;

    public UsuUsuario() {
    }

    public UsuUsuario(Integer usuId) {
        this.usuId = usuId;
    }

    public UsuUsuario(Integer usuId, String usuNomeCompleto, String usuEmail, String usuSenha, int usuAdmin) {
        this.usuId = usuId;
        this.usuNomeCompleto = usuNomeCompleto;
        this.usuEmail = usuEmail;
        this.usuSenha = usuSenha;
        this.usuAdmin = usuAdmin;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuNomeCompleto() {
        return usuNomeCompleto;
    }

    public void setUsuNomeCompleto(String usuNomeCompleto) {
        this.usuNomeCompleto = usuNomeCompleto;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public int getUsuAdmin() {
        return usuAdmin;
    }

    public void setUsuAdmin(int usuAdmin) {
        this.usuAdmin = usuAdmin;
    }

    public String getUsuTelefone() {
        return usuTelefone;
    }

    public void setUsuTelefone(String usuTelefone) {
        this.usuTelefone = usuTelefone;
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
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuUsuario)) {
            return false;
        }
        UsuUsuario other = (UsuUsuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return usuNomeCompleto;
    }
    
}
