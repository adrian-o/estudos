// ##### Classes #####
// class Car {
//     constructor(
//         public name:string, 
//         public color:string, 
//         public power:number
//     ){};

//     printCar():void {
//         console.log(this.name, this.color, this.power);
//     }
// }

// var camaro = new Car('Camaro', 'Yellow', 220);
// camaro.printCar();

// class Car2 {
//     private _name:string;
//     private _color:string;
//     private _power:number;
//     public static list:Array<string> = [];
    
//     constructor(name:string, color:string, power:number) {
//         this._name = name;
//         this._color = color;
//         this._power = power;
//         Car2.list.push(name);
//     };

//     get name(): string {
//         return this._name;
//     }

//     set name(value:string) {
//         this._name = value;
//     }
// }

// var ferrari = new Car2("Ferrari", "Red", 300);
// console.log(ferrari);
// console.log(Car2.list);

// var camaro2 = new Car2("Camaro2", "Red", 200);
// console.log(Car2.list);
// camaro2.name = 'Ferrari2';
// console.log(camaro2.name);

// ##### Interfaces #####

// interface IPerson {
//     name:string;
//     age:number;
// }

// function people (value:IPerson):void {
//     console.log(value);
// }

// people({name:"Adriano", age:34});

// function people2 (name:string, age:number): IPerson {
//     return {name:name ,age:age};
// }

// console.log(people2('Kaylane', 7));

// interface IColor {
//     title?:string; // Optional attribute
//     code:string;
// }

// function getColor ():IColor {
//     return {code:'#FFF'};
// }

// console.log(getColor());

// // For functions...
// interface ITypeFunc {
//     (vA:number, vB:number):boolean;
// }

// var sum:ITypeFunc;
// sum = function(numA:number, numB:number):boolean {
//     return numA+numB > 50;
// };

// var a = prompt('Enter a first number:');
// var b = prompt('Enter a second number:');

// if (sum(parseInt(a), parseInt(b))) {
//     alert('Sum is bigger then 50');
// }

// // For Arrays
// interface IArrayTypes {
//     [index:number] : string;
// }

// var array1:IArrayTypes;
// array1 = ['Name', 'Color'];
// console.log(array1);

interface ICountString {
    valueTxt: string;
    count(): number;
}

interface IPrintString {
    print(value:string):void;
}

class MyText implements ICountString, IPrintString {
    constructor(public valueTxt: string){};
    
    count(): number {
        return this.valueTxt.length;
    }

    print(value:string):void {
        console.log('Text: ' + value);
    }
}

var txt = new MyText('my personal string');
document.body.innerHTML = "My personal string has " + txt.count() + " characters...";
txt.print(txt.valueTxt);