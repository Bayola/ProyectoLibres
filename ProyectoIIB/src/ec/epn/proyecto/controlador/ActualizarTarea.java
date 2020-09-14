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

import ec.epn.proyecto.modelo.Tarea;

/**
 * Servlet implementation class ActualizarTarea
 */
@Transactional
@WebServlet("/ActualizarTarea")
public class ActualizarTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarTarea() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr= request.getParameter("id");
		Tarea t= em.find(Tarea.class, new Integer(request.getParameter("id")));
		
		String titulo = (String) request.getParameter("titulo");
		String descripcion = (String)request.getParameter("descripcion");
		String calificacion = (String) request.getParameter("calificacion");
		String entrega = (String) request.getParameter("entrega");

		if(entrega.equals("no entregado")) {
			t.setTitulo(titulo);
			t.setDescripcion(descripcion);
			t.setCalificacion(new Integer(calificacion));
			t.setEntregado(false);
			t.setEntrega(entrega);
			request.getRequestDispatcher("ListarTareas").forward(request, response);
		}else {
		t.setTitulo(titulo);
		t.setDescripcion(descripcion);
		t.setCalificacion(new Integer(calificacion));
		t.setEntregado(true);
		t.setEntrega(entrega);
		
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
