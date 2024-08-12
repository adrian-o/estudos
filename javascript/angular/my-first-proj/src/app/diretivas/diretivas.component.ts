import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-diretivas',
  templateUrl: './diretivas.component.html',
  styleUrls: ['./diretivas.component.css']
})
export class DiretivasComponent implements OnInit {

  public condition: boolean = true;
  public filmes: Array<string> = ['O açougueiro', 'Titanic', 'Moderno'];
  public novoFilme: string = '';
  public nome: string = '';
  public hoje: Date = new Date();

  ngOnInit(): void {
    setInterval(()=>{
      this.condition = !this.condition;
    }, 3000);
  }

  public addFilme(): void {
    this.filmes.push(this.novoFilme);
  }

  public removeFilme(filme: number): void {
    this.filmes.splice(filme, 1)
  }
}
