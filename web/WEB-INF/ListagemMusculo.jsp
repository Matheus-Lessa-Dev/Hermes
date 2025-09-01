<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Musculo"%>

<% 
ArrayList<Musculo> lista = (ArrayList<Musculo>) request.getAttribute("musculos");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/HermesCSS.css">
    <title>Músculos do corpo</title>
</head>

<style>
    .opçoes {
    width: 90%;
    max-width: 500px;
    border-radius: 20px;
    background: #C2C0C0;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 10px;
    margin: 10px 0;
}

.opTxt {
    color: #000;
    font-family: Inter, sans-serif;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    text-decoration: none;
}
</style>

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
    
    
    <h1>Músculos do corpo</h1>
    
 
    <% for (int i = 0; i < lista.size(); i++) {%>
     <a href="MusculoEx?id=<%=lista.get(i).getID()%>" class="opTxt"> <div class="opcoes"> <%=lista.get(i).getNome()%></div> </a>
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
