package ec.epn.proyecto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Proyecto extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String resumen = request.getParameter("resumen");

		System.out.println("Datos a guardar " + titulo + " autor" + autor + " resumen " + resumen);

		if (titulo.equals("") || autor.trim().equals("")) {
			request.setAttribute("valTitulo", titulo);
			request.setAttribute("valAutor", autor);
			request.setAttribute("valResumen", resumen);
			request.setAttribute("valError", "meta bien los datos");

			request.getRequestDispatcher("registroLibro.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("listarLibros.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

}
