package model;
// Generated 09-12-2020 01:10:32 PM by Hibernate Tools 4.3.1



/**
 * Estudiante generated by hbm2java
 */
public class Estudiante  implements java.io.Serializable {


     private Integer idEstudiante;
     private String nombre;
     private String apellido;
     private String direccion;
     private String carrera;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String direccion, String carrera) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.direccion = direccion;
       this.carrera = carrera;
    }
   
    public Integer getIdEstudiante() {
        return this.idEstudiante;
    }
    
    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }




}

