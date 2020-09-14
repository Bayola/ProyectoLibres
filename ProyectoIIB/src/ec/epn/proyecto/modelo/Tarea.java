package ec.epn.proyecto.modelo;

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
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getEntrega() {
			return entrega;
		}
		public void setEntrega(String entrega) {
			this.entrega = entrega;
		}
		public Integer getCalificacion() {
			return calificacion;
		}
		public void setCalificacion(Integer calificacion) {
			this.calificacion = calificacion;
		}
		public Boolean getEntregado() {
			return entregado;
		}
		public void setEntregado(Boolean entregado) {
			this.entregado = entregado;
		}
		
		
			

		
		
	}
	