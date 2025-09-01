<%@page import="DAO.ExercicioDAO"%>
<%@page import="Entities.Exercicio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% 
ArrayList<Exercicio> lista = (ArrayList<Exercicio>) request.getAttribute("Exercicios");
ExercicioDAO dao = new ExercicioDAO();
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/HermesCSS.css">

    <title>Menu</title>
</head>
  <header>
    <div class="container">
        <div id="icone"><a href="Menu"><img src="IMG/Logo.png" alt=""></a></div>
        <div id="imgCentral"><a href="Menu"><img src="IMG/ImagemCentral.png"></a></div>
        <div id="Suporte"><a href="Suporte"><img src="IMG/Suporte2.png" alt=""></a></div>
    </div>
   
</header>
        <style>
           #MaeImgMuscN{
    padding: 3rem 0rem;
    width: 90%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column; /* Alinha os itens verticalmente */
}

            
            #imgMusc{
                width: 30rem;
                height: 30rem;
                 background: rgba(0, 0, 0, 0.20);
                 padding-left: 2rem;
                padding-top: 2rem;
                padding-right: 2rem;
            }
            #maeDeTudo{
                height: 50%;
                display: flex;
                
                justify-content: center;
                align-items: center;
            }
            #DescMuscN{
                 width: 100%;
                 display:flex;
                text-align: justify; 
                 font-size: 25px;
                align-items: center;
                height: 15rem;
            }
            #DescMuscNTXT{
                background: rgba(0, 0, 0, 0.20);
                color: white;
                width: 90%;
                    padding: 3rem 2rem;
                                    justify-content: center;
                align-items: center;
                    
            }
            
            #maedamae{
                     display: flex;
                justify-content: center;
                align-items: center;
            }
            
            #MaeExerciciosTXT{
                background: rgba(0, 0, 0, 0.20);
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 1rem 2rem;
                margin-bottom: 10px;
               
            }
            #ExerciciosTXT{
                color: white;
                font-size: 1.50rem;
                background: rgba(0, 0, 0, 0.0);
                
            }
            
            #MaeTudoExercicio{
                background: rgba(0, 0, 0, 0.20);
                display: flex;
                justify-content: center;
                align-items: center;
                margin-bottom: 10px;
                margin-top: 10px;
                width: 80rem;
            }
            
      
            #MaeDaMaeTudoExercicio{
                display: flex;
                justify-content: center;
                align-items: center;
            }
            
            #DescEx{
                 background: rgba(0, 0, 0, 0.20);
                color: white;
                
            
            }
            #NomeEx{
                 background: rgba(0, 0, 0, 0.20);
                color: white;
                font-size: 1.50rem;
                display: flex;
               
           
            }
            
            #MaeTextos{
              background: rgba(0, 0, 0, 0.0);
              flex: 1; /* permite que a div ocupe o espaço restante */
            
            }
            .maeFonte{
                background: rgba(0, 0, 0, 0.20);
                align-items: center;
                padding-bottom: 2rem;
            }
            
            p {
                  background: rgba(0, 0, 0, 0.00);
                padding: 1rem;
    word-wrap: break-word; /* Força a quebra de linha para palavras longas */
    overflow-wrap: break-word; /* Para compatibilidade com navegadores mais antigos */
    white-space: normal; /* Garante que o espaço em branco seja tratado de forma normal */
    word-break: break-word; /* Força a quebra de palavras longas */
}

.fonte{
    background: rgba(0, 0, 0, 0.00);
    color: #FFF;
                 display: flex;
                justify-content: center;
                align-items: center; 
                font-size: 13px;
}

        </style>
        <hr color="#000">
    <body>

        <a href="ListagemMusculo" class="voltar"> < </a>
        
        <h1>${nome}</h1>
        <div id="maeDeTudo">         
        
            <div id="MaeImgMuscN">   
                    <img src="${imgMusculo}" alt="Imagem do Músculo" id="imgMusc" name="imgMusculo"/>  
                     <l class="fonte">Fonte: Kenhub</l> 
             </div>  
        <div id="DescMuscN">
           <p id="DescMuscNTXT">${desc}</p>
         </div>
        </div>

         <div id="maedamae">
         <div id="MaeExerciciosTXT">
             <p id="ExerciciosTXT">Exercícios</p> 
         </div>
        </div>
         
<% if (lista != null) { %>
    <% for (int i = 0; i < lista.size(); i++) { %>
    <div id="MaeDaMaeTudoExercicio"> 
    <div id="MaeTudoExercicio">
                
        <div id="ImgMuscDiv">   
                    <img src="<%=dao.acharImagem(lista.get(i).getID())%>" alt="Imagem do Músculo" id="imgMusc" name="imgMusculo"/>  
                    <div class="maeFonte">
                        <l class="fonte">Fonte: Kenhub</l> 
                    </div>
        </div> 
        
        <div id="MaeTextos">
                    <div id="DivNomeEx"> <p id="NomeEx"><%= lista.get(i).getNome() %></p> </div>
                    <div id="DivDescEx"> <p id="DescEx"><%= lista.get(i).getDescricao() %></p> </div>
    </div>
    </div> 
    </div>
    <% } %>
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
