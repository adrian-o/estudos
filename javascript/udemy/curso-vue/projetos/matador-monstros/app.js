new Vue({
    el: "#app",
    data: {
        running: false,
        playerLife: 100,
        monsterLife: 100,
        logs: []
    },
    computed: {
        hasResult() {
            return this.playerLife == 0 || this.monsterLife == 0
        }
    },
    methods: {
        startGame() {
            this.running = true
            this.playerLife = 100
            this.monsterLife = 100
            this.logs = []
        },
        attack(special) {
            this.hurt('monsterLife', 4, 9, special, 'Player', 'Monster', 'player')
            if (this.monsterLife > 0) {
               this.hurt('playerLife', 6, 11, false, 'Monster', 'Player', 'monster')
            }
        },
        hurt(atr, min, max, special, source, target, cls) {
            const plus = special ? 5 : 0
            const hurt = this.getRandom(min + plus, max + plus)
            this[atr] = Math.max(this[atr] - hurt, 0)
            this.registerLog(`${source} attacked ${target} with ${hurt}...`, cls)
        },
        heal(min, max) {
            this.playerLife = Math.min(this.playerLife + this.getRandom(min, max), 100)
            this.registerLog(`O jogador ganhou força de ${heal}.`, 'player')
        },
        healAndHurt() {
            this.heal(10, 15)
            this.hurt('playerLife', 8, 13, false, 'Monster', 'Player', 'monster')
        },
        getRandom(min, max) {
            const value = Math.random() * (max - min) + min
            return Math.round(value)
        },
        registerLog(text, cls) {
            this.logs.unshift({ text, cls })
        }
    },
    watch: {
        hasResult(value) {
            if (value) this.running = false
        }
    }
})