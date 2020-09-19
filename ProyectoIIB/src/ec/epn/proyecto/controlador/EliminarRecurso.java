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

import ec.epn.proyecto.modelo.Recurso;

/**
 * Servlet implementation class EliminarTarea
 */
@Transactional
@WebServlet("/EliminarRecurso")
public class EliminarRecurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;

    /**
     * Constructor del Servlet Eliminar Recurso.
     * @see HttpServlet#HttpServlet()
     */
    public EliminarRecurso() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Instanciamos una vairable id, para obtener la id del estudiante el cual vamos a eliminar sus datos.
		 */
		String idStr= request.getParameter("id");
		/**
		 * Instanciamos una vairable id, para obtener la id del recurso el cual vamos a eliminar sus datos.
		 */
		Recurso t= em.find(Recurso.class, new Integer(idStr));
		/**
		 * Con ayuda del revome podemos eliminar los registros  
		 * de algun recurso seleccionado en la base de datos.
		 */
			em.remove(t);
			/**
			 * Hacemos un direccionamiento a un servlet ListarRecurso una vez que la 
			 * eliminación de datos fue completado con exito.
			 */
		request.getRequestDispatcher("ListarRecurso").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
