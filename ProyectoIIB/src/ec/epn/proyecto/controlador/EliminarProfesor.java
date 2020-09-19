package ec.epn.proyecto.controlador;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import ec.epn.proyecto.modelo.Profesor;

/**
 * Servlet implementation class EliminarEstudiante
 */
@Transactional
@WebServlet("/EliminarProfesor")
public class EliminarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
	 /**
     * Constructor del Servlet Eliminar Profesor.
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProfesor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Instanciamos una variable id, para obtener la id del profesor el cual vamos a eliminar sus datos.
		 */
		String idStr= request.getParameter("id");
		/**
		 * Hacemos una busqueda del id en la base para obtener los datos relacionados con dicho id.
		 */
		Profesor p = em.find(Profesor.class, new Integer(idStr));		
		/**
		 * Con ayuda del revome podemos eliminar los registros  
		 * de algun estudiante seleccionado en la base de datos.
		 */
			em.remove(p);
			/**
			 * Con ayuda del revome podemos eliminar los registros  
			 * de algun estudiante seleccionado en la base de datos.
			 */
		request.getRequestDispatcher("ListarProfesor").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
