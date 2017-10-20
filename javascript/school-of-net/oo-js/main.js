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

    this.setName = function (_name) {
        name = _name;
    }

    this.setAge = function (_age) {
        age = _age;
    }
}

Person.prototype.myProtoFunc = function () {
    console.log('First prototype function');
}

var adriano = new Person('Adriano Ohana', 34, 179);

Person.say_hello = function () {
    for (var i = 0; i < 5; i++) {
        console.log('Static Hello ' + i);
    }
}

adriano.myProtoFunc();

//Person.say_hello();

console.log(adriano);

// Testing prototype object
console.log(adriano.__proto__);
console.log(Person.prototype);

//adriano.sayHello();


// Testing private functions in JS
//adriano.privateFunc();