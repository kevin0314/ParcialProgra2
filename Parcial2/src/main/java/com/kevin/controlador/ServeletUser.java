package com.kevin.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kevin.Dao.UsuarioDao;
import com.kevin.entidades.Usuariop;

/**
 * Servlet implementation class ServeletUser
 */
public class ServeletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String nombre = request.getParameter("txtNombre");
		String contra = request.getParameter("txtContra");
		
		Usuariop usu = new Usuariop();
		UsuarioDao dao = new UsuarioDao();
		
		usu.setNombre(nombre);
		usu.setContrasenia(contra);
		
		int verificar = dao.validarUsuario(usu).size();
		
		if(verificar==1) {
			System.out.println("Entraste");
			HttpSession seccion = request.getSession(true);
			seccion.setAttribute("usuario", usu);
			response.sendRedirect("Crud.jsp"); 
		}else {
			System.out.println("Usuario no registrado");
		}
	}

}
