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
 * Servlet implementation class ListarLibros
 */
@Transactional
@WebServlet("/ListarRecurso")
public class ListarRecurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * A continuación se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 */
	@PersistenceContext(unitName = "adminlibrosPU")
	private EntityManager em;

    /**
     * Constructor del Servlet Listar Recurso.
     * @see HttpServlet#HttpServlet()
     */
    public ListarRecurso() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 *  Instanciamos un Query para poder leer objetos desde la base de datos.
		 */
		Query q= em.createQuery("select t from Recurso as t", Recurso.class);
		/**
		 * Hacemos un mapeo de la consulta usando una lista.
		 */
		List<Recurso> recursos=q.getResultList();
		/**
		 * Acontinuación la siguiente linea se utiliza para establecer 
		 * un atributo recurso para una solicitud en el servlet.
		 */
		request.setAttribute("recursos", recursos);
		/**
		 * Hacemos un direccionamiento a una jsp listar recursos, 
		 * para revisar todos los recursos registrados.
		 */
		request.getRequestDispatcher("listarRecurso.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
