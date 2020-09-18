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
 * Implementación de Servlet class CrearTarea
 * @version 1.0, 14/09/2020
 * @author Gabby
 * 
 */
@Transactional
@WebServlet("/CrearTarea")
public class CrearTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Se indica el nombre de la unidad de persistencia en la que se 
	 * especifican los parámetros de configuración de la conexión con la base de datos
	 * Notese que se ha reutilizado el proyecto de administracion de libros
	 */
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
	 * Se define el método get para que se permita crear un nuevo registro enviando los datos de la jsp crearTarea 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Se obtienen los parametros ingresados en la jsp
		 * */		
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		/**
		 * Se verifica que los valores anteriores no sean nulos, de ser el caso, se envia un mensaje de error
		 * */		
		if (titulo.equals("") || descripcion.equals("")) {
			request.setAttribute("valTitulo", titulo);
			request.setAttribute("valDescripcion", descripcion);
			request.setAttribute("valError", "Ingrese datos correctos");
			/**
			 * Se redirecciona hacia la jsp crearTarea con los datos ingresados previamente para que el usuario los pueda modificar
			 * */
			request.getRequestDispatcher("crearTarea.jsp").forward(request, response);
		} else {
			/**
			 * Crear un nuevo objeto de tipo tarea
			 * enviar los valores obtenidos y los valores requeridos para crear una nueva tarea.
			 * */
			Tarea t = new Tarea();
			t.setTitulo(titulo);
			t.setDescripcion(descripcion);
			t.setCalificacion(0);
			t.setEntregado(false);
			t.setEntrega(null);
			/**
			 * Finalmente se realiza la persistencia de la tarea, haciendo constancia de la operacion en la base de datos
			 * Se envia la informacion por medio de atributos hacia la servlet ListarTareasProfesor
			 */
			em.persist(t);
			
			request.getRequestDispatcher("ListarTareasProfesor").forward(request, response);
		}
	}

	/**
	 * Se define el método post referenciando al método Get, lo que en otras palabras significa que realizan lo mismo los dos métodos.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
