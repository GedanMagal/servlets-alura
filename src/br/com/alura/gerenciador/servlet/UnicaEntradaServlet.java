package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.ListaEmpresas;


@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("ListaEmpresas")) {
			System.out.println("Listando empresas");
			
			ListaEmpresas acao = new ListaEmpresas();
			acao.executa(request, response);
		}
		else if(paramAcao.equals("MostraEmpresa")) {
			System.out.println("Mostrando dados da empresas");
		}
		else if(paramAcao.equals("RemoveEmpresa")) {
			System.out.println("Removendo empresa");
		}
		
	}

}
