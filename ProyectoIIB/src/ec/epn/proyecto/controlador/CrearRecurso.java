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

import ec.epn.proyecto.modelo.Recurso;
import javafx.scene.control.Tab;

/**
 * Servlet implementation class CrearRecurso
 */
@Transactional
@WebServlet("/CrearRecurso")
public class CrearRecurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearRecurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");
		String link = request.getParameter("link");


		if (nombre.equals("") || tipo.equals("")) {
			request.setAttribute("valNombre", nombre);
			request.setAttribute("valTipo", tipo);
			request.setAttribute("valLink", link);
			request.setAttribute("valError", "meta bien los datos");

			request.getRequestDispatcher("crearRecurso.jsp").forward(request, response);
		} else {
			Recurso t = new Recurso();
			t.setNombre(nombre);
			t.setTipo(tipo);
			t.setLink(link);
			em.persist(t);
			
			request.getRequestDispatcher("ListarRecurso").forward(request, response);
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
