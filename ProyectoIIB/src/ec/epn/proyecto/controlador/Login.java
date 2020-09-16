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
/**
 * Servlet implementation class Login
 */
@Transactional
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modo = request.getParameter("Modalidad");
		switch (modo) {
			case "Estudiante":
				Query q= em.createQuery("select e from Estudiante as e", Estudiante.class);
				List<Estudiante> Estudiante=q.getResultList();
				request.setAttribute("estudiante", Estudiante);
				break;
			case "Profesor":
				Query q1= em.createQuery("select p from Profesor as p", Profesor.class);
				List<Profesor> Profesor=q1.getResultList();
				request.setAttribute("estudiante", Profesor);
				break;
			case "Administrador":
				Query q2= em.createQuery("select a from Administrador as a", Administrador.class);
				List<Profesor> Administrador=q2.getResultList();
				request.setAttribute("estudiante", Administrador);
				break;
			default:
				break;
		}

		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
