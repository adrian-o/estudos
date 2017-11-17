import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Cep } from './model/cep';

@Injectable()
export class CepService {

  constructor(private http:Http) { }

  buscarCep(cep:string) {
    return this.http.get(`https://viacep.com.br/ws/${cep}/json/`)
          .toPromise()
            .then(response => this.converterCepResponse(response.json()));
  }

  private converterCepResponse(cepResponse):Cep {
    let cep = new Cep();
    cep.cep = cepResponse.cep;
    cep.logradouro = cepResponse.logradouro;
    cep.complemento = cepResponse.complemento;
    cep.bairro = cepResponse.bairro;
    cep.cidade = cepResponse.localidade;
    cep.estado = cepResponse.uf;
    return cep;
  }
}
