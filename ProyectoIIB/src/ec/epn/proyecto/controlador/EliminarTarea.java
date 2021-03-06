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
 *  Implementation de Servlet class EliminarTarea
 *  @version 1.0, 14/09/2020
 * @author Gabby
 * 
 */
@Transactional
@WebServlet("/EliminarTarea")
public class EliminarTarea extends HttpServlet {
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
    public EliminarTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Se define el m�todo get para que se permita eliminar los datos de la servlet anterior obtenidos como par�metros
	 * y eliminarlos por medio del id
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Se obtiene el parametro id, con el fin de realizar una busqueda por id en la base de datos
		 * especificamente en la tabla tarea
		 * */
		String idStr= request.getParameter("id");
		Tarea t= em.find(Tarea.class, new Integer(idStr));
		/**
		 * Se procede a eliminar el objeto tarea cuyo indice es el obtenido como parametro desde la servlet ListarTareasEstudiante
		 */
			em.remove(t);
			/**
			 * Se redirige hacia la Servlet ListarTareasProfesor
			 */
		request.getRequestDispatcher("ListarTareasProfesor").forward(request, response);
		
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
