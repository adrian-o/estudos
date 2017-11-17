import { Component, OnInit } from '@angular/core';
import { CepService } from '../cep.service';
import { Cep } from '../model/cep';

@Component({
  selector: 'cep',
  templateUrl: './cep.component.html',
  styleUrls: ['./cep.component.css']
})
export class CepComponent implements OnInit {

  cep = new Cep();
  isLoading = false;

  constructor(private cepService:CepService) { }

  ngOnInit() {
  }

  buscarCep() {
    this.isLoading = true;
    this.cepService.buscarCep(this.cep.cep)
          .then((cep:Cep)=> {
            this.isLoading = false;
            this.cep = cep
          })
          .catch(()=>{
            this.isLoading = false;
            this.cep = new Cep();
            alert('Não foi possível concluir a busca.');
          });
  }

}
