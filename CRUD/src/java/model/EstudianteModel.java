/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author J Cardoza
 */
public class EstudianteModel extends Conexion {

    public void insertarEstudiante(Estudiante estudiante) throws Exception {
        try {
            conectar();
            String query = "insert into estudiante (nombre,apellido,direccion,carrera) values (?,?,?,?)";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            stm.setString(1, estudiante.getNombre());
            stm.setString(2, estudiante.getApellido());
            stm.setString(3, estudiante.getDireccion());
            stm.setString(4, estudiante.getCarrera());
            stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            desconectar();
        }
    }
    
        public void actualizarEstudiante(Estudiante estudiante) throws Exception {
        try {
            conectar();
            String query = "update estudiante set nombre=?, apellido=?, direccion=?, carrera=? where id_estudiante=?";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            stm.setString(1, estudiante.getNombre());
            stm.setString(2, estudiante.getApellido());
            stm.setString(3, estudiante.getDireccion());
            stm.setString(4, estudiante.getCarrera());
            stm.setInt(5, estudiante.getId());
            stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            desconectar();
        }
    }

    public ArrayList<Estudiante> listarEstudiante() throws Exception {
        ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
        try {
            String query = "Select * from estudiante";
            conectar();
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            ResultSet rt = smt.executeQuery();
            while (rt.next()) {
                Estudiante estudiante = new Estudiante();
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
}
