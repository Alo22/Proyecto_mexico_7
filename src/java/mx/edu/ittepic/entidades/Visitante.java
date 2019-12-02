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
@Table(name = "VISITANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitante.findAll", query = "SELECT v FROM Visitante v")
    , @NamedQuery(name = "Visitante.findByIdvisitante", query = "SELECT v FROM Visitante v WHERE v.idvisitante = :idvisitante")
    , @NamedQuery(name = "Visitante.findByNombre", query = "SELECT v FROM Visitante v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Visitante.findByAp", query = "SELECT v FROM Visitante v WHERE v.ap = :ap")
    , @NamedQuery(name = "Visitante.findByAm", query = "SELECT v FROM Visitante v WHERE v.am = :am")
    , @NamedQuery(name = "Visitante.findByGenero", query = "SELECT v FROM Visitante v WHERE v.genero = :genero")
    , @NamedQuery(name = "Visitante.findByCorreo", query = "SELECT v FROM Visitante v WHERE v.correo = :correo")})
public class Visitante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVISITANTE")
    private Integer idvisitante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AP")
    private String ap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AM")
    private String am;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "GENERO")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO")
    private String correo;

    public Visitante() {
    }

    public Visitante(Integer idvisitante) {
        this.idvisitante = idvisitante;
    }

    public Visitante(Integer idvisitante, String nombre, String ap, String am, String genero, String correo) {
        this.idvisitante = idvisitante;
        this.nombre = nombre;
        this.ap = ap;
        this.am = am;
        this.genero = genero;
        this.correo = correo;
    }

    public Integer getIdvisitante() {
        return idvisitante;
    }

    public void setIdvisitante(Integer idvisitante) {
        this.idvisitante = idvisitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvisitante != null ? idvisitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitante)) {
            return false;
        }
        Visitante other = (Visitante) object;
        if ((this.idvisitante == null && other.idvisitante != null) || (this.idvisitante != null && !this.idvisitante.equals(other.idvisitante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Visitante[ idvisitante=" + idvisitante + " ]";
    }
    
}
