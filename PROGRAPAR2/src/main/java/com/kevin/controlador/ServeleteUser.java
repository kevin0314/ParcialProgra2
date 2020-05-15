package com.kevin.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kevin.Dao.ConsultasDao;
import com.kevin.Dao.UsuarioDao;
import com.kevin.entidades.Consultasp;
import com.kevin.entidades.Usuariop;

/**
 * Servlet implementation class ServeleteUser
 */
public class ServeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Consultasp co = new Consultasp();
		ConsultasDao codao = new ConsultasDao();
		
		String id = null;
		String nombre = null;
		String apellido = null;
		
		try {
			 id = request.getParameter("Id");
			 nombre = request.getParameter("nombre");
			 apellido = request.getParameter("apellido");
			 
			 co.setId(Integer.parseInt(id));
			co.setNombre(nombre);
			co.setApellido(apellido);
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String action = request.getParameter("btn");
		System.out.println(action);
		HttpSession seccion = (HttpSession)request.getSession();
		String usauriovariable = (String)seccion.getAttribute("usuario");
		if(action.equals("Actualizar")) {
			if (usauriovariable == null) {
				response.sendRedirect("login.jsp");
			}else {
				
				co.setId(Integer.parseInt(id));
				co.setNombre(nombre);
				co.setApellido(apellido);
				   codao.actualizarDatos(co);
				   response.sendRedirect("Actualizar.jsp");
			}
		}
		else if(action.equals("Eliminar")) {
			if (usauriovariable == null) {
			response.sendRedirect("login.jsp");
			}else {
				
				   co.setId(Integer.parseInt(id));
				   codao.eliminarDatos(co);
				   response.sendRedirect("Actualizar.jsp");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			response.sendRedirect("index.jsp"); 
		}else {
			System.out.println("Usuario no registrado");
		}
	}


}
