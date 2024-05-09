/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class Cliente extends Persona implements Serializable {
    @Basic
    private String celular;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private ArrayList<Direccion> direcciones;
    
    public void HacerActual() {
    }

    public Cliente() {
    }

    public Cliente(String celular, ArrayList<Direccion> direcciones, String cedula, String apellidos, String nombres, String mail) {
        super(cedula, apellidos, nombres, mail);
        this.celular = celular;
        this.direcciones = direcciones;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "Cliente{" + "celular=" + celular + ", direcciones=" + direcciones + '}';
    }
    
}