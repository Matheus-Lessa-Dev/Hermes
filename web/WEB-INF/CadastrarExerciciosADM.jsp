<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Musculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/HermesCSS.css">
    <title>Cadastrar Exercicio</title>
    <style>
        /* Estilo para a área de upload personalizada */
        #uploadArea {
            border: 2px dashed #ccc;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            cursor: pointer;
            color: #666;
            font-size: 16px;
        }

        #uploadArea:hover {
            background-color: #f9f9f9;
            border-color: #aaa;
        }

        /* Esconde o input de arquivo padrão */
        #file {
            display: none;
        }
    </style>
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
<% 
  
ArrayList<Musculo> lista = (ArrayList<Musculo>) request.getAttribute("musculos");
  System.out.println("lista JSP" + lista);
%>
    
<a href="ListagemExercicioADM" class="voltar"> < </a>
<div id="conteudoPrincipal">
    <!-- Formulário de cadastro -->
    <div id="maeNomeMusculo">
        <form action="novoExercicio" method="post" enctype="multipart/form-data">
            <!-- Nome do Músculo -->
            <input type="text" name="nome" placeholder="Nome do Exercicio" id="NomeMusculo" required>
            
            <!-- Contêiner com campos de imagem e descrição lado a lado -->
            <div id="imagemDescricao">
                <div id="maeImgMusculo">
                    <!-- Área personalizada para upload -->
                    <div id="uploadArea" onclick="document.getElementById('file').click()">
                        Clique aqui para selecionar uma imagem
                    </div>
                    <input type="file" name="file" id="file" accept="image/*" onchange="mostrarNomeArquivo()">
                </div>
                <div id="maeDescMusculo">
                    <textarea name="desc" placeholder="Descrição, localização, composição, etc..." id="DescMusculo" rows="5"></textarea>
                </div>
            </div>
<div id="maeDescricao">
            <!-- Campo para descrição da imagem -->
            <label for="descricaoImagem">Descrição da imagem:</label>
            <input type="text" name="descricao" id="descricao" placeholder="Exemplo: Imagem ilustrativa do Exercicio..." required>
            </div>
            
            <div id="checkboxContainer">
                <div>
                <h3 id="selecioneTXT">Selecione os músculos relacionados:</h3>
                </div>
                <% 
                    if (lista != null && !lista.isEmpty()) {
                        for (Musculo musculo : lista) {
                %>
                <div>           
                <label>
                                <input type="checkbox" name="musculosSelecionados" value="<%= musculo.getID() %>" id="">
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
            </div>
            
            <!-- Botões abaixo da imagem e descrição -->
            <div id="botoesAcoes">
                <a href="ListagemExercicioADM">
                    <input type="button" value="Cancelar" id="CancelarBTN">
                </a>
                <a href="">
                      <input type="submit" value="Salvar" id="SalvarBTN">
                </a>
              
            </div>
        </form>
    </div>
</div>

<script>
    // Função para exibir o nome do arquivo selecionado
    function mostrarNomeArquivo() {
        const fileInput = document.getElementById('file');
        const uploadArea = document.getElementById('uploadArea');
        if (fileInput.files && fileInput.files.length > 0) {
            uploadArea.textContent = fileInput.files[0].name;
        } else {
            uploadArea.textContent = 'Clique aqui para selecionar uma imagem';
        }
    }
</script>

</body>

<footer>
    <br><br>
    <hr color="#000">
    <div id="Maerodape">
        <p id="rodape">João P. Moreno e Matheus L. Lessa | Olimpus sites & softwares LTDA Todos os direitos reservados.</p>
    </div>
</footer>
</html>


