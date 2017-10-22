function Person(_name, _age, _height) {
    
    var name   = _name;
    var age    = _age; 
    var height = _height;

    function privateFunc() {
        console.log("Won't be accessible externaly");
    }

    this.sayHello = function () {
        for (var i = 0; i < 5; i++) {
            console.log('Hello ' + i);
        }
    }

    this.getName = function () {
        return name;
    }

    this.setName = function (_name) {
        name = _name;
    }

    this.getAge = function () {
        return age;
    }

    this.setAge = function (_age) {
        age = _age; 
    }

    this.getHeight = function () {
        return height;
    }

    this.setHeight = function (_height) {
        height = _height; 
    }
}

Person.prototype.myProtoFunc = function () {
    console.log('First prototype function');
}

Person.prototype.happyBirthday = function () {
    this.setAge(this.getAge()+1);
}

function Employee(_name, _age, _height) {
    var salary;

    Person.call(this, _name, _age, _height);

    this.getSalary = function () {
        return salary;
    }

    this.setSalary = function(_salary) {
        salary = _salary;
    }
}

Employee.prototype = Object.create(Person.prototype);

// var adriano = new Person('Adriano Ohana', 34, 179);
var adriano = new Employee('Adriano Ohana', 34, 179);

console.log(adriano.getAge());
adriano.happyBirthday();
console.log(adriano.getAge());

// Person.say_hello = function () {
//     for (var i = 0; i < 5; i++) {
//         console.log('Static Hello ' + i);
//     }
// }

// adriano.myProtoFunc();

//Person.say_hello();

console.log(adriano);

// Testing prototype object
console.log(adriano.__proto__);
console.log(Person.prototype);

//adriano.sayHello();


// Testing private functions in JS
//adriano.privateFunc();