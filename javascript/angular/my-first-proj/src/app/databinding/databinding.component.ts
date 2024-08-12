import { Component } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html'
})
export class DatabindingComponent {

  public nome: string = 'Adriano';
  public idade: number = 40;
  public idadeComp: number = 0;

  public position: {x: number, y: number} = {x: 0, y:0};

  public isDisabled: boolean = true;

  public mouseMoveEvent(event: MouseEvent): void {
    this.position.x = event.offsetX;
    this.position.y = event.offsetY;
  }

  public validaIdade(): string {
    console.log('Comparando as idades... '+ this.idade + ' - ' + this.idadeComp);
    return (this.idade == this.idadeComp) ? 'Acertou' : 'Errou';
  }

}
