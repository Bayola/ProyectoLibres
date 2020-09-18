package ec.epn.proyecto.controlador;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import ec.epn.proyecto.modelo.Tarea;

/**
 * Implementacion de la Servlet class ActualizarTareaEstudiante
 * @version 1.0, 14/09/2020
 * @author Gabby
 * 
 */
@Transactional
@WebServlet("/ActualizarTareaEstudiante")
public class ActualizarTareaEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 * Notese que se ha reutilizado el proyecto de administracion de libros
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarTareaEstudiante() {
        super();
    }

	/**
	 * Se define el método get para que se permita obtener los datos de la servlet EditarTareaEstudiante cuyo id y demás datos se reciben como parámetros
	 * editarlos y enviarlos hacia la base de datos, posteriromente de redirige hacia la Servlet ListarTareasEstudiante.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Se obtiene el parametro id, con el fin de realizar una busqueda por id en la base de datos
		 * especificamente en la tabla tarea
		 * */
		String id= request.getParameter("id");
		Tarea t = em.find(Tarea.class, new Integer(id));
		/**
		 * Se obtienen los valores de los parametros
		 */
		String titulo = (String) request.getParameter("titulo");
		String descripcion = (String)request.getParameter("descripcion");
		String entrega = (String)request.getParameter("entrega");
		
		/**
		 * Se verifica que si no se ha realizado entrega, se setean los datos hacia la base del campo entregado como false
		 * */
		if(entrega.equals("no entregado")) {
			t.setTitulo(titulo);
			t.setDescripcion(descripcion);
			t.setEntregado(false);
			t.setEntrega(entrega);
			//request.getRequestDispatcher("ListarTareasEstudiante").forward(request, response);
			/**
			 * Caso contrario, se setean los datos hacia la base del campo entregado como false
			 * */
		}else {
		t.setTitulo(titulo);
		t.setDescripcion(descripcion);
		t.setEntregado(true);
		t.setEntrega(entrega);
		}
		/**
		 * Finalmente se realiza la persistencia de los datos de la tarea, haciendo constancia de la operacion en la base de datos
		 * Se envia la informacion y se redirige hacia ListarTareasProfesor
		 */
		em.persist(t);
		request.getRequestDispatcher("ListarTareasEstudiante").forward(request, response);	
	}

	/**
	 * Se define el método post referenciando al método Get, lo que en otras palabras significa que realizan lo mismo los dos métodos.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
