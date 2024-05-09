/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Entrega implements Serializable {
    @Id
    private String codigo;
    @Basic
    private String fecha;
    private String observacion;
    
    @OneToOne
    @JoinColumn(name = "empleado_codigo")
    private Empleado empleado;
    
    @OneToOne
    @JoinColumn(name = "paquete_idpaq")
    private Paquete paquete;

    public Entrega() {
    }

    public Entrega(String codigo, String fecha, String observacion, Empleado empleado, Paquete paquete) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.observacion = observacion;
        this.empleado = empleado;
        this.paquete = paquete;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "Entrega{" + "codigo=" + codigo + ", fecha=" + fecha + ", observacion=" + observacion + ", empleado=" + empleado + ", paquete=" + paquete + '}';
    }
    
    
}
