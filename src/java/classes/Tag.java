package classes;
// Generated 07-jun-2018 11:59:51 by Hibernate Tools 4.3.1



/**
 * Tag generated by hbm2java
 */
public class Tag  implements java.io.Serializable {


     private String nombreTag;
     private Noticia noticia;

    public Tag() {
    }

    public Tag(String nombreTag, Noticia noticia) {
       this.nombreTag = nombreTag;
       this.noticia = noticia;
    }
   
    public String getNombreTag() {
        return this.nombreTag;
    }
    
    public void setNombreTag(String nombreTag) {
        this.nombreTag = nombreTag;
    }
    public Noticia getNoticia() {
        return this.noticia;
    }
    
    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }




}


