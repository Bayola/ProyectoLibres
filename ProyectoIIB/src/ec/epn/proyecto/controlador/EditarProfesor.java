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
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr= request.getParameter("id");
		Profesor p= em.find(Profesor.class, new Integer(idStr));
		
		request.setAttribute("valId", idStr);
		request.setAttribute("valNombre", p.getNombre());
		request.setAttribute("valApellido", p.getApellido());
		request.setAttribute("valTelefono", p.getTelefono());
		request.setAttribute("valCorreo", p.getCorreo());
		
		em.persist(p);
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
