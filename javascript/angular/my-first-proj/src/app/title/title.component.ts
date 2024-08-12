import { AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, Input, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-title',
  templateUrl: './title.component.html'
})
export class TitleComponent implements OnInit, OnChanges, DoCheck { //, AfterContentInit, AfterContentChecked, AfterViewInit, AfterViewChecked, OnDestroy {

  @Input()
  public title:string = "Bem vindo!!!"

  @Input()
  public valor:number = 0

  public adicionar(): number {
    this.title = "Somou mais 1 a " + this.valor
    return this.valor += 1
  }

  ngOnInit(): void {
    console.log('Dentro do OnInit do Title...')
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log("Mudou o componente do Title...")
    for (const propName in changes) {
      const chng = changes[propName];
      const cur  = JSON.stringify(chng.currentValue);
      const prev = JSON.stringify(chng.previousValue);
      console.log(`${propName}: currentValue = ${cur}, previousValue = ${prev}`);
    }
  }


  ngDoCheck(): void {
    console.log("DoCheck do componente do Title...")
  }
/*
  ngAfterContentInit(): void {
    console.log("ContentInit do componente do Title...")
  }

  ngAfterContentChecked(): void {
    console.log("ContentChecked do componente do Title...")
  }

  ngAfterViewInit(): void {
    console.log("ViewInit do componente do Title...")
  }

  ngAfterViewChecked(): void {
    console.log("ViewChecked do componente do Title...")
  }

  ngOnDestroy(): void {
    console.log("DoDestroy do componente do Title...")
  }*/
}
