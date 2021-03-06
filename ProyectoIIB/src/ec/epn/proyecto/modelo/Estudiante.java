package ec.epn.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Definimos la clase Estudiante nos ayuda a manipular los datos 
 * en la base de datos, asi definimos esta clase como Entity
 * @author emi_m
 *
 */
@Entity
public class Estudiante {
	/**
	 * Definimos la variable Id como autoincrementable.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * Definimos las variables de las columnas que tiene la base de datos Estudiante.
	 */
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String cedula;
	@Column
	private String telefono;
	@Column
	private String correo;
	@Column
	private String password;
	
	/**
	 * Generamos los getters and setters para establecer o devolver el valor 
	 * de las variables definidas en la clase Estudiante
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
