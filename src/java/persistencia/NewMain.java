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
        NoticiaREST ur = new NoticiaREST();
        GenericType<List<Noticia>> gt = new GenericType<List<Noticia>>(){};
        List<Noticia> todas = ur.findAll_XML(gt);
        List<Noticia> coincidencias = new ArrayList<>();
        addCoincidencias(coincidencias, todas, "RA PeDRO");
        if(coincidencias.size() == 0){
            System.out.println("NINGUNA " + coincidencias);
        }else{
            System.out.println("ALGUNAS " + coincidencias);
        }
        
        
       
    }
    
    private static void addCoincidencias(List<Noticia> coincidencias, List<Noticia> noticias, String busqueda) {
        String[] params = busqueda.split(" ");
        
        for(Noticia n : noticias){
            System.out.println("NOTICIA " + n.getTituloNoticia());
            for(String param : params){
                System.out.println("\tPARAM: " + param);
                if(n.getTituloNoticia().toLowerCase().contains(param.toLowerCase())){
                    coincidencias.add(n);
                }
            }
        }
    }
    
}
