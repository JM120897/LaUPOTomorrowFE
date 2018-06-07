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
        System.out.println("Modificacando");
        modUsu();
    }

    private static void addCoincidencias(List<Noticia> coincidencias, List<Noticia> noticias, String busqueda) {
        String[] params = busqueda.split(" ");

        for (Noticia n : noticias) {
            System.out.println("NOTICIA " + n.getTituloNoticia());
            for (String param : params) {
                System.out.println("\tPARAM: " + param);
                if (n.getTituloNoticia().toLowerCase().contains(param.toLowerCase())) {
                    coincidencias.add(n);
                }
            }
        }
    }


    private static void modUsu() {
        UsuarioREST ur = new UsuarioREST();

        
        String email = "ferasd@gmail.com";
        String localizacion = "micasa";
        String nombreReal ="fernando";
        String nombreUsuario = "fer";
        String password = "1234";
     
        
        Usuario usu = new Usuario();
        usu.setEmail(email);
        usu.setLocalizacion(localizacion);
        usu.setNombreReal(nombreReal);
        usu.setNombreUsuario(nombreUsuario);
        usu.setPassword(password);
        
        ur.edit_XML(usu, nombreUsuario);
        
    }
}