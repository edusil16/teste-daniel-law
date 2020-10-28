package br.com.teste.controller.domain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.util.domain.ConnectionFactory;

@WebServlet("/cadastrarProcesso")
public class CadastrarProcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarProcesso() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String NumPub = request.getParameter("NumPub");
		String NumPedido = request.getParameter("NumPedido");
		String DataPublicacao = request.getParameter("DataPublicacao");
		String Requerentes = request.getParameter("Requerentes");
		String Titulo = request.getParameter("Titulo");

		Connection connection = null;

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "insert into processo_model (num_pub, id_pedido, dt_publicacao, requerentes, titulo) values ("
					+ NumPub + "," + NumPedido + "," + DataPublicacao + "," + Requerentes + "," + Titulo + ")";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.execute();
			pst.close();
			
			response.getWriter().write("SUCESSO");

		} catch (SQLException e) {
			response.getWriter().write("ERRO AO SALVAR");
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
