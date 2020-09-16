package ec.epn.proyecto.modelo;
/**
 * Esta clase permite crear elementos de tipo tarea.
 * Cuyos campos son:  
 * Id, titulo, descripcion, entrega, calificacion, entregado.
 * Siendo el id de tipo Integer autoincrementable
 * Los campos titulo, descripcion y entrega de tipo String
 * Los campos calificacion de tipo Integer y entregado de tipo Boolean
 * @version 1.0, 14/09/2020
 * @author Gabriela Talavera
 */
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	public class Tarea {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column
		private String titulo;
		@Column
		private String descripcion;
		@Column
		private String entrega;
		@Column
		private Integer calificacion;
		@Column
		private Boolean entregado;
		
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
		* Permite obtener el valor del campo titulo
		* @param Titulo 
		*/ 
		public String getTitulo() {
			return titulo;
		}
		/** 
		* Permite ingresar el valor del campo titulo
		* @param Titulo 
		*/ 
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		/** 
		* Permite obtener el valor del campo descripcion
		* @param Descripcion 
		*/ 
		public String getDescripcion() {
			return descripcion;
		}
		/** 
		* Permite ingresar el valor del campo descripcion
		* @param Descripcion 
		*/ 
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		/** 
		* Permite obtener el valor del campo entrega
		* @param Entrega 
		*/ 
		public String getEntrega() {
			return entrega;
		}
		/** 
		* Permite ingresar el valor del campo entrega
		* @param Entrega 
		*/
		public void setEntrega(String entrega) {
			this.entrega = entrega;
		}
		/** 
		* Permite obtener el valor del campo calificacion
		* @param Calificacion 
		*/
		public Integer getCalificacion() {
			return calificacion;
		}
		/** 
		* Permite ingresar el valor del campo calificacion
		* @param Calificacion 
		*/
		public void setCalificacion(Integer calificacion) {
			this.calificacion = calificacion;
		}
		/** 
		* Permite obtener el valor del campo entregado
		* @param Entregado 
		*/
		public Boolean getEntregado() {
			return entregado;
		}
		/** 
		* Permite ingresar el valor del campo entregado
		* @param Entregado 
		*/
		public void setEntregado(Boolean entregado) {
			this.entregado = entregado;
		}
		
		
	}
	