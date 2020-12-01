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

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "pro_UsuarioEvaluacion")
public class UsuarioEvaluacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="usuEva_codigo")
    private int codigo;
    @Column(name="usuEva_resultado")
    private String resultado;
    @Column(name="usuEva_respuestas")
    private String respuestas;
    @Column(name="usuEva_estado")
    private String estado;
    @Column(name="usuEva_estadoRegistro")
    private int estadoRegistro;
    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fkEvaluacion")
    private Evaluaciones fkEvaluacion;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fkUsuario")
    private Usuario fkUsuario;
    

    public UsuarioEvaluacion(int codigo, String resultado, String respuestas, String estado, int estadoRegistro) {
        this.codigo = codigo;
        this.resultado = resultado;
        this.respuestas = respuestas;
        this.estado = estado;
        this.estadoRegistro = estadoRegistro;
    }

    public UsuarioEvaluacion() {
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Evaluaciones getFkEvaluacion() {
        return fkEvaluacion;
    }

    public void setFkEvaluacion(Evaluaciones fkEvaluacion) {
        this.fkEvaluacion = fkEvaluacion;
    }

    public Usuario getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuario fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioEvaluacion{" + "codigo=" + codigo + ", resultado=" + resultado + ", respuestas=" + respuestas + ", estado=" + estado + ", estadoRegistro=" + estadoRegistro + ", fkEvaluacion=" + fkEvaluacion + ", fkUsuario=" + fkUsuario + '}';
    }

    
    

    
    
    
    
}
