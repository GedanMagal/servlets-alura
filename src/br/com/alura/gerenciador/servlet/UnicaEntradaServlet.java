package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao"); 
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		
    	if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
    	    response.sendRedirect("entrada?acao=LoginForm");
    	    return;
    	}

		

        String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

        String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);//carrega a classe com o nome 
			Acao acao = (Acao) classe.newInstance(); 
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}



        String[] tipoEEndereco = nome.split(":");
        if(tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEEndereco[1]);

        }
		
//		paramAcao.executa(req,resp);
//		
//		String nome = null;
//		if(paramAcao.equals("ListaEmpresas")) {
//		    ListaEmpresas acao = new ListaEmpresas();
//		    acao.executa(request, response);
//		    nome = acao.executa(request, response);
//		} else if(paramAcao.equals("RemoveEmpresa")) {
//		    RemoveEmpresa acao = new RemoveEmpresa();
//		    acao.executa(request, response);
//		    nome = acao.executa(request, response);
//		} else if(paramAcao.equals("MostraEmpresa")) {
//		    MostraEmpresa acao = new MostraEmpresa();
//		    acao.executa(request, response);
//		    nome = acao.executa(request, response);
//		} else if(paramAcao.equals("AlteraEmpresa")) {
//		    AlteraEmpresa acao = new AlteraEmpresa();
//		    acao.executa(request, response);
//		    nome = acao.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresa")) {
//
//		    NovaEmpresa acao = new NovaEmpresa();
//		    nome = acao.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresaForm")) {
//
//		    NovaEmpresaForm acao = new NovaEmpresaForm();
//		    nome = acao.executa(request, response);
//		} 
		

		
    }

}
