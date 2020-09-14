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
import javafx.scene.control.Tab;

/**
 * Servlet implementation class CrearTarea
 */
@Transactional
@WebServlet("/CrearTarea")
public class CrearTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		

		if (titulo.equals("") || descripcion.equals("")) {
			request.setAttribute("valTitulo", titulo);
			request.setAttribute("valDescripcion", descripcion);
			request.setAttribute("valError", "meta bien los datos");

			request.getRequestDispatcher("crearTarea.jsp").forward(request, response);
		} else {
			Tarea t = new Tarea();
			t.setTitulo(titulo);
			t.setDescripcion(descripcion);
			t.setCalificacion(0);
			t.setEntregado(false);
			t.setEntrega(null);
			
			em.persist(t);
			
			request.getRequestDispatcher("ListarTareas").forward(request, response);
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
