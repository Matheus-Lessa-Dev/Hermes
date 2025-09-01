<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/HermesCSS.css">
    <title>Login</title>
</head>
<header>
    <div class="container">
        <div id="icone"><a href="index"><img src="IMG/Logo.png" alt="" ></a></div>
        <div id="imgCentral"><a href="index"><img src="IMG/ImagemCentral.png"></a></div>
        <div id="Suporte"><a href="Suporte"><img src="IMG/Suporte2.png" alt=""></a></div>
    </div>
   
</header>
<hr color="#000">
<body>
     
    <style>#maeEmail{
    display: flex;
    align-items: center;
    justify-content: center;
}

#email{
    height: 40px;
    width:400px;
    border: 0 none;
    outline: 0;
    background-color: #C2C0C0;
    border-radius: 20px;
    color: #4F4F4F;
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    font-family: Sansation;
    font-size: 20px;
    font-style: normal;
    font-weight: 50;
    line-height: normal;
    display: flex;
    align-items: center;
    justify-content: center;
}

#email::placeholder{
    padding-left: 140px;
}

#maeSenha{
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 20px;
}

#senha{
    height: 40px;
    width:400px;
    border: 0 none;
    outline: 0;
    background-color: #C2C0C0;
    border-radius: 20px;
    color: #4F4F4F;
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    font-family: Sansation;
    font-size: 20px;
    font-style: normal;
    font-weight: 50;
    line-height: normal;
    display: flex;
    align-items: center;
    justify-content: center;

}

#senha::placeholder{
    padding-left: 140px;
}

#LoginBotao{
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 20px;
}

#enviar{
    color: #000000;
    background-color: rgba(5, 253, 122, 0.80);
    border: 0 none;
    outline: 0;
    width: 250px;
    height: 43px;
    font-size: 30px;
    border-radius: 20px;
}

#EsqueceuSenha{
    margin: 1%;
    display: flex;
    align-items: center;
    justify-content: center;

}

#EsqueceuTXT{
    color:white;
    font-size: 18px;
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}

#EsqueceuA{
    font-size: 17px;
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
    text-decoration: none;
    color: #1FB8FA;
}

#Cadastrar{
    height: 8px;
    display: flex;
    align-items: center;
    justify-content: center;
}

#CadastrarTXT{
     color:white;
    font-size: 18px;
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}

#CadastrarA{
    font-size: 17px;
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
    text-decoration: none;
    color: #1FB8FA;
}

#RetanguloFundoHermes{
width: 800px;
height: 300px;
background: linear-gradient(to top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0));display: flex;
border-radius: 20px;
align-items: center;
justify-content: center;
display: table;
}

#MaeRetanguloFundoHermes{
    margin-top: 50px;
    display: flex;
    align-items: center;
    justify-content: center;

    }

#MaeOqE{
    background: none;


    
}
#OqE{
    align-items: center;
    justify-content: center;
    display: flex;
    background: none;
    color: white;
    font-size: 30px;
}

#maetextoResumo{
    display: flex;
    background: none;
    vertical-align: middle;
    align-items: center;
    justify-content: center;

}

#textoResumo{
    background: none;
    font-size: 20px;
    color: white;
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
    text-align: justify;
    margin: 10px;
    line-height: 3ch;

}</style>
    
    <h1>Login</h1>

    <!-- Verifica se há uma mensagem de erro de login -->
    <c:if test="${not empty sessionScope.erroLogin}">
        <div style="color: red; margin-bottom: 10px; text-align: center;">
            ${sessionScope.erroLogin}
        </div>
        <!-- Após exibir o erro, limpa a sessão para não mostrar nas próximas requisições -->
        <c:set var="erroLogin" value="${sessionScope.erroLogin}" scope="session" />
        <c:remove var="erroLogin" scope="session" />
    </c:if>

    <form id="Login" action="Login" method="post">
        <div id="maeEmail"> 
            <input type="text" placeholder="Insira seu Email" name="email" id="email"> 
        </div>
        <div id="maeSenha"> 
            <input type="password" placeholder="Insira sua Senha" name="senha" id="senha"> 
        </div>

        <div id="EsqueceuSenha"> 
            <p id="EsqueceuTXT">Esqueceu sua senha? &nbsp</p>
            <a href="Desenvolvimento" id="EsqueceuA">Redefinir Senha</a>
        </div>
    
        <div id="Cadastrar"> 
            <p id="CadastrarTXT">Não tem uma conta? &nbsp</p>
            <a href="irCadastrar" id="CadastrarA">Cadastre-se</a>
        </div>

        <div id="LoginBotao"> 
            <button id="enviar">Entrar</button>
        </div>
    </form>



    <div id="MaeRetanguloFundoHermes"> 
    <div id="RetanguloFundoHermes">
     <div id="MaeOqE">  <p id="OqE">O Que é o Hermes?</p> </div>
       <div id="maetextoResumo"> <p id="textoResumo">O Hermes é uma ferramenta informatizada produzida com o objetivo de informar e esclarecer sobre práticas dentro da músculação, ou seja, transformar a aprendizagem de exercícios de músculação em algo prático, acessivel e dinamico. 

            Através de informações válidas e confiáveis, o site busca alcançar pessoas iniciantes na prática da musculação até pessoas com interesses em se tornar atleta, sendo um site profissional e acessível à todos.</p>
        </div> 
        </div>
</div>
<br>

</body>

<footer>
    <div id="Maerodape">
    <hr color="#000">



    <p  id="rodape">João P. Moreno e Matheus L. Lessa | Olimpus sites & softwares LTDA Todos os direitos reservados.</p>
</div>
</footer>
</html>