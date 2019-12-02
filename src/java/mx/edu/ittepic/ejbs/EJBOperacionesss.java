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
import mx.edu.ittepic.entidades.LugarR;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author alon_
 */
@Stateless
public class EJBOperacionesss {

    @PersistenceContext
    EntityManager em;

    public String nuevoLugar(int idlugarR, String nomLugar,String descripcion, String direccion) {
//em.merge(r);
        LugarR u = new LugarR();
        u.setIdlugarR(idlugarR);
        u.setNomLugar(nomLugar);
        u.setDescripcion(descripcion);
        u.setDireccion(direccion);
        String msj;
        try {
            em.persist(u);
            msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";

        } catch (Exception e) {
            msj = "{\"codigo\":400, \"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;
    }
    public String consultaLugar() {
        try {
            Query q;
            List<LugarR> listaLugar;
            q = em.createNamedQuery("LugarR.findAll");
            listaLugar = q.getResultList(); //ejecutar consulta
            //convertir la lista a objetos JSON
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(listaLugar);

        } catch (Exception e) {
            return "{msg:Error}";
        }
    }
    public String actualiza(int idlugarR, String nomLugar,String descripcion, String direccion) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String msj;
        LugarR u = new LugarR();
        try {
            u = em.find(LugarR.class, idlugarR); //Buscar por usuarioid
            u.setNomLugar(nomLugar);
            u.setDescripcion(descripcion);
            u.setDireccion(direccion);
            em.merge(u);

            msj = "{codigo:200- La operacion se realizo correctamente}";
        } catch (NumberFormatException e) {
            msj = "{codigo:400 msj-Error en los tipos de parametros}";
        }//fin del try
        return msj;
    }//fin actualiza usuario
      public String eliminaLugar(int idlugarR) {

        LugarR tipo = new LugarR();
        String msj;
        try {
            tipo = (LugarR) em.createNamedQuery("LugarR.findByIdlugarR").setParameter("idlugarR", idlugarR).getSingleResult();
            em.remove(em.merge(tipo));
            msj = "{\"code\":200,\"msj\":\"La operación se realizo correctamente\"}";
        } catch (NumberFormatException e) {
            msj = "{\"code\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;
    }//eliminar usuario

}
