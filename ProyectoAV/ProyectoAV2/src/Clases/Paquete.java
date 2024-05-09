/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Paquete implements Serializable {
    @Id
    private int idpaq;
    @Basic
    private String codigo;
    private String descripcion;
    private int peso;
    private int alto;
    
    @OneToOne(mappedBy = "paquete")
    private Entrega entrega;
    
    @OneToMany(mappedBy = "paquete")
    private List<String> estados;;

    public Paquete() {
    }

    public Paquete(int idpaq, String codigo, String descripcion, int peso, int alto, Entrega entrega, List<String> estados) {
        this.idpaq = idpaq;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.alto = alto;
        this.entrega = entrega;
        this.estados = estados;
    }

    

    public int getIdpaq() {
        return idpaq;
    }

    public void setIdpaq(int idpaq) {
        this.idpaq = idpaq;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public List<String> getEstados() {
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    @Override
    public String toString() {
        return "Paquete{" + "idpaq=" + idpaq + ", codigo=" + codigo + ", descripcion=" + descripcion + ", peso=" + peso + ", alto=" + alto + ", entrega=" + entrega + ", estados=" + estados + '}';
    }

    

    
    
}
    
    

