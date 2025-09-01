
<%@page import="Entities.Musculo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/HermesCSS.css">
    <title>Cadastrar Musculo</title>
</head>
  <header>
    <div class="container">
        <div id="icone"><a href="Menu"><img src="IMG/Logo.png" alt=""></a></div>
        <div id="imgCentral"><a href="Menu"><img src="IMG/ImagemCentral.png"></a></div>
        <div id="Suporte"><a href="Suporte"><img src="IMG/Suporte2.png" alt=""></a></div>
    </div>
   
</header>

<% 
  
ArrayList<Musculo> lista = (ArrayList<Musculo>) request.getAttribute("musculos");
ArrayList<Integer> lista2 = (ArrayList<Integer>) request.getAttribute("musculosSelecionados");
  System.out.println("lista JSP" + lista);
%>
<hr color="#000">
<body>
    
    <style>
            #MaeImgMuscN{
                padding: 3rem;
                 width: 100%;
                     display: flex;
                 justify-content: center;
                align-items: center;
            }
            
            #imgMusc{
                width: 30rem;
                height: 30rem;
                 background: rgba(0, 0, 0, 0.20);
                 padding: 1.5rem;
                
            }
             #maeNovaImg{
                 display: flex;
                 justify-content: left;
                align-items: center;
            }
           
            
    </style>
    <script src="JS/ConfirmarDeletarEx.js"></script>

<a href="ListagemExercicioADM" class="voltar"> < </a>
<div id="conteudoPrincipal">
    <!-- Nome do Músculo no topo -->
    <div id="maeNomeMusculo">
        <form action="editarEx" method="post" enctype="multipart/form-data">
            <!-- Campo oculto para ID -->
            <input type="hidden" name="id" value="${id}" id="idEXA">

            <!-- Nome do Músculo -->
            <input type="text" name="nome" placeholder="Nome do Músculo" id="NomeMusculo" value="${nome}">
            
            <!-- Contêiner com imagem e descrição lado a lado -->
            <div id="imagemDescricao">
                
                <div id="maeImgMusculo">
                    <img src="${imgMusculo}" alt="Imagem do Exercicio" id="imgMusc" name="imgMusculo"/>  
                    <div id="maeNovaImg">
                    <label for="novaImgMusculo">Alterar imagem do Exercicio:</label>
                <input type="file" name="novaImgMusculo" id="novaImgExercicio" accept="image/*">
                </div>
                </div>
               
            
                
                <div id="maeDescMusculo">
                    <textarea name="desc" placeholder="Descrição, localização, composição, etc..." id="DescMusculo" rows="5">${desc}</textarea>
                </div>
            </div>
                
                
          <% 
    if (lista != null && !lista.isEmpty()) {
        // Verifica se lista2 não é nula e não está vazia
        ArrayList<Integer> musculosSelecionados = (ArrayList<Integer>) request.getAttribute("musculosSelecionados");
        
        for (Musculo musculo : lista) {
            // Verifica se o ID do músculo está na lista de músculos selecionados
            boolean isChecked = false;
            if (musculosSelecionados != null && musculosSelecionados.contains(musculo.getID())) {
                isChecked = true;
            }
%>
                <div>           
                    <label>
                        <input type="checkbox" name="musculosSelecionados" value="<%= musculo.getID() %>" <%= isChecked ? "checked" : "" %>>
                        <%= musculo.getNome() %>
                    </label>
                </div> 
<% 
        }
    } else { 
%>
    <p>Nenhum músculo disponível para seleção.</p>
<% 
    } 
%>


            <!-- Botões abaixo da imagem e descrição -->
            <div id="botoesAcoes">
                <a href="javascript:confirmar(${id})">
                    <input type="button" value="Deletar" id="DeletarBTN">
                </a>
                <a href="ListagemExercicioADM">
                    <input type="button" value="Cancelar" id="CancelarBTN">
                </a>
                    <a>
                        
                           <input type="submit" value="Salvar" id="SalvarBTN"> 
                    </a>
            
            </div>
        </form>
    </div>
</div>

 
</body>

<footer>
    <br><br>
    <hr color="#000">
    <div id="Maerodape">
        <p id="rodape">João P. Moreno e Matheus L. Lessa | Olimpus sites & softwares LTDA Todos os direitos reservados.</p>
    </div>
</footer>
</html>

