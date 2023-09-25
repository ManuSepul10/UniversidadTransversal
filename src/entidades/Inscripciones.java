
package entidades;


public class Inscripciones{
    private int idIncripciones;
    private Alumno alumnos;
    private Materia materia;
    private double nota;

    public Inscripciones() {
    }

    public Inscripciones(int idIncripciones, Alumno alumnos, Materia materia, double nota) {
        this.idIncripciones = idIncripciones;
        this.alumnos = alumnos;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripciones(Alumno alumnos, Materia materia, double nota) {
        this.alumnos = alumnos;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripciones(double nota) {
        this.nota = nota;
    }

    public int getIdIncripciones() {
        return idIncripciones;
    }

    public void setIdIncripciones(int idIncripciones) {
        this.idIncripciones = idIncripciones;
    }

    public Alumno getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno alumnos) {
        this.alumnos = alumnos;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscripciones{" + "idIncripciones=" + idIncripciones + ", alumnos=" + alumnos + ", materia=" + materia + ", nota=" + nota + '}';
    }
    
    
}
