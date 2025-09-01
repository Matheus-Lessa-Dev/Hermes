<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("usuarios");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/HermesCSS.css">
    <title>Listagem de Usuários</title>
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
    
    
    <h1>Listagem de Usuários</h1>
    
 
    <% for (int i = 0; i < lista.size(); i++) {%>
    <div class="maeretanguloMusculo"> 
        <div class="retanguloMusculo"> <%=lista.get(i).getGmail()%> </div>
        <div>  <a href="Desenvolvimento" class="TresretanguloMusculo"> ⁝ </a> </div>
    </div> 
  <% } %>

  
</body>

<footer>
    <br><br>
    <hr color="#000">


<div id="Maerodape">
    <p  id="rodape">João P. Moreno e Matheus L. Lessa | Olimpus sites & softwares LTDA Todos os direitos reservados.</p>
</div>
</footer>
</html>
