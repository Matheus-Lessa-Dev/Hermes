<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Exercicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
ArrayList<Exercicio> lista = (ArrayList<Exercicio>) request.getAttribute("exercicios");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/HermesCSS.css">
    <title>Listagem de Musculos</title>
</head>
  <header>
    <div class="container">
        <div id="icone"><a href="Menu"><img src="IMG/Logo.png" alt=""></a></div>
        <div id="imgCentral"><a href="Menu"><img src="IMG/ImagemCentral.png"></a></div>
        <div id="Suporte"><a href="Suporte"><img src="IMG/Suporte2.png" alt=""></a></div>
    </div>
   
</header>
<hr color="#000">
<body>
      
       <a href="Menu" class="voltar"> <  </a>
    
    
    <h1>Listagem de Exercícios</h1>
    
 
    <% for (int i = 0; i < lista.size(); i++) {%>
    <div class="maeretanguloMusculo"> 
        <div class="retanguloMusculo"> <%=lista.get(i).getNome()%> </div>
        <div>  <a href="selecionarEx?id=<%=lista.get(i).getID()%>" class="TresretanguloMusculo"> ⁝ </a> </div>
    </div> 
  <% } %>

    <a href="CadastrarExerciciosADM" class="opTxt"> <div class="opcoes"> Adicionar Exercícios</div> </a>
</body>

<footer>
    <br><br>
    <hr color="#000">


<div id="Maerodape">
    <p  id="rodape">João P. Moreno e Matheus L. Lessa | Olimpus sites & softwares LTDA Todos os direitos reservados.</p>
</div>
</footer>
</html>