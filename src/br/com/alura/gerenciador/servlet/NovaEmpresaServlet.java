package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataAbertura = null;
		try {
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
			
		}
	
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		response.sendRedirect("listaEmpresas");
		
		request.setAttribute("empresa", empresa.getNome());
		
		//chamar o JPS
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
