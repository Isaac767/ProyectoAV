/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author User
 */
@Entity
public class Repartidor extends Empleado implements Serializable {
    @Basic
    private int zona;

    public Repartidor() {
    }

    public Repartidor(int zona, String ciudad, String cedula, String apellidos, String nombres, String mail) {
        super(ciudad, cedula, apellidos, nombres, mail);
        this.zona = zona;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Repartidor{" + "zona=" + zona + '}';
    }
    
}
