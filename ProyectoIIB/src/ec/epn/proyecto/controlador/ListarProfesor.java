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

import ec.epn.proyecto.modelo.Profesor;

/**
 * Servlet implementation class ListarProfesor
 */
@Transactional
@WebServlet("/ListarProfesor")
public class ListarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;  
	 /**
     * Constructor del Servlet Listar Profesor.
     * @see HttpServlet#HttpServlet()
     */
    public ListarProfesor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 *  Instanciamos un Query para poder leer objetos desde la base de datos.
		 */
		Query q= em.createQuery("select p from Profesor as p", Profesor.class);
		/**
		 * Hacemos un mapeo de la consulta usando una lista.
		 */
		List<Profesor> profesor=q.getResultList();
		/**
		 * Acontinuación la siguiente linea se utiliza para establecer 
		 * un atributo profesor para una solicitud en el servlet.
		 */
		request.setAttribute("profesor", profesor);
		/**
		 * Hacemos un direccionamiento a una jsp listar profesores, 
		 * para revisar todos los profesores registrados.
		 */
		request.getRequestDispatcher("listarProfesor.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
