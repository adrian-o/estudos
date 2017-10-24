// ##### First tests... #####
// function getHello(name:string) {
//     return 'Hello ' + name;
// }

// var _name = "Adriano Ohana";

// document.body.innerHTML = getHello(_name);


// ##### Testing interface and class #####
// interface ICar {
//     brand: string;
//     name: string;
//     power: number;
// }

// class Car {
//     brand: string;
//     name: string;
//     power: number;
// }

// var getCar = function(car:ICar) {
//     console.log(car.brand, car.name, car.power);
// };

// var idea = new Car();
// idea.brand = 'Fiat';
// idea.name = "Adventure";
// idea.power = 84;

// getCar(idea);

// ##### Testing types #####

// var test:boolean = false;
// var id:number = 0;

// // Numbers
// var decimal:number = 5.2;
// var hex:number = 0xf00d;
// var binary:number = 0b1010;
// var octal:number = 0o744;

// // Strings
// var _name:string = "Adriano";
// var car:string = 'Idea';
// var bigText = `<p>Starting with big strings</p>
// <p>Name: ${_name}</p>
// <p>Car: ${car}</p>
// `;
// // console.log(bigText);

// document.body.innerHTML = bigText;

// // Arrays
// var fruits:string[] = ['Apple','Lemon','Grape'];
// console.log(fruits);

// var fruits:Array<string> = ['Apple','Lemon','Grape'];
// console.log(fruits);

// // Enums
// enum Color {RED = 1, GREEN, BLUE};

// console.log(Color.RED);
// console.log(Color[2]);

// // Any
// var list:any = 0;
// console.log(list);
// list = 'String ...';
// console.log(list);
// list = Color;
// console.log(list);

// // Void

// function printNum(num:number) : void {
//     alert(num);
// }

// printNum(1000);

// ##### Scope variables #####

// var car:string = 'Ferrari';

// function getCar(value:string):string {
//     var car = value;
//     return car;
// }

// console.log(getCar("Camaro"));
// console.log(car);

// function testScope() {
//     return car;
// }

// console.log(testScope());

// function testA() {
//     var a = 1;
//     a = 2;
//     var b = testB();
//     a = 3;
//     return b;   
//     function testB() {
//         return a;
//     }
// }

// console.log(testA());

// function f(value:boolean) {
//     let a = 100;
    
//     if(value) {
//         let b = a + 1;
//         return b;
//     }

//     // return b;
// }

// console.log(f(false));

// function g(condition:boolean, x:number) {
//     if (condition) {
//         let x = 100;
//         return x;
//     }

//     return x;
// }

// console.log(g(false, 50));

// // Testing "For of" loop

// var listCar = ['Camaro', 'Ferrari', 'Porsche'];

// for(var car in listCar) {
//     console.log(car);
// }

// for (var car of listCar) {
//     console.log(car);
// }

// var colors = new Array(['Green', 'Red', 'Blue']);
// colors['title'] = 'Colors';

// console.log(colors);

// for(var color in colors) {
//     console.log(color);
// }

// for (var c of colors) {
//     console.log(c);
// }

// Separeted file...
/// <reference path="Car" />

var c1 = new Car('Camaro', 'Yellow', 240);
c1.getCar();