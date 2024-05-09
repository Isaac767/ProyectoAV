/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Estado implements Serializable {
    @Id
    private int id;
    @Basic
    private int tipo;
    private String estado;
    private Date fecha;
    private String observacion;
    
    @ManyToOne
    @JoinColumn(name = "paquete_idpaq")
    private Paquete paquete;

    public Estado() {
    }

    public Estado(int id, int tipo, String estado, Date fecha, String observacion, Paquete paquete) {
        this.id = id;
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
        this.observacion = observacion;
        this.paquete = paquete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", tipo=" + tipo + ", estado=" + estado + ", fecha=" + fecha + ", observacion=" + observacion + ", paquete=" + paquete + '}';
    }
       
}