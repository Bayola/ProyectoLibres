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

import ec.epn.proyecto.modelo.Administrador;
import ec.epn.proyecto.modelo.Estudiante;
import ec.epn.proyecto.modelo.Profesor;

import ec.epn.proyecto.modelo.Tarea;

/**
 * Implementacion del Servlet Login
 */
@Transactional
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;

	/**
	 * Constructor del Servlet Login.
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Imprimimos el datos que nos esta llegando de la variable de nombre tipo
		 */
		System.out.println(request.getParameter("tipo"));
		/**
		 * Instanciamos una variable modo que nos permitira recupera un parámetro de la request
		 */
		String modo = request.getParameter("tipo");
		
		/**
		 * Acontinuacion verificaremos que modalidad se ha selecciona, 
		 * para redireccionar las pantallas pertinentes de acuerdo a dicha modalidad.
		 */
		String cedula = request.getParameter("cedula");
		String password = request.getParameter("password");
		
		if(cedula.equals("") || password.equals("")) {
			request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
		}else {	
		if (modo.equals("Estudiante")) {
			request.getRequestDispatcher("cursos.jsp").forward(request, response);
		} if (modo.equals("Profesor")) {
			request.getRequestDispatcher("menuProfesor.jsp").forward(request, response);
		} if(modo.equals("Administrador")) {
			request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
		}
		
			request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
