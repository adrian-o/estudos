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

// var list = ['Adriano', 34, {color:'red'}];

// for (let i of list) {
//     console.log(list[i]);
// }

// ############# Parents classes ############## /

// class People {
//     constructor(name, email, phone) {
//         this.name = name;
//         this.email = email;
//         this.phone = phone;
//     }

//     toString() {
//         return `Name: ${this.name}
//         Email: ${this.email}
//         Phone: ${this.phone}`;
//     }
// }

// class Client extends People {
//     constructor(id, name, email, phone) {
//         super(name, email, phone);
//         this.id = id;
//     }

//     toString() {
//         return `Id: ${this.id}
//         ${super.toString()}`;
//     }
// }

// var client = new Client(1, 'Adriano', 'adriano@gmail.com', 12322113);
// console.log(client.toString());

// ############# Testing format ############## /

// var number = 123445.45;

// var En = Intl.NumberFormat('en-US').format(number);
// var De = Intl.NumberFormat('de-DE').format(number);
// console.log(En);
// console.log(De);

// var USD = Intl.NumberFormat('en-US', {style:"currency", currency:"USD"}).format(number);
// var BRL = Intl.NumberFormat('pt-BR', {style:"currency", currency:"BRL"}).format(number);
// console.log(USD);
// console.log(BRL);

// var nDt = new Date("2016-04-25");

// var dUS = Intl.DateTimeFormat('en-US').format(nDt);
// var dBR = Intl.DateTimeFormat('pt-BR').format(nDt);
// console.log(dUS);
// console.log(dBR);

// ############# String searching ############## /

