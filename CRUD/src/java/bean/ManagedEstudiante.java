/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Estudiante;
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
public class ManagedEstudiante {
    
    private List<Estudiante> listaEstudiante;
    private EstudianteModel estudianteModel;
    private Estudiante estudiante;
    String mensaje = "";
    
    public List<Estudiante> getListaEstudiante() throws Exception {
        try {
            this.estudianteModel = new EstudianteModel();
            this.listaEstudiante = this.estudianteModel.listarEstudiante();
        } catch (Exception e) {
            throw e;
        }
        return listaEstudiante;
    }
    
    public void setListaEstudiante(List<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }
    
    public EstudianteModel getEstudianteModel() {
        return estudianteModel;
    }
    
    public void setEstudianteModel(EstudianteModel estudianteModel) {
        this.estudianteModel = estudianteModel;
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    @PostConstruct
    public void init() {
        this.estudiante = new Estudiante();
    }
    
    public void guardarEstudiante() {
        try {
            estudianteModel = new EstudianteModel();
            estudianteModel.insertarEstudiante(estudiante);
            estudiante = new Estudiante();
            mensaje = "¡Estudiante almacenado con exito!";
        } catch (Exception e) {
              System.out.println(e.getMessage());
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }
}
