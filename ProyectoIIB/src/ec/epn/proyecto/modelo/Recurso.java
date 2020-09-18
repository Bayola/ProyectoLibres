package ec.epn.proyecto.modelo;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Esta clase permite crear elementos de tipo tarea.
 * Cuyos campos son:  
 * Id, nombre, tipo, link
 * Siendo el id de tipo Integer autoincrementable
 * Los campos restantes son de tipo String
 * @version 1.0, 14/09/2020
 * @author Gabriela Talavera
 */
	@Entity
	public class Recurso {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column
		private String nombre;
		@Column
		private String tipo;
		@Column
		private String link;
		
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
		* Permite obtener el valor del campo Tipo
		* @param Tipo 
		*/
		public String getTipo() {
			return tipo;
		}
		/** 
		* Permite ingresar el valor del campo Tipo
		* @param Tipo 
		*/
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		/** 
		* Permite obtener el valor del campo Link
		* @param Link 
		*/
		public String getLink() {
			return link;
		}
		/** 
		* Permite ingresar el valor del campo Link
		* @param Link
		*/
		public void setLink(String link) {
			this.link = link;
		}
	

		
		
	}
	