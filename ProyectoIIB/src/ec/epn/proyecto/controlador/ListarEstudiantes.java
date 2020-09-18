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

import ec.epn.proyecto.modelo.Estudiante;

/**
 * Implementacion del Servlet ListarEstudiantes
 */
@Transactional
@WebServlet("/ListarEstudiantes")
public class ListarEstudiantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuaci�n se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los par�metros de configuraci�n de la conexi�n con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;
    /**
     * Constructor del Servlet Listar Estudiante.
     * @see HttpServlet#HttpServlet()
     */
    public ListarEstudiantes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 *  Instanciamos un Query para poder leer objetos desde la base de datos.
		 */
		Query q= em.createQuery("select e from Estudiante as e", Estudiante.class);
		/**
		 * Hacemos un mapeo de la consulta usando una lista.
		 */
		List<Estudiante> estudiante=q.getResultList();
		/**
		 * Acontinuaci�n la siguiente linea se utiliza para establecer 
		 * un atributo estudiante para una solicitud en el servlet.
		 */
		request.setAttribute("estudiante", estudiante);
		/**
		 * Hacemos un direccionamiento a una jsp listar estudiantes, 
		 * para revisar todos los estudiantes registrados.
		 */
		request.getRequestDispatcher("listarEstudiantes.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
