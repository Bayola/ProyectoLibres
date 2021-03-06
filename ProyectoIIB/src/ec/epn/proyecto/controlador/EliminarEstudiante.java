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

import ec.epn.proyecto.modelo.Estudiante;

/**
 * Implementacion del Servlet EliminarEstudiante
 */
@Transactional
@WebServlet("/EliminarEstudiante")
public class EliminarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
    /**
     * Constructor del Servlet Eliminar Estudiante.
     * @see HttpServlet#HttpServlet()
     */
    public EliminarEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Instanciamos una vairable id, para obtener la id del estudiante el cual vamos a eliminar sus datos.
		 */
		String idStr= request.getParameter("id");
		/**
		 * Hacemos una busqueda del id en la base para obtener los datos relacionados con dicho id.
		 */
		Estudiante e = em.find(Estudiante.class, new Integer(idStr));
		/**
		 * Con ayuda del revome podemos eliminar los registros  
		 * de algun estudiante seleccionado en la base de datos.
		 */
			em.remove(e);
			/**
			 * Hacemos un direccionamiento a un servlet ListarEstudiantes una vez que la 
			 * eliminación de datos fue completado con exito.
			 */
		request.getRequestDispatcher("ListarEstudiantes").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
