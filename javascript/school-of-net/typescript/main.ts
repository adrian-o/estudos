// function getHello(name:string) {
//     return 'Hello ' + name;
// }

// var _name = "Adriano Ohana";

// document.body.innerHTML = getHello(_name);

interface ICar {
    brand: string;
    name: string;
    power: number;
}

class Car {
    brand: string;
    name: string;
    // color: string;
    power: number;
}

var getCar = function(car:ICar) {
    console.log(car.brand, car.name, car.power);
};

var idea = new Car();
idea.brand = 'Fiat';
idea.name = 'Idea Adventure';
// idea.color = 'Idea Adventure';
idea.power = 84;

getCar(idea);