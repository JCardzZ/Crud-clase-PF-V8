/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.EntidadEstudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Estudiante;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Conexion;
import util.HibernateUtil;

/**
 *
 * @author J Cardoza
 */
public class EstudianteDao extends Conexion{

    /* METODO LISTAR JDBC
    public ArrayList<Estudiante> listarEstudiante() throws Exception {
        ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
        try {
            String query = "Select * from estudiantes";
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
     */
    
    /* METODO LISTAR CON HIBERNATE*/
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Estudiante";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;

    }

    /* METODO INSERTAR JDBC
    public void insertarEstudiante(Estudiante estudiante) throws Exception {
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
     */
    
    /* METODO INSERTAR HIBERNATE */
    public void agregarEstudiante(Estudiante estudiante) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(estudiante);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    /* METODO ACTUALIZAR JDBC 
    public void actualizarEstudiante(EntidadEstudiante estudiante) throws Exception {
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
     */
    
    /*METODO ACTUALIZAR HIBERNATE*/
    public void actualizarEstudiante(Estudiante estudiante) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(estudiante);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    /*METODO ELIMINAR JDBC
    public void eliminarEstudiante(EntidadEstudiante estudiante) throws Exception {
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
     */
    
    /*METODO ELIMINAR HIBERNATE*/
    public void eliminarEstudinate(Estudiante estudiante) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(estudiante);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();

            }
        }

    }
}
