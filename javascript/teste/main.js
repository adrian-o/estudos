var scope = "global scope";
function checkscope() {
var scope = "local scope";
function nested() { // Uma variável global
// Uma variável local
var scope = "nested scope"; // Um escopo aninhado de variáveis locais
return scope; // Retorna o valor em scope aqui

}
return nested();
}

var finalScope = checkscope(); // => "nested scope

// Inputando seu campo no index do HTML
document.getElementById("scope").innerHTML = finalScope;

// Exibindo no console
console.log(finalScope);

// Exibindo em um alert
alert(finalScope);
