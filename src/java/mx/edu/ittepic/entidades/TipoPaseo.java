/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alon_
 */
@Entity
@Table(name = "TIPO_PASEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPaseo.findAll", query = "SELECT t FROM TipoPaseo t")
    , @NamedQuery(name = "TipoPaseo.findByIdtipo", query = "SELECT t FROM TipoPaseo t WHERE t.idtipo = :idtipo")
    , @NamedQuery(name = "TipoPaseo.findByNomTipo", query = "SELECT t FROM TipoPaseo t WHERE t.nomTipo = :nomTipo")})
public class TipoPaseo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPO")
    private Integer idtipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_TIPO")
    private String nomTipo;

    public TipoPaseo() {
    }

    public TipoPaseo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public TipoPaseo(Integer idtipo, String nomTipo) {
        this.idtipo = idtipo;
        this.nomTipo = nomTipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNomTipo() {
        return nomTipo;
    }

    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaseo)) {
            return false;
        }
        TipoPaseo other = (TipoPaseo) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.TipoPaseo[ idtipo=" + idtipo + " ]";
    }
    
}
