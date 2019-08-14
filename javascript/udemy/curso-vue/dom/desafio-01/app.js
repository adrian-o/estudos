new Vue({
    el: '#desafio',
    data: {
        nome: 'Adriano Ohana',
        idade: 36,
        srcImg: 'logo_vue.jpeg'
    },
    methods: {
        idadeVezes3() {
            return this.idade * 3
        },
        randomicNumber() {
            return Math.random()
        }
    }
})