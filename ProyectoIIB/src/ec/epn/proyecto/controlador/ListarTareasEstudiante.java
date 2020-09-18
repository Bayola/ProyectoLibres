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
 * Implementacion de la Servlet class ListarTareasEstudiante
 * @version 1.0, 14/09/2020
 * @author Gabby
 * 
 */
@Transactional
@WebServlet("/ListarTareasEstudiante")
public class ListarTareasEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los par�metros de configuraci�n de la conexi�n con la base de datos
	 * Notese que se ha reutilizado el proyecto de administracion de libros
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTareasEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * Se define el m�todo get para que se permita obtener los datos de la servlet EditarTareaEstudiante cuyo id y dem�s datos se reciben como par�metros
	 * editarlos y enviarlos hacia la base de datos, posteriromente de redirige hacia la Servlet ListarTareasEstudiante.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Se define el m�todo get para que se permita obtener los datos de la servlet EditarTareaEstudiante cuyo id y dem�s datos se reciben como par�metros
		 * editarlos y enviarlos hacia la base de datos, posteriromente de redirige hacia la Servlet ListarTareasEstudiante.
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */	
		Query q= em.createQuery("select t from Tarea as t", Tarea.class);
		List<Tarea> tareas=q.getResultList();
		
		request.setAttribute("tareas", tareas);
		request.getRequestDispatcher("listarTareasEstudiante.jsp").forward(request, response);
		
	}

	/**
	 * Se define el m�todo post referenciando al m�todo Get, lo que en otras palabras significa que realizan lo mismo los dos m�todos.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
