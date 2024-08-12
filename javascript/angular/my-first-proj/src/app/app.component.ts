import { Component, OnInit, OnChanges, Input } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit, OnChanges {

  public exibeTitle: boolean = true;

  public destroiComponent(): void {
    this.exibeTitle = false;
  }

  ngOnInit(): void {
    console.log('Dentro do OnInit do App...');
  }

  ngOnChanges(): void {
    console.log('Mudou o componente do App...');
  }
}
