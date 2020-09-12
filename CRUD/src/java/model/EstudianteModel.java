/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Estudiantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author J Cardoza
 */
public class EstudianteModel extends Conexion {

    public ArrayList<Estudiantes> listarEstudiante() throws Exception {
        ArrayList<Estudiantes> lista = new ArrayList<Estudiantes>();
        try {
            String query = "Select * from estudiantes";
            conectar();
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            ResultSet rt = smt.executeQuery();
            while (rt.next()) {
                Estudiantes estudiante = new Estudiantes();
                estudiante.setId(rt.getInt("id_estudiante"));
                estudiante.setNombre(rt.getString("nombre"));
                estudiante.setApellido(rt.getString("apellido"));
                estudiante.setDireccion(rt.getString("direccion"));
                estudiante.setCarrera(rt.getString("carrera"));

                lista.add(estudiante);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();

        }
        return lista;
    }

    public void insertarEstudiante(Estudiantes estudiante) throws Exception {
        try {
            conectar();
            String query = "insert into estudiantes (nombre,apellido,direccion,carrera) values (?,?,?,?)";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            stm.setString(1, estudiante.getNombre());
            stm.setString(2, estudiante.getApellido());
            stm.setString(3, estudiante.getDireccion());
            stm.setString(4, estudiante.getCarrera());
            stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }

    }

    public void actualizarEstudiante(Estudiantes estudiante) throws Exception {
        try {
            conectar();
            String query = "update estudiantes set nombre=?, apellido=?, direccion=?, carrera=? where id_estudiante=?";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            stm.setString(1, estudiante.getNombre());
            stm.setString(2, estudiante.getApellido());
            stm.setString(3, estudiante.getDireccion());
            stm.setString(4, estudiante.getCarrera());
            stm.setInt(5, estudiante.getId());
            stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarEstudiante(Estudiantes estudiante) throws Exception {
        try {

            String query = "Delete from estudiantes where id_estudiante =?";
            conectar();
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            stm.setInt(1, estudiante.getId());
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("error en eliminar estudiante: " + e.getMessage());
            throw e;
        } finally {
            desconectar();
        }
    }

}
