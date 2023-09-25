
package entidades;


public class Materia {
    private int idMateria;
    private String nombre;
    private int añomateria;
    private boolean activo;

    public Materia(int idMateria, String nombre, int añomateria, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.añomateria = añomateria;
        this.activo = activo;
    }

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int añomateria) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.añomateria = añomateria;
    }

    public Materia(String nombre, int añomateria, boolean activo) {
        this.nombre = nombre;
        this.añomateria = añomateria;
        this.activo = activo;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñomateria() {
        return añomateria;
    }

    public void setAñomateria(int añomateria) {
        this.añomateria = añomateria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return " " + nombre + ", " + añomateria + ", Estado: " + activo;
    }
    
    
    
}
