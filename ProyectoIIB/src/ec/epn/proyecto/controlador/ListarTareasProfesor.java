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
 *  Implementacion de la Servlet class ListarTareasProfesor
 *  @version 1.0, 14/09/2020
 * @author Gabby
 * 
 */
@Transactional
@WebServlet("/ListarTareasProfesor")
public class ListarTareasProfesor extends HttpServlet {
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
    public ListarTareasProfesor() {
        super();
    }

    /**
	 * Se define el método get para que se permita obtener los datos de la servlet EditarTareaEstudiante cuyo id y demás datos se reciben como parámetros
	 * editarlos y enviarlos hacia la base de datos, posteriromente de redirige hacia la Servlet ListarTareasEstudiante.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Se realiza la consulta de todos los valores de la base de datos de tarea
		 * Se guardan los datos recibidos en una lista de objetos de tipo tarea
		 * */
		 Query q= em.createQuery("select t from Tarea as t", Tarea.class);
		List<Tarea> tareas=q.getResultList();
		/**
		 * Se envían los elementos de la lista guardada, como atributos hacia el jsp listarTareasProfesor
		 * Se redirecciona hacia la jsp para visualizar la información en una tabla
		 * */
		request.setAttribute("tareas", tareas);
		request.getRequestDispatcher("listarTareasProfesor.jsp").forward(request, response);
		
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
