/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Estudiantes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.EstudianteModel;

/**
 *
 * @author J Cardoza
 */
@ManagedBean
@SessionScoped
public class EstudinateManagedBean implements Serializable {

    private List<Estudiantes> listaEstudiante;
    private EstudianteModel estudianteModel;
    private Estudiantes estudiante;
    String mensaje = "";

    
    public List<Estudiantes> getListaEstudiante() throws Exception {
        try {
            this.estudianteModel = new EstudianteModel();
            this.listaEstudiante = this.estudianteModel.listarEstudiante();
        } catch (Exception e) {
            throw e;
        }
        return listaEstudiante;
    }
    

    public void setListaEstudiante(List<Estudiantes> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    public EstudianteModel getEstudianteModel() {
        return estudianteModel;
    }

    public void setEstudianteModel(EstudianteModel estudianteModel) {
        this.estudianteModel = estudianteModel;
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }
   
    @PostConstruct
    public void init() {
        this.estudiante = new Estudiantes();
    }

    public void guardarEstudiante() {
        try {
            estudianteModel = new EstudianteModel();
            estudianteModel.insertarEstudiante(estudiante);
            estudiante = new Estudiantes();
            mensaje = "¡Estudiante almacenado con éxito!";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void cargarEstudiante(Estudiantes es) {
        this.estudiante = es;
    }

    public void editarEstudiante() {
        try {
            estudianteModel = new EstudianteModel();
            estudianteModel.actualizarEstudiante(estudiante);
            estudiante = new Estudiantes();
            mensaje = "¡Estudiante actualizado con éxito!";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void limpiarEstudinate() {
        estudiante = new Estudiantes();
    }

    public void eliminarEstudiantes(Estudiantes es) {
        try {
            estudianteModel = new EstudianteModel();
            estudianteModel.eliminarEstudiante(es);
            estudiante = new Estudiantes();
            mensaje = "¡Estudiante eliminado con éxito!";
        } catch (Exception e) {
            mensaje = "Error: " + e.getMessage();
            e.printStackTrace();
        }

        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);

    }
     
}
