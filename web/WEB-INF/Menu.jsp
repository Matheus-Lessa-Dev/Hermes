
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/HermesCSS.css">

    <title>Menu</title>
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
    overflow: hidden; /* Garante que o conteúdo não ultrapasse os limites do contêiner */
    text-align: center; /* Centraliza o texto dentro do contêiner */
}

.opTxt {
    color: #000;
    font-family: Inter, sans-serif;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    text-decoration: none;
#SuperOp{
    max-width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden; /* Garante que o conteúdo não ultrapasse os limites do contêiner */
    text-align: center; /* Centraliza o texto dentro do contêiner */
}


}
</style>


<body>
  <header>
    <div class="container">
        <div id="icone"><a href="Menu"><img src="IMG/Logo.png" alt=""></a></div>
        <div id="imgCentral"><a href="Menu"><img src="IMG/ImagemCentral.png"></a></div>
        <div id="Suporte"><a href="Suporte"><img src="IMG/Suporte2.png" alt=""></a></div>
    </div>
   
</header>
<hr color="#000">
    <h1>Menu</h1>

    <div id="SuperOp">
    <a href="ListagemMusculo" class="opTxt"> <div class="opcoes"> Músculos do Corpo</div> </a>
    <a href="ListagemMusculoADM" class="opTxt"> <div class="opcoes"> Listagem de Músculos</div> </a>
    <a href="ListagemExercicioADM" class="opTxt"> <div class="opcoes"> Listagem de Exercícios</div> </a>
    <a href="ListagemUsuarioADM" class="opTxt"> <div class="opcoes"> Listagem de Usuários</div> </a>
    <a href="Conciencia" class="opTxt"> <div class="opcoes"> Conciência Corporal</div> </a>
    <a href="Desenvolvimento" class="opTxt"> <div class="opcoes"> Minha Conta</div> </a>
    <a href="index" class="opTxt"> <div class="opcoes"> Sair</div> </a>
    </div>
    <hr color="#000">

    <p  id="rodape">João P. Moreno e Matheus L. Lessa | Olimpus sites & softwares LTDA Todos os direitos reservados.</p>
   
</body>
</html>

