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

import ec.epn.proyecto.modelo.Tarea;

/**
 * Servlet implementation class tareasEstudiante
 */
@Transactional
@WebServlet("/EditarTareaEstudiante")
public class EditarTareaEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarTareaEstudiante() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr= request.getParameter("id");
		Tarea t= em.find(Tarea.class, new Integer(idStr));
		
		request.setAttribute("valId", idStr);
		request.setAttribute("valTitulo", t.getTitulo());
		request.setAttribute("valDescripcion", t.getDescripcion());
		request.setAttribute("valEntrega", t.getEntrega());
		request.setAttribute("valEntregado", t.getEntregado());
		request.setAttribute("valCalificacion", t.getCalificacion());
		
		em.persist(t);
		request.getRequestDispatcher("editarTareaEstudiante.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
