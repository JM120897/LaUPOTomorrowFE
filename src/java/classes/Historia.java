package classes;
// Generated 07-jun-2018 11:59:51 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Historia generated by hbm2java
 */
public class Historia  implements java.io.Serializable {


     private Integer idHistoria;
     private Usuario usuario;
     private String tituloHistoria;
     private String subtituloHistoria;
     private Date fechaHistoria;
     private Set noticias = new HashSet(0);

    public Historia() {
    }

	
    public Historia(String tituloHistoria, String subtituloHistoria, Date fechaHistoria) {
        this.tituloHistoria = tituloHistoria;
        this.subtituloHistoria = subtituloHistoria;
        this.fechaHistoria = fechaHistoria;
    }
    public Historia(Usuario usuario, String tituloHistoria, String subtituloHistoria, Date fechaHistoria, Set noticias) {
       this.usuario = usuario;
       this.tituloHistoria = tituloHistoria;
       this.subtituloHistoria = subtituloHistoria;
       this.fechaHistoria = fechaHistoria;
       this.noticias = noticias;
    }
   
    public Integer getIdHistoria() {
        return this.idHistoria;
    }
    
    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getTituloHistoria() {
        return this.tituloHistoria;
    }
    
    public void setTituloHistoria(String tituloHistoria) {
        this.tituloHistoria = tituloHistoria;
    }
    public String getSubtituloHistoria() {
        return this.subtituloHistoria;
    }
    
    public void setSubtituloHistoria(String subtituloHistoria) {
        this.subtituloHistoria = subtituloHistoria;
    }
    public Date getFechaHistoria() {
        return this.fechaHistoria;
    }
    
    public void setFechaHistoria(Date fechaHistoria) {
        this.fechaHistoria = fechaHistoria;
    }
    public Set getNoticias() {
        return this.noticias;
    }
    
    public void setNoticias(Set noticias) {
        this.noticias = noticias;
    }




}


