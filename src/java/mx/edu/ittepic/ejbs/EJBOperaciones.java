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
import mx.edu.ittepic.entidades.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author alon_
 */
@Stateless
public class EJBOperaciones {

    @PersistenceContext
    EntityManager em;
 //metodo para usuario
    public String nuevoUsuario(int idusuario, String nombre, String ap, String am, String genero, String correo) {
//em.merge(r);
        Usuario u = new Usuario();
        u.setIdusuario(idusuario);
        u.setNombre(nombre);
        u.setAp(ap);
        u.setAm(am);
        u.setGenero(genero);
        u.setCorreo(correo);
        String msj;
        try {
            em.persist(u);
            msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";

        } catch (Exception e) {
            msj = "{\"codigo\":400, \"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;
    }
     

    public String consultaUsuario() {
        try {
            Query q;
            List<Usuario> listaUsuario;
            q = em.createNamedQuery("Usuario.findAll");
            listaUsuario = q.getResultList(); //ejecutar consulta
            //convertir la lista a objetos JSON
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(listaUsuario);

        } catch (Exception e) {
            return "{msg:Error}";
        }
    }
   
    public String actualiza(int idusuario, String nombre, String ap, String am, String genero, String correo) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String msj;
        Usuario u = new Usuario();
        try {
            u = em.find(Usuario.class, idusuario); //Buscar por usuarioid
            u.setNombre(nombre);
            u.setAp(ap);
            u.setAm(am);
            u.setGenero(genero);
            u.setCorreo(correo);
            em.merge(u);

            msj = "{codigo:200- La operacion se realizo correctamente}";
        } catch (NumberFormatException e) {
            msj = "{codigo:400 msj-Error en los tipos de parametros}";
        }//fin del try
        return msj;
    }//fin actualiza usuario
    
    //consulta tipo
    
    
    public String eliminaUsuario(int idusuario) {

        Usuario usuario = new Usuario();
        String msj;
        try {
            usuario = (Usuario) em.createNamedQuery("Usuario.findByIdusuario").setParameter("idusuario", idusuario).getSingleResult();
            em.remove(em.merge(usuario));
            msj = "{\"code\":200,\"msj\":\"La operación se realizo correctamente\"}";
        } catch (NumberFormatException e) {
            msj = "{\"code\":400,\"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;
    }//eliminar usuario

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
