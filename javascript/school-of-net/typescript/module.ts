// module App.Interfaces {
//     export interface ICar {
//         name:string;
//     }
// }

// module App.Classes {
//     export class Car implements ICar {
//         name:string;
//         color:string;
//     }
// }

// var car1 = new App.Classes.Car();
// console.log(car1);

/// <reference path="Color.ts" />

module ColorModule {
    var red = new Color();
    red.name = 'Red';
    red.code = '#FF0000';
    console.log(red.getColor());
}
