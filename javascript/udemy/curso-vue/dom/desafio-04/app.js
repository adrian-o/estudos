new Vue({
	el: '#desafio',
	data: {
		estilo1: 'destaque',
		cssClass: '',
		exemplo: false,
		cor5: '',
		estilo5: {
			width: '100px',
			height: '100px'
		},
		widthProgress: '0%'
	},
	computed: {},
	methods: {
		iniciarEfeito() {
			setInterval(() => {
				this.estilo1 = this.estilo1 == 'destaque' ? 'encolher' : 'destaque'
			}, 1000);
		},
		iniciarProgresso() {
			let valor = 0
			const temporizador = setInterval(() => {
				valor += 5
				this.widthProgress = `${valor}%`
				if (valor == 100) clearInterval(temporizador)
			}, 500);
		},
		setMinhaClasse(event) {
			if (event.target.value == 'sim') {
				this.exemplo = true
			} 

			if (event.target.value == 'nao') {
				this.exemplo = false
			}
		}
	}
})
