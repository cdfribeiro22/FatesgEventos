/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.evento.bll;


import com.evento.dao.ParticipanteDao;
import com.evento.model.CUsuarioSistema;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elisabete
 */
@WebServlet("/ELoginServlet1")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParticipanteDao LoginDao;
       
    public LoginServlet() {
        super();
        LoginDao = new ParticipanteDao();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "login_invalido.jsp";
                
                
                CUsuarioSistema login = new CUsuarioSistema();
                
                login.setEmail(request.getParameter("login"));
                login.setSenha(request.getParameter("senha"));

                
		// Validando se o usuário é igual a "admin" e a senha é igual a "senha"
		
		if(request.getParameter("acao").equals("login")) {
                    
			if(LoginDao.ConsultarLogin(login)) { 
				
					HttpSession sessao = request.getSession();
					// setando um atributo da sessao
					sessao.setAttribute("login", request.getParameter("login"));
					// como obtive sucesso, chamo a página principal
					pagina = "index.jsp";
				
			}
		} else if(request.getParameter("acao").equals("logout")) {
			// no logout invalido a sessao
			HttpSession sessao = request.getSession();
			sessao.invalidate();
			// chamo novamente a pagina principal, que deve chamar a página index
			// que ira mostrar o formulario para o usuário logar
			pagina = "index.jsp";
		}
                
               
		
		response.sendRedirect(pagina);
		
	}
}
