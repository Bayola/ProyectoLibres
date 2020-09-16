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
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String cedula = request.getParameter("cedula");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		
		if (nombre.equals("") || apellido.equals("") || cedula.equals("") || telefono.equals("") || correo.equals("") || password.equals("")) {
			request.setAttribute("valNombre", nombre);
			request.setAttribute("valApellido", apellido);
			request.setAttribute("valCedula", cedula);
			request.setAttribute("valTelefono", telefono);
			request.setAttribute("valCorreo", correo);
			request.setAttribute("valPassword", password);
			request.setAttribute("valError", "Todos los campos son obligatorios");

			request.getRequestDispatcher("registroProfesor.jsp").forward(request, response);
		} else {
			
			Profesor p = new Profesor();
			p.setNombre(nombre);
			p.setApellido(apellido);
			p.setCedula(cedula);
			p.setTelefono(telefono);
			p.setCorreo(correo);
			p.setPassword(password);			
			
			em.persist(p);
			
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
