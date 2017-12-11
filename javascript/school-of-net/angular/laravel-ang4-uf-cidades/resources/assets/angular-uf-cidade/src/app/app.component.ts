import { Component } from '@angular/core';

import { CidadeService } from './cidade.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'Cidades';
	
	estados:Array<any> = [];
	cidades:Array<any> = [];
	estado = null;

	constructor(private cidadeService:CidadeService){
		this.cidadeService.getEstados()
			.then(estados => this.estados = estados);
	}

	getCidades() {
		this.cidadeService.getCidades(this.estado)
		.then(cidades => this.cidades = cidades);
	}
}
