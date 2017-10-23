// ##### Classes #####
// class Car {
//     constructor(
//         public name:string, 
//         public color:string, 
//         public power:number
//     ){};
function people(value) {
    console.log(value);
}
people({ name: "Adriano", age: 34 });
function people2(name, age) {
    return { name: name, age: age };
}
console.log(people2('Kaylane', 7));
function getColor() {
    return { code: '#FFF' };
}
console.log(getColor());
var sum;
sum = function (numA, numB) {
    return numA + numB > 50;
};
var a = prompt('Enter a first number:');
var b = prompt('Enter a second number:');
if (sum(parseInt(a), parseInt(b))) {
    alert('Sum is bigger then 50');
}
var array1;
array1 = ['Name', 'Color'];
console.log(array1);
