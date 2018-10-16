package modelo;
// Generated 26-09-2018 15:18:05 by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Trabajador generated by hbm2java
 */
public class Trabajador  implements java.io.Serializable {


     private TrabajadorId id;
     private String telefono;
     private Date fechaContrato;
     private String cargo;
     private int idPersona;
     private int idEmpresa;
     private Empresa empresa;
     private Persona persona;

    public Trabajador() {
    }

    public Trabajador(String telefono, Date fechaContrato, String cargo, int idPersona, int idEmp) {
        this.telefono = telefono;
        this.fechaContrato = fechaContrato;
        this.cargo = cargo;
        this.idPersona = idPersona;
        this.idEmpresa = idEmp;
    }
   
    public TrabajadorId getId() {
        return this.id;
    }
    
    public void setId(TrabajadorId id) {
        this.id = id;
    }
    
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Date getFechaContrato() {
        return this.fechaContrato;
    }
    
    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public int getIdPersona(){
        return this.idPersona;
    }
    
    public void setIdPersona(int idPersona){
        this.idPersona = idPersona;
    }
    
    public Empresa getEmpresa(){
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }
    
    public Persona getPersona(){
        return this.persona;
    }
    
    public void setPersona(Persona persona){
        this.persona = persona;
    }
    
    public int getIdEmpresa(){
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(int idEmp){
        this.idEmpresa = idEmp;
    }
}


