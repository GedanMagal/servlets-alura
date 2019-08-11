package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("ListaEmpresas")) {
		    ListaEmpresas acao = new ListaEmpresas();
		    acao.executa(request, response);
		} else if(paramAcao.equals("RemoveEmpresa")) {
		    RemoveEmpresa acao = new RemoveEmpresa();
		    acao.executa(request, response);
		} else if(paramAcao.equals("MostraEmpresa")) {
		    MostraEmpresa acao = new MostraEmpresa();
		    acao.executa(request, response);
		} else if(paramAcao.equals("AlteraEmpresa")) {
		    AlteraEmpresa acao = new AlteraEmpresa();
		    acao.executa(request, response);
		} else if(paramAcao.equals("NovaEmpresa")) {
		    NovaEmpresa acao = new NovaEmpresa();
		    acao.executa(request, response);
		}

    }

}
