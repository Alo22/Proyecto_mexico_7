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
@Table(name = "LUGAR_R")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LugarR.findAll", query = "SELECT l FROM LugarR l")
    , @NamedQuery(name = "LugarR.findByIdlugarR", query = "SELECT l FROM LugarR l WHERE l.idlugarR = :idlugarR")
    , @NamedQuery(name = "LugarR.findByNomLugar", query = "SELECT l FROM LugarR l WHERE l.nomLugar = :nomLugar")
    , @NamedQuery(name = "LugarR.findByDescripcion", query = "SELECT l FROM LugarR l WHERE l.descripcion = :descripcion")
    , @NamedQuery(name = "LugarR.findByDireccion", query = "SELECT l FROM LugarR l WHERE l.direccion = :direccion")})
public class LugarR implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLUGAR_R")
    private Integer idlugarR;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_LUGAR")
    private String nomLugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;

    public LugarR() {
    }

    public LugarR(Integer idlugarR) {
        this.idlugarR = idlugarR;
    }

    public LugarR(Integer idlugarR, String nomLugar, String descripcion, String direccion) {
        this.idlugarR = idlugarR;
        this.nomLugar = nomLugar;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }

    public Integer getIdlugarR() {
        return idlugarR;
    }

    public void setIdlugarR(Integer idlugarR) {
        this.idlugarR = idlugarR;
    }

    public String getNomLugar() {
        return nomLugar;
    }

    public void setNomLugar(String nomLugar) {
        this.nomLugar = nomLugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlugarR != null ? idlugarR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LugarR)) {
            return false;
        }
        LugarR other = (LugarR) object;
        if ((this.idlugarR == null && other.idlugarR != null) || (this.idlugarR != null && !this.idlugarR.equals(other.idlugarR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.LugarR[ idlugarR=" + idlugarR + " ]";
    }
    
}
