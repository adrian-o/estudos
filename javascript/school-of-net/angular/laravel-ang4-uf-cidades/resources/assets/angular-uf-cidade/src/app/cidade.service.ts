import { Injectable } from '@angular/core';

import { Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class CidadeService {

	constructor(private http:Http) { }

	getEstados():Promise<Array<any>> {
		return this.http.get('http://localhost:8000/estados')
    		.toPromise()
			.then(response=>response.json());
	  	}

  	getCidades(estadoId):Promise<Array<any>> {
    	return this.http.get(`http://localhost:8000/estados/${estadoId}/cidades`)
    		.toPromise()
    		.then(response=>response.json());
  	}
}
