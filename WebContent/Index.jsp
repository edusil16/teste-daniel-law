<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){		
		$('#btnSubmeter').click(function(){
			var url = 'https://patentscope.wipo.int/search/pt/detail.jsf?docId=' + $("#txtNumeroProcesso").val() + '&redirectedID=true';
			
			$.ajax({
				type:'POST',
				data: { urlParametrizada: url },
				url: 'obterHtml',
				success: function(response){
					if(response != ""){
						var html = response;					
						$('#result').append(html);
						CriandoDivDados();
						$('.ps-mainmenu--container').hide();
						$('.b-notification-bar--wrapper').hide();
						$('.b-drawer__title, .wf-drawer-fix-position').hide();
						$('.flex-container').hide();
						$('.c-footer').hide();
					}
				},	
			});
		});
			
		$('body').on('click', '#btnGravar', function(){
				$.ajax({
						type:'POST',
						data: { 
							NumPub: $('#txtNumeroProcesso').val(),
							NumPedido: $('#txtNumPedido').val(),
							DataPublicacao: $('#DhPublicado').val(),
							Requerentes: $('#txtRequerentes').val(),
							Titulo: $('#txtTitulo').val() 
							},
						url: 'cadastrarProcesso',
						success: function(response){
							var result = response.split('Served')
							
							if(result[0] === "SUCESSO") {
									alert ("Cadastro no banco com Sucesso!")
								} else {
									alert ("Houve um erro interno!")
								}
						},
				})	
		});	
	})

	function CriandoDivDados(){
		var strHtml = "";		
			strHtml += 'Número Pedido: <input type="text" id="txtNumPedido"/><br/>';
			strHtml += 'Data Publicação: <input type="date" id="DhPublicado"/><br/>';
			strHtml += 'Requerentes: <input type="text" id="txtRequerentes"/><br/>';
			strHtml += 'Título: <input type="text" id="txtTitulo"/><br/>';
			strHtml += '<button class="btn-primary pull-right" id="btnGravar" type="submit">';
			strHtml += '<span class="icon-search"></span>Gravar Dados';
			strHtml += '</button>';
			strHtml +=	'</div>';
			strHtml += '</div>'
			strHtml += '</form>';
			strHtml += '</div>';
			strHtml += '</div>';
			strHtml += '</body>';
			strHtml += '</html>';
			$('#result').append(strHtml);
		}
</script>
<title>Tela de Cadastro</title>
</head>
<body>
	<h1>Cadastro</h1>
	<h2>Digite um número de processo:</h2>
	<input id="txtNumeroProcesso" />
	<button type="submit" id="btnSubmeter">Buscar</button>
	<div id="result"></div>
</body>
</html>