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
	 * Se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 * Notese que se ha reutilizado el proyecto de administracion de libros
	 */
    public CrearRecurso() {
        super();
    }

    /**
	 * Se define el método get para que se permita crear un nuevo registro enviando los datos de la jsp crearRecurso 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Se obtienen los parametros ingresados en la jsp
		 * */
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");
		String link = request.getParameter("link");
		/**
		 * Se verifica que los valores anteriores no sean nulos, de ser el caso, se envia un mensaje de error
		 * */

		if (nombre.equals("") || tipo.equals("")) {
			request.setAttribute("valNombre", nombre);
			request.setAttribute("valTipo", tipo);
			request.setAttribute("valLink", link);
			request.setAttribute("valError", "meta bien los datos");
			/**
			 * Se redirecciona hacia la jsp crearRecurso con los datos ingresados previamente para que el usuario los pueda modificar
			 * */
			request.getRequestDispatcher("crearRecurso.jsp").forward(request, response);
		} else {
			/**
			 * Crear un nuevo objeto de tipo recurso
			 * enviar los valores obtenidos y los valores requeridos para crear un nuevo recurso.
			 * */
			Recurso t = new Recurso();
			t.setNombre(nombre);
			t.setTipo(tipo);
			t.setLink(link);
			/**
			 * Finalmente se realiza la persistencia del recurso, haciendo constancia de la operacion en la base de datos
			 * Se envia la informacion por medio de atributos hacia la servlet
			 */
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
