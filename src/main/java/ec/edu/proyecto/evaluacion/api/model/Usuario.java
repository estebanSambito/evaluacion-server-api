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
import javax.persistence.Transient;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "pro_usuario")
public class Usuario implements Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="usu_codigo")
	    private int codigo;
	    @Column(name="usu_nombre")
	    private String nombre;
	    @Column(name="usu_apellido")
	    private String apellido;
	    @Column(name="usu_cedula")
	    private int cedula;
	    @Column(name="usu_nombreUsuario")
	    private String nombreUsuario;
	    @Column(name="usu_clave")
	    private String clave;
	    @Column(name="usu_estado")
	    private int estado;
	    @Column(name="usu_rol") //Roles son: admin, y otros son estudiante
	    private String rol;
	    
	    @Transient
	    private String token;
	    
	    @Transient
	    private boolean autenticado;
	    
	    
	    public Usuario() {
	    }

	    public boolean isAutenticado() {
	        return autenticado;
	    }

	    public void setAutenticado(boolean autenticado) {
	        this.autenticado = autenticado;
	    }

	    public String getRol() {
	        return rol;
	    }

	    public void setRol(String rol) {
	        this.rol = rol;
	    }
	    
	    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkUsuario")
	    private List<UsuarioEvaluacion> listaUsuarioEvaluacion=new ArrayList<>();

	    public Usuario(int codigo, String nombre, String apellido, int cedula, String nombreUsuario, String clave, int estado, String rol, boolean autenticado) {
	        this.codigo = codigo;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.cedula = cedula;
	        this.nombreUsuario = nombreUsuario;
	        this.clave = clave;
	        this.estado = estado;
	        this.rol = rol;
	        this.autenticado = autenticado;
	    }


	    public int getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(int codigo) {
	        this.codigo = codigo;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public int getCedula() {
	        return cedula;
	    }

	    public void setCedula(int cedula) {
	        this.cedula = cedula;
	    }

	    public String getNombreUsuario() {
	        return nombreUsuario;
	    }

	    public void setNombreUsuario(String nombreUsuario) {
	        this.nombreUsuario = nombreUsuario;
	    }

	    public String getClave() {
	        return clave;
	    }

	    public void setClave(String clave) {
	        this.clave = clave;
	    }

	    public int getEstado() {
	        return estado;
	    }

	    public void setEstado(int estado) {
	        this.estado = estado;
	    }

	    public List<UsuarioEvaluacion> getListaUsuarioEvaluacion() {
	        return listaUsuarioEvaluacion;
	    }

	    public void setListaUsuarioEvaluacion(List<UsuarioEvaluacion> listaUsuarioEvaluacion) {
	        this.listaUsuarioEvaluacion = listaUsuarioEvaluacion;
	    }

	    @Override
	    public String toString() {
	        return "Usuario{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave + ", estado=" + estado + ", rol=" + rol + ", autenticado=" + autenticado + ", listaUsuarioEvaluacion=" + listaUsuarioEvaluacion + '}';
	    }

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

	    

}
