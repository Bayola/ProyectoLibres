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
import ec.epn.proyecto.modelo.Tarea;

/**
 * Implementacion del Servlet EditarEstudiante
 */
@Transactional
@WebServlet("/EditarEstudiante")
public class EditarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
    /**
     * Constructor del Servlet Editar Estudiante.
     * @see HttpServlet#HttpServlet()
     */
    public EditarEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Instanciamos una vairable id, para obtener la id del estudiante el cual vamos a editar sus datos.
		 */
		String idStr= request.getParameter("id");
		/**
		 * Hacemos una busqueda del id en la base para obtener los datos relacionados con dicho id.
		 */
		Estudiante e= em.find(Estudiante.class, new Integer(idStr));
		/**
		 * Instanciamos variables para obtener los datos que espera el servlet.
		 */
		request.setAttribute("valId", idStr);
		request.setAttribute("valNombre", e.getNombre());
		request.setAttribute("valApellido", e.getApellido());
		request.setAttribute("valTelefono", e.getTelefono());
		request.setAttribute("valCorreo", e.getCorreo());
		/**
		 * Con ayuda del persist podemos insertar los registros actualizados 
		 * de los estudiantes en la base de datos.
		 */
		em.persist(e);
		/**
		 * Hacemos un direccionamiento a una jsp una vez que la 
		 * edicion de datos fue completado con exito.
		 */
		request.getRequestDispatcher("editarEstudiante.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
