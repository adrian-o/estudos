// function getHello(name:string) {
//     return 'Hello ' + name;
// }
var Car = /** @class */ (function () {
    function Car() {
    }
    return Car;
}());
var getCar = function (car) {
    console.log(car.brand, car.name, car.power);
};
var idea = new Car();
idea.brand = 'Fiat';
idea.name = 'Idea Adventure';
// idea.color = 'Idea Adventure';
idea.power = 84;
getCar(idea);
