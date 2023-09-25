/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoADatos;

import entidades.Alumno;
import entidades.Inscripciones;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kanko
 */
public class InscripcionData {

    public static void inscribirseMateria(int materia, Alumno alumno) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = Conexion.getConexion();
            String sql = "INSERT INTO inscripcion(idAlumno, idMateria) VALUES (?,?)";
            int idAlumno = alumno.getIdAlumno();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, materia);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void borrarIncripcion(int materia, Alumno alumno) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexion.getConexion();
        String sql = "DELETE FROM inscripcion WHERE idAlumno= ? AND idMateria=?";
        int idAlumno = alumno.getIdAlumno();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, materia);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //incripcion.data
    public static ArrayList<Inscripciones> listadoInscripciones(Alumno alu) {
        ArrayList<Inscripciones> inscripciones = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Materia materia = null;
        con = Conexion.getConexion();
        String sql = "SELECT * FROM inscripcion WHERE idAlumno=?";
        int id = alu.getIdAlumno();
        Inscripciones inscripcione = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                inscripcione = new Inscripciones();
                int idMateria = rs.getInt("idMateria");
                double nota = rs.getDouble("nota");
                inscripcione.setAlumnos(alu);
                inscripcione.setMateria(MateriaData.materia(idMateria));
                inscripcione.setNota(nota);
                inscripciones.add(inscripcione);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inscripciones;
    }

    public static void modificarNota(int idMateria, Alumno alumno, double nota) {
        try (Connection con = Conexion.getConexion();PreparedStatement ps = con.prepareStatement("UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?;")) {
            int idAlumno = alumno.getIdAlumno();
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("La nota se ha actualizado correctamente.");
            } else {
                System.out.println("No se encontro una inscripcion valida para actualizar.");
            }
        } catch (SQLException ex) {
            // Manejar la excepción de manera adecuada, como mostrar un mensaje de error.
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Materia> buscarinscripciones(Alumno alu) {
        ArrayList<Materia> materias = new ArrayList<>();
        ArrayList<Integer> idmaterias = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Materia materia = null;
        con = Conexion.getConexion();
        String sql = "SELECT idMateria FROM inscripcion WHERE idAlumno=?";
        int id = alu.getIdAlumno();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idMateria = rs.getInt("idMateria");
                idmaterias.add(idMateria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!idmaterias.isEmpty()) {
                for (Integer idmateria : idmaterias) {
                    String sql2 = "SELECT * FROM materia WHERE idMateria=?";
                    ps = con.prepareStatement(sql2);
                    ps.setInt(1, idmateria);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        materia = new Materia();
                        materia.setAñomateria(rs.getInt("año"));
                        materia.setNombre(rs.getString("nombre"));
                        materia.setActivo(rs.getBoolean("estado"));
                    }
                    if (rs.getInt("idMateria") != 0) {
                        materia.setIdMateria(rs.getInt("idMateria"));
                    }
                    materias.add(materia);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }

    // materia.data
    public static ArrayList<Materia> listadoMateriasNoInscriptas(ArrayList<Materia> materias) {
        ArrayList<Materia> materiasNoInscriptas = new ArrayList<>();
        for (Materia materia : MateriaData.listaTodasMaterias()) {
            boolean bandera = false;
            for (Materia mate : materias) {
                if (materia.getIdMateria() == mate.getIdMateria()) {
                    bandera = true;
                    break;
                }
            }
            if (bandera == false) {
                materiasNoInscriptas.add(materia);
            }
        }
        return materiasNoInscriptas;
    }
    
}
