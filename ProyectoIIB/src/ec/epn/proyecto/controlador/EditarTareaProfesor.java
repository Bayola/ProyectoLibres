package ec.epn.proyecto.controlador;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import ec.epn.proyecto.modelo.Tarea;

/**
 * Servlet implementation class EliminarTarea
 */
@Transactional
@WebServlet("/EditarTareaProfesor")
public class EditarTareaProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarTareaProfesor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HzttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr= request.getParameter("id");
		Tarea t= em.find(Tarea.class, new Integer(idStr));
		//System.out.println("********************************************************"+t.getCalificacion());
		
		request.setAttribute("valId", idStr);
		request.setAttribute("valTitulo", t.getTitulo());
		request.setAttribute("valDescripcion", t.getDescripcion());
		request.setAttribute("valEntrega", t.getEntrega());
		request.setAttribute("valCalificacion", t.getCalificacion());
		request.getRequestDispatcher("editarTareaProfesor.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
