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
 * Implementacion de Servlet class EditarTareasEstudiante
 * @version 1.0, 14/09/2020
 * @author Gabby
 * 
 */
@Transactional
@WebServlet("/EditarTareaEstudiante")
public class EditarTareaEstudiante extends HttpServlet {
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
     *
     */
    public EditarTareaEstudiante() {
        super();
    }

	/**
	 * Se define el método get para que se permita obtener los datos de la servlet ListarTareasEstudiante cuyo id y otros datos se reciben como parámetros
	 * editarlos y enviarlos hacia la nueva jsp como Atributos.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Se obtiene el parametro id, con el fin de realizar una busqueda por id en la base de datos
		 * especificamente en la tabla tarea
		 * */
		String idStr= request.getParameter("id");
		Tarea t= em.find(Tarea.class, new Integer(idStr));
		/**
		 * Se procede a enviar los valores como atributos hacia la base de datos
		 * siguiendo el modelo de establecido en Tarea.class 
		 */
		
		request.setAttribute("valId", idStr);
		request.setAttribute("valTitulo", t.getTitulo());
		request.setAttribute("valDescripcion", t.getDescripcion());
		request.setAttribute("valEntrega", t.getEntrega());
		request.setAttribute("valEntregado", t.getEntregado());
		request.setAttribute("valCalificacion", t.getCalificacion());
		/**
		 * Finalmente se realiza la persistencia de la tarea, haciendo constancia de la operacion en la base de datos
		 * Se envia la informacion por medio de atributos hacia el jsp para editar los datos
		 */
		em.persist(t);
		request.getRequestDispatcher("editarTareaEstudiante.jsp").forward(request, response);	}

	/**
	 * Se define el método post referenciando al método Get, lo que en otras palabras significa que realizan lo mismo los dos métodos. 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
