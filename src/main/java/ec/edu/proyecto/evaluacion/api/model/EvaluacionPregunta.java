/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.proyecto.evaluacion.api.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "pro_evaluacionPregunta")
public class EvaluacionPregunta implements Serializable{
   @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    @Column(name="evapre_codigo")
    private int codigo;
    @Column(name="evapre_estado")
    private int estado;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fkPregunta")
    private Pregunta fkPregunta;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fkEvaluacion")
    private Evaluaciones fkEvaluacion;
    
    @Transient
    private String respuesta;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public EvaluacionPregunta(int codigo, int estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public EvaluacionPregunta() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Pregunta getFkPregunta() {
        return fkPregunta;
    }

    public void setFkPregunta(Pregunta fkPregunta) {
        this.fkPregunta = fkPregunta;
    }

    public Evaluaciones getFkEvaluacion() {
        return fkEvaluacion;
    }

    public void setFkEvaluacion(Evaluaciones fkEvaluacion) {
        this.fkEvaluacion = fkEvaluacion;
    }

    @Override
    public String toString() {
        return "EvaluacionPregunta{" + "codigo=" + codigo + ", estado=" + estado + ", fkPregunta=" + fkPregunta + ", fkEvaluacion=" + fkEvaluacion + '}';
    }

    

   

    
    

    

   
    
    
    
}
