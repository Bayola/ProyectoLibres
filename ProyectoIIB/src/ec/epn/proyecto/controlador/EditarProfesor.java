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
 * Servlet implementation class EditarProfesor
 */
@Transactional
@WebServlet("/EditarProfesor")
public class EditarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;   
	  /**
     * Constructor del Servlet Editar Profesor.
     * @see HttpServlet#HttpServlet()
     */
    public EditarProfesor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Instanciamos una vairable id, para obtener la id del profesor el cual vamos a editar sus datos.
		 */
		String idStr= request.getParameter("id");
		/**
		 * Hacemos una busqueda del id en la base para obtener los datos relacionados con dicho id.
		 */
		Profesor p= em.find(Profesor.class, new Integer(idStr));
		/**
		 * Instanciamos variables para obtener los datos que espera el servlet.
		 */
		request.setAttribute("valId", idStr);
		request.setAttribute("valNombre", p.getNombre());
		request.setAttribute("valApellido", p.getApellido());
		request.setAttribute("valTelefono", p.getTelefono());
		request.setAttribute("valCorreo", p.getCorreo());
		/**
		 * Con ayuda del persist podemos insertar los registros actualizados 
		 * de los profesores en la base de datos.
		 */
		em.persist(p);
		/**
		 * Hacemos un direccionamiento a una jsp una vez que la 
		 * edicion de datos fue completado con exito.
		 */
		request.getRequestDispatcher("editarProfesor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
