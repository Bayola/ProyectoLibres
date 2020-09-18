package ec.epn.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Esta clase permite crear elementos de tipo tarea.
 * Cuyos campos son:  
 * Id, nombre, apellido, cedula, telefono, correo, password
 * Siendo el id de tipo Integer autoincrementable
 * Los campos restantes son de tipo String
 * @version 1.0, 14/09/2020
 * @author Gabriela Talavera
 */
@Entity
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
	* Permite obtener el valor del campo id
	* @param Id 
	*/ 
	public Integer getId() {
		return id;
	}
	/** 
	* Permite ingresar el valor del campo id
	* @param Id 
	*/
	public void setId(Integer id) {
		this.id = id;
	}
	/** 
	* Permite obtener el valor del campo nombre
	* @param Nombre 
	*/
	public String getNombre() {
		return nombre;
	}
	/** 
	* Permite ingresar el valor del campo nombre
	* @param Nombre 
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/** 
	* Permite obtener el valor del campo apellido
	* @param Apellido 
	*/
	public String getApellido() {
		return apellido;
	}	
	/** 
	* Permite ingresar el valor del campo apellido
	* @param Apellido 
	*/
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/** 
	* Permite obtener el valor del campo cedula
	* @param Cedula 
	*/
	public String getCedula() {
		return cedula;
	}
	/** 
	* Permite ingresar el valor del campo Cedula
	* @param Cedula 
	*/
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/** 
	* Permite obtener el valor del campo Telefono
	* @param Telefono
	*/
	public String getTelefono() {
		return telefono;
	}
	/** 
	* Permite ingresar el valor del campo Telefono
	* @param Telefono 
	*/
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/** 
	* Permite obtener el valor del campo Correo
	* @param Correo
	*/
	public String getCorreo() {
		return correo;
	}
	/** 
	* Permite ingresar el valor del campo Correo
	* @param Correo
	*/
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/** 
	* Permite obtener el valor del campo Password
	* @param Password
	*/
	public String getPassword() {
		return password;
	}
	/** 
	* Permite ingresar el valor del campo Password
	* @param Password 
	*/
	public void setPassword(String password) {
		this.password = password;
	}
}
