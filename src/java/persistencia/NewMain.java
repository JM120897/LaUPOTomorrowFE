/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.Noticia;
import classes.Tag;
import classes.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Juanma
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NoticiaREST nr = new NoticiaREST();
        GenericType<List<Noticia>> gt = new GenericType<List<Noticia>>(){};
        List<Noticia> noticias = nr.findAll_XML(gt);
        List<Noticia> coincidencias = new ArrayList<>();
        addCoincidencias(coincidencias, noticias, "risa");
        System.out.println(coincidencias);
    }

    private static void addCoincidencias(List<Noticia> coincidencias, List<Noticia> noticias, String busqueda) {
        String[] params = busqueda.split(" ");
        for (Noticia n : noticias) {
            System.out.println("Noticia: " + n.getTituloNoticia());
            for (String param : params) {
                System.out.println("\tParam: " + param);
                if (!coincidencias.contains(n) && n.getTituloNoticia().toLowerCase().contains(param.toLowerCase())) {
                    coincidencias.add(n);
                }
                
                List<Tag> l = (List<Tag>) n.getTagCollection();
                if(l != null){
                    for(Tag t : l){
                        System.out.println("Tag: " + t.getNombreTag());
                        if(!coincidencias.contains(n) && t.getNombreTag().equalsIgnoreCase(param)){
                            coincidencias.add(n);
                        }
                    }
                }
            }
        }
    }


    private static void modUsu() {
        UsuarioREST ur = new UsuarioREST();

        
        String email = "ferasd@gmail.com";
        String localizacion = "micasa";
        String nombreReal ="fernando";
        String nombreUsuario = "test1";
        String password = "1234";
        String rol = "redactor";
     
        
        Usuario usu = new Usuario();
        usu.setEmail(email);
        usu.setLocalizacion(localizacion);
        usu.setNombreReal(nombreReal);
        usu.setNombreUsuario(nombreUsuario);
        usu.setPassword(password);
        usu.setRol(rol);
        
        ur.edit_XML(usu, nombreUsuario);
        
    }
}