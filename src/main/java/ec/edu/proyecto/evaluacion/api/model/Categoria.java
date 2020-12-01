/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.proyecto.evaluacion.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "pro_categoria")
public class Categoria implements Serializable{
    
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @TableGenerator(name="TABLE_GEN", table="secuenciales", pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT", pkColumnValue="categoria")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
    @Column(name="cate_codigo")
    private int codigo;
    @Column(name="cate_descripcion")
    private String descripcion;
    @Column(name="cate_estado")
    private int estado;
    
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkCategoria")
    private List<Pregunta> listaPregunta=new ArrayList<>();

    public Categoria(int codigo, String descripcion, int estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Categoria() {
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Pregunta> getListaPregunta() {
        return listaPregunta;
    }

    public void setListaPregunta(List<Pregunta> listaPregunta) {
        this.listaPregunta = listaPregunta;
    }

    @Override
    public String toString() {
        return "Categoria{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado + ", listaPregunta=" + listaPregunta + '}';
    }
    

    
    
    
}
