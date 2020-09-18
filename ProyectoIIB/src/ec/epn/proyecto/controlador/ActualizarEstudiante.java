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
 * Implementacion del Servlet ActualizarEstudiante
 */
@Transactional
@WebServlet("/ActualizarEstudiante")
public class ActualizarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
    /**
     * Constructor del Servlet Actualizar Estudiante.
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Instanciamos una vairable id, para obtener la id del estudiante el cual vamos a actualizar sus datos.
		 */
		String id= request.getParameter("id");
		/**
		 * Hacemos una busqueda del id en la base para obtener los datos relacionados con dicho id.
		 */
		Estudiante e = em.find(Estudiante.class, new Integer(id));
		/**
		 * Instanciamos variables para obtener los datos que espera el servlet.
		 */
		String nombre = (String) request.getParameter("nombre");
		String apellido = (String)request.getParameter("apellido");
		String telefono = (String)request.getParameter("telefono");
		String correo = (String)request.getParameter("correo");
		/**
		 * Si los campos de la actulización del estudiante fueron llenados
		 * podremos guardar esos datos en nuestra base de datos.
		 */
		e.setNombre(nombre);
		e.setApellido(apellido);
		e.setTelefono(telefono);
		e.setCorreo(correo);
		
		/**
		 * Con ayuda del persist podemos insertar los registros actualizados 
		 * de los estudiantes en la base de datos.
		 */
		em.persist(e);
		
		/**
		 * Hacemos un direccionamiento a una jsp una vez que la 
		 * actualización de datos fue completado con exito.
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
