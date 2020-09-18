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
 * Implementacion del Servlet RegistrarEstudiante
 */
@Transactional
@WebServlet("/RegistrarEstudiante")
public class RegistrarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;

    /**
     * Constructor del Servlet Registrar Estudiante.
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Instanciamos variables para obtener los datos que espera el servlet
		 */
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String cedula = request.getParameter("cedula");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		/**
		 * Verificamos si los campos en el registroEstudiantes.jsp fueron llenados, 
		 * caso contrario se notificará con un mensaje "Todos los campos son obligatorios".
		 */
		if (nombre.equals("") || apellido.equals("") || cedula.equals("") || telefono.equals("") || correo.equals("") || password.equals("")) {
			request.setAttribute("valNombre", nombre);
			request.setAttribute("valApellido", apellido);
			request.setAttribute("valCedula", cedula);
			request.setAttribute("valTelefono", telefono);
			request.setAttribute("valCorreo", correo);
			request.setAttribute("valPassword", password);
			request.setAttribute("valError", "Todos los campos son obligatorios");
			
			/**
			 * hacemos un direccionamiento al jsp de registro, para que se vuelva a llenar
			 * los campos.
			 */
			request.getRequestDispatcher("registroEstudiante.jsp").forward(request, response);
		} else {
			/**
			 * Si los campos en el registro del estudiante fueron llenados
			 * podremos guardar esos datos en la base de datos.
			 */
			Estudiante e = new Estudiante();
			e.setNombre(nombre);
			e.setApellido(apellido);
			e.setCedula(cedula);
			e.setTelefono(telefono);
			e.setCorreo(correo);
			e.setPassword(password);			
			
			/**
			 * Con ayuda del persist podemos insertar los registros de los
			 * estudiantes en la base de datos
			 */
			em.persist(e);
			
			/**
			 * Hacemos un direccionamiento a una jsp una vez que el 
			 * registro fue completado con exito
			 */
			request.getRequestDispatcher("registroEstudianteExitoso.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
