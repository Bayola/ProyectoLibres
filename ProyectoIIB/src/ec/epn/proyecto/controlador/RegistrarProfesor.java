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
 * Servlet implementation class RegistrarEstudiante
 */
@Transactional
@WebServlet("/RegistrarProfesor")
public class RegistrarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 * Notese que se ha reutilizado el proyecto de administracion de libros
	 */

	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;

    /**
	 * Se define el método get para que se permita crear un nuevo registro enviando los datos de la jsp crearRecurso 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public RegistrarProfesor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Se obtienen los parametros ingresados en la jsp
		 * */	
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String cedula = request.getParameter("cedula");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		/**
		 * Se verifica que los valores anteriores no sean nulos, de ser el caso, se envia un mensaje de error
		 * */
		if (nombre.equals("") || apellido.equals("") || cedula.equals("") || telefono.equals("") || correo.equals("") || password.equals("")) {
			request.setAttribute("valNombre", nombre);
			request.setAttribute("valApellido", apellido);
			request.setAttribute("valCedula", cedula);
			request.setAttribute("valTelefono", telefono);
			request.setAttribute("valCorreo", correo);
			request.setAttribute("valPassword", password);
			request.setAttribute("valError", "Todos los campos son obligatorios");
			/**
			 * Se redirecciona hacia la jsp crearTarea con los datos ingresados previamente para que el usuario los pueda modificar
			 * */
			request.getRequestDispatcher("registroProfesor.jsp").forward(request, response);
		} else {
			
			Profesor p = new Profesor();
			p.setNombre(nombre);
			p.setApellido(apellido);
			p.setCedula(cedula);
			p.setTelefono(telefono);
			p.setCorreo(correo);
			p.setPassword(password);			
			/**
			 * Finalmente se realiza la persistencia de la tarea, haciendo constancia de la operacion en la base de datos
			 * Se envia la informacion por medio de atributos hacia la servlet 
			 */
			em.persist(p);
			
			request.getRequestDispatcher("registroEstudianteExitoso.jsp").forward(request, response);
		}
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
