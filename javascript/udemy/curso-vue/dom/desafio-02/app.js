new Vue({
    el: '#desafio',
    data: {
        valor: ''
    },
    methods: {
        alerta() {
            alert('Botão clicado.')
        },
        alteraValor(event) {
            this.valor = event.target.value
        }
    }
})