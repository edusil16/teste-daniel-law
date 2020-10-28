package br.com.teste.controller.domain;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/obterHtml")
public class ObterHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ObterHtml() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlParam = request.getParameter("urlParametrizada");
		StringBuffer resultado = CarregarHtml(urlParam);
		response.setStatus(200);
		response.getWriter().write(resultado.toString());
	}

	protected StringBuffer CarregarHtml(String url) {
		StringBuffer response = new StringBuffer();
		try {
			URL urlFull = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) urlFull.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.flush();
			wr.close();
			
			int responseCode = conn.getResponseCode();
			
			System.out.println("\nEnviando solicitaçãoo 'POST' para URL : " + url);
			System.out.println("Resposta do código : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			in.close();
			
			response.toString();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return response;
	}

}
