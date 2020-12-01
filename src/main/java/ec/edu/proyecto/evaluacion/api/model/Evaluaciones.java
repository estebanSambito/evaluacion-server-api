/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.proyecto.evaluacion.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "pro_evaluacion")
public class Evaluaciones implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="eva_codigo")
    private int codigo;
    @Column(name="eva_descripcion")
    private String descripcion;
    @Column(name="eva_fechaEvaluacion")
    @Temporal(TemporalType.DATE)
    private Date fchaEvaluacion;
    @Column(name="cate_estado")
    private int estado;
   
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkEvaluacion")
    private List<EvaluacionPregunta> listaEvaluacionPregunta=new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkEvaluacion")
    private List<UsuarioEvaluacion> listaUsuarioEvaluacion=new ArrayList<>();

    public Evaluaciones(int codigo, String descripcion, Date fchaEvaluacion, int estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fchaEvaluacion = fchaEvaluacion;
        this.estado = estado;
    }

    public Evaluaciones() {
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

    public Date getFchaEvaluacion() {
        return fchaEvaluacion;
    }

    public void setFchaEvaluacion(Date fchaEvaluacion) {
        this.fchaEvaluacion = fchaEvaluacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<EvaluacionPregunta> getListaEvaluacionPregunta() {
        return listaEvaluacionPregunta;
    }

    public void setListaEvaluacionPregunta(List<EvaluacionPregunta> listaEvaluacionPregunta) {
        this.listaEvaluacionPregunta = listaEvaluacionPregunta;
    }

    public List<UsuarioEvaluacion> getListaUsuarioEvaluacion() {
        return listaUsuarioEvaluacion;
    }

    public void setListaUsuarioEvaluacion(List<UsuarioEvaluacion> listaUsuarioEvaluacion) {
        this.listaUsuarioEvaluacion = listaUsuarioEvaluacion;
    }

    @Override
    public String toString() {
        return "Evaluaciones{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", fchaEvaluacion=" + fchaEvaluacion + ", estado=" + estado + ", listaEvaluacionPregunta=" + listaEvaluacionPregunta + ", listaUsuarioEvaluacion=" + listaUsuarioEvaluacion + '}';
    }

   

    
    

    
    
    
    
    
    
}
