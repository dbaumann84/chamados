/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author profe
 */
@Embeddable
public class MelMelhoriaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "mel_id")
    private int melId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "equ_id")
    private int equId;

    public MelMelhoriaPK() {
    }

    public MelMelhoriaPK(int melId, int equId) {
        this.melId = melId;
        this.equId = equId;
    }

    public int getMelId() {
        return melId;
    }

    public void setMelId(int melId) {
        this.melId = melId;
    }

    public int getEquId() {
        return equId;
    }

    public void setEquId(int equId) {
        this.equId = equId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) melId;
        hash += (int) equId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MelMelhoriaPK)) {
            return false;
        }
        MelMelhoriaPK other = (MelMelhoriaPK) object;
        if (this.melId != other.melId) {
            return false;
        }
        if (this.equId != other.equId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MelMelhoriaPK[ melId=" + melId + ", equId=" + equId + " ]";
    }
    
}
