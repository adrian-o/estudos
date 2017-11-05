// ############# First example ############## /
/**
var bob = {
    _name: "Bob",
    _friends:['Carol', 'Steve', 'Roger'],
    
    printFriends : function printFriends() {
        var self = this;
        this._friends.forEach(function(f){
            console.log(self._name + " knows " + f);
        });
    }
}

bob.printFriends();
*/

// ############# Arrow concepts ############## /
/**
 var color = () => console.log("Red");
color();


var bob = {
    _name: "Bob",
    _friends:['Carol', 'Steve', 'Roger'],
    
    printFriends : function printFriends() {
        this._friends.forEach(f => 
            console.log(this._name + " knows " + f));
    }
}

bob.printFriends();
*/

// ############# Using class ############## /
/**class Color {
    constructor(code, name){
        this.code = code;
        this.name = name;
    };

    getColor() {
        return {code: this.code, name: this.name};
    };
}

let red = new Color('red', 'Red');
console.log(red.getColor());*/

// ############# String template ############## /
/**let name = "Guilherme";
let age = 19;
//let text = "name: " + name + " age: " + age;
let text = `
<p>Name: ${name}</p>
<p>Age: ${age}</p>
`;*/

// ############# Default values ############## /
// Old way
// function test(valueA) {
//     var valueB = arguments.length <= 1 || arguments[1] === "undefined" ? 4 : arguments[1];
//     return valueA + valueB;
// }

// console.log(test(2,5));

// Using DV
// function test(valueA, valueB = 4) {
//     return valueA + valueB;
// }

// console.log(test(2));

// ############# For OF ############## /

var list = ['Adriano', 34, {color:'red'}];

for (var i in list) {
    console.log(list[i]);
}