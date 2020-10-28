package br.com.teste.controller.domain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import br.com.teste.model.domain.ProcessoModel;
import br.com.teste.util.domain.ConnectionFactory;

@WebServlet("/obterTodosProcessos")
public class ObterTodosProcessos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ObterTodosProcessos() {
        super();       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		ArrayList<ProcessoModel> lstTodos = ListarTodos(); 
		lstTodos.toString();
		response.getWriter().write("" + lstTodos);
		
	}

	public ArrayList<ProcessoModel> ListarTodos() {

		String sql = "SELECT * FROM processo_model";

		ArrayList<ProcessoModel> processos = new ArrayList<ProcessoModel>();
		
		Connection connection = null;

		try {
			
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ProcessoModel processo = new ProcessoModel();
		
				processo.setNumPub(rs.getString("num_pub"));
				processo.setNumPedido(rs.getString("id_pedido"));
				processo.setDataPublicacao(rs.getString("dt_publicacao"));
				processo.setRequerentes(rs.getString("requerentes"));
				processo.setTitulo(rs.getString("titulo"));

				processos.add(processo);

			}

		} catch (SQLException ex) {

			throw new RuntimeException("Erro ao conectar na tabela livro:" + ex.getMessage());
		}

		return processos;
	}
}
