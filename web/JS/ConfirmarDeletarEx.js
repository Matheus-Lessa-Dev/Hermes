/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function confirmar(id){
    let resposta = confirm("Deseja confirma a exclusão deste Exercicio ?");
    if(resposta === true)
    {
        // fazemos um redirecionamento para um outro local no caso a requisição delete
        window.location.href ="deletarEx?id=" +id;
    }else{
        
    }
}
