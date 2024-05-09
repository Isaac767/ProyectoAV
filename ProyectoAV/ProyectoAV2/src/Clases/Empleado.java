/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Empleado extends Persona implements Serializable{
    @Basic
    private String ciudad;

    public Empleado() {
    }

    public Empleado(String ciudad, String cedula, String apellidos, String nombres, String mail) {
        super(cedula, apellidos, nombres, mail);
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Empleado{" + "ciudad=" + ciudad + '}';
    }
    
    
}
