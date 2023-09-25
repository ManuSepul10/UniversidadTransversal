/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoADatos;

import entidades.Alumno;
import entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kanko
 */
public class AlumnoData {

    public static ArrayList<Alumno> listarAlumno() {
        ArrayList<Alumno> alu = new ArrayList();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Alumno alumno = null;
            con = Conexion.getConexion();
            String sql = "SELECT * FROM alumno";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setActivo(rs.getBoolean("estado"));
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                if (fechaNacimiento != null) {
                    LocalDate var = fechaNacimiento.toLocalDate();
                    alumno.setFechaNacimiento(var);
                }
                alu.add(alumno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de consulta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return alu;
    }

    public static void modificarAlumno(Alumno alumno) {
        Connection con = null;
        PreparedStatement ps = null;
        con = Conexion.getConexion();
        try {
            String sql = "UPDATE alumno SET dni=?,apellido=?,nombre=?,fechaNacimiento=?,estado=? WHERE idAlumno=" + alumno.getIdAlumno();
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void borrarAlumno(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getConexion();
            String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno=?";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Alumno buscarAlumno(int dni) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Alumno alumno = null;
        try {
            con = Conexion.getConexion();
            String sql = "SELECT dni, nombre, apellido, estado, fechaNacimiento, idAlumno FROM alumno WHERE dni=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setActivo(rs.getBoolean("estado"));
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                if (fechaNacimiento != null) {
                    LocalDate fechaNacimientoLocal = fechaNacimiento.toLocalDate();
                    alumno.setFechaNacimiento(fechaNacimientoLocal);
                }
                int idAlumno = rs.getInt("idAlumno");
                if (idAlumno != 0) {
                    alumno.setIdAlumno(idAlumno);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ningun alumno con el DNI proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }

    public static ArrayList<Alumno> buscarAlumnosPorMateria(Materia materia) {
        ArrayList<Alumno> alumnosInscritos = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexion.getConexion();
        String sql = "SELECT a.* FROM alumno a INNER JOIN inscripcion i ON a.idAlumno = i.idAlumno WHERE i.idMateria = ?";
        int idMateria = materia.getIdMateria();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                // Completa aquí el código para obtener otros atributos del alumno, si es necesario
                alumnosInscritos.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar conexiones y liberar recursos aquí
            // Cerrar rs, ps y con
        }
        return alumnosInscritos;
    }

    public static void cargaAlumnos(Alumno persona) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexion.getConexion();
        String sql = "INSERT INTO alumno( dni, apellido, nombre, fechaNacimiento, estado) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, persona.getDni());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getNombre());
            ps.setDate(4, Date.valueOf(persona.getFechaNacimiento()));
            ps.setBoolean(5, persona.isActivo());
            ps.executeUpdate();
            //            rs = ps.getGeneratedKeys();
            //            persona.setIdAlumno(rs.getInt("idAlumnos"));
        } catch (SQLException ex) {
            System.out.println(" Error de coneccion " + ex.getMessage());
        }
    }
    
}
