/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.edu.ittepic.entidades.TipoPaseo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author alon_
 */
@Stateless
public class EJBOperacioness {

    @PersistenceContext
    EntityManager em;

    public String nuevoTipo(int idtipo, String nomTipo) {
//em.merge(r);
        TipoPaseo u = new TipoPaseo();
        u.setIdtipo(idtipo);
        u.setNomTipo(nomTipo);
        String msj;
        try {
            em.persist(u);
            msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";

        } catch (Exception e) {
            msj = "{\"codigo\":400, \"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;
    }
    public String consultaTipo() {
        try {
            Query q;
            List<TipoPaseo> listaTipo;
            q = em.createNamedQuery("TipoPaseo.findAll");
            listaTipo = q.getResultList(); //ejecutar consulta
            //convertir la lista a objetos JSON
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(listaTipo);

        } catch (Exception e) {
            return "{msg:Error}";
        }
    }
    public String actualiza(int idtipo, String nomTipo) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String msj;
        TipoPaseo u = new TipoPaseo();
        try {
            u = em.find(TipoPaseo.class, idtipo); //Buscar por usuarioid
            u.setNomTipo(nomTipo);
            em.merge(u);

            msj = "{codigo:200- La operacion se realizo correctamente}";
        } catch (NumberFormatException e) {
            msj = "{codigo:400 msj-Error en los tipos de parametros}";
        }//fin del try
        return msj;
    }//fin actualiza usuario
      public String eliminaTipo(int idtipo) {

        TipoPaseo tipo = new TipoPaseo();
        String msj;
        try {
            tipo = (TipoPaseo) em.createNamedQuery("TipoPaseo.findByIdtipo").setParameter("idtipo", idtipo).getSingleResult();
            em.remove(em.merge(tipo));
            msj = "{\"code\":200,\"msj\":\"La operación se realizo correctamente\"}";
        } catch (NumberFormatException e) {
            msj = "{\"code\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;
    }//eliminar usuario

}
