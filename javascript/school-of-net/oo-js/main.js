class Person {
    constructor() {
        this.name;
        this.age;
        this.height;
        this.capacity;
    }

    sayHello() {
        for (var i = 0; i < this.capacity; i++) {
            console.log('Hello ' + i);
        }
    }
}

var adriano = new Person();
adriano.name = 'Adriano Martins Ohana';
adriano.age = 34;
adriano.height = 179;
adriano.capacity = 10;

adriano.sayHello();