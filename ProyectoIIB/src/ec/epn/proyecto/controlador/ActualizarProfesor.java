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
 * Servlet implementation class ActualizarProfesor
 */
@Transactional
@WebServlet("/ActualizarProfesor")
public class ActualizarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		Profesor p = em.find(Profesor.class, new Integer(id));
		
		String nombre = (String) request.getParameter("nombre");
		String apellido = (String)request.getParameter("apellido");
		String telefono = (String)request.getParameter("telefono");
		String correo = (String)request.getParameter("correo");
		
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setTelefono(telefono);
		p.setCorreo(correo);
		
		em.persist(p);
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
