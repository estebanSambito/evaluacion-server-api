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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "pro_Pregunta")
public class Pregunta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="pre_codigo")
    private int codigo;
    @Column(name="pre_descripcion")
    private String descripcion;
    @Column(name="pre_estado")
    private int estado;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fkCategoria")
    private Categoria fkCategoria;
    
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkPregunta")
    private List<EvaluacionPregunta> listaEvaluacionPregunta=new ArrayList<>();

    public Pregunta() {
    }

    public Pregunta(int codigo, String descripcion, int estado, Categoria fkCategoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fkCategoria = fkCategoria;
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

    public Categoria getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(Categoria fkCategoria) {
        this.fkCategoria = fkCategoria;
    }

    public List<EvaluacionPregunta> getListaEvaluacionPregunta() {
        return listaEvaluacionPregunta;
    }

    public void setListaEvaluacionPregunta(List<EvaluacionPregunta> listaEvaluacionPregunta) {
        this.listaEvaluacionPregunta = listaEvaluacionPregunta;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado + ", fkCategoria=" + fkCategoria + ", listaEvaluacionPregunta=" + listaEvaluacionPregunta + '}';
    }

    
   
    

    
    
    
}
