/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoADatos;

import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kanko
 */
public class MateriaData {

    public static void eliminarMateria(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getConexion();
            String sql = "UPDATE materia SET estado=0 WHERE idMateria=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            sql="DELETE FROM inscripcion WHERE idMateria=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // inscripcion.data
    public static ArrayList<Materia> listaTodasMaterias() {
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Materia materia = null;
            con = Conexion.getConexion();
            String sql = "SELECT * FROM materia where estado=1";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setAñomateria(rs.getInt("año"));
                materia.setNombre(rs.getString("nombre"));
                materia.setActivo(rs.getBoolean("estado"));
                materias.add(materia);
            }
            return materias;
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }

    public static Materia buscarMateria(int codigo) {
        //funciona pero no setea los datos
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Materia materia = null;
        try {
            con = Conexion.getConexion();
            String sql = "SELECT * FROM materia where idMateria =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setAñomateria(rs.getInt("año"));
                materia.setNombre(rs.getString("nombre"));
                materia.setActivo(rs.getBoolean("estado"));
            }
            if (rs.getInt("idMateria") != 0) {
                materia.setIdMateria(rs.getInt("idMateria"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro materia", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
        } finally {
            // Aquí puedes realizar la liberación de recursos si es necesario
        }
        return materia; // Devuelve el objeto Alumno encontrado o null si no se encontró ninguno
    }

    public static void modificarMateria(Materia materia) {
        Connection con = null;
        PreparedStatement ps = null;
        int idmateria = materia.getIdMateria();
        try {
            con = Conexion.getConexion();
            String sql = "UPDATE materia SET nombre=?,año=?,estado=? WHERE idMateria =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAñomateria());
            ps.setBoolean(3, materia.isActivo());
            ps.setInt(4, idmateria);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cargaMateia(Materia materia) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexion.getConexion();
        String sql = "INSERT INTO materia(nombre,año,estado) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAñomateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(" Error " + ex.getMessage());
        }
    }

    static Materia materia(int idMateria) {
        Materia materia = null;
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = Conexion.getConexion();
            String sql2 = "SELECT * FROM materia WHERE idMateria=?";
            ps = con.prepareStatement(sql2);
            ps.setInt(1, idMateria);
            rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(idMateria);
                materia.setAñomateria(rs.getInt("año"));
                materia.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materia;
    }
    
}
