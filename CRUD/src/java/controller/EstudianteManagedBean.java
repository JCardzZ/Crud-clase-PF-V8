/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EstudianteDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.jsp.tagext.TryCatchFinally;
import jdk.nashorn.internal.ir.TryNode;
import model.EntidadEstudiante;
import model.Estudiante;

/**
 *
 * @author J Cardoza
 */
@ManagedBean(name = "BEstudiante")
@ViewScoped
public class EstudianteManagedBean implements Serializable {

    /**
     * Creates a new instance of EstudinateManagedBean
     */
    private List<Estudiante> listaEstudiante;
    private Estudiante estudiante;
    String mensaje = "";

    public EstudianteManagedBean() {
        estudiante = new Estudiante();
    }

    public List<Estudiante> getListaEstudiante() {
        EstudianteDao eDao = new EstudianteDao();
        listaEstudiante = eDao.listarEstudiantes();
        return listaEstudiante;
    }

    public void setListaEstudiante(List<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void limpiarEstudiante() {
        estudiante = new Estudiante();
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void agregarEstudiante() {
        EstudianteDao eDao = new EstudianteDao();
        eDao.agregarEstudiante(estudiante);
        limpiarEstudiante();
    }
    
    public void modificarEstudiante() {
        EstudianteDao eDao = new EstudianteDao();
        eDao.actualizarEstudiante(estudiante);
        limpiarEstudiante();

    }

    public void eliminarEstudiante() {
        EstudianteDao eDao = new EstudianteDao();
        eDao.eliminarEstudinate(estudiante);
        limpiarEstudiante();
    }
     
}
