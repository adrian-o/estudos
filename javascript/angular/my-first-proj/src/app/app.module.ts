import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TitleComponent } from './title/title.component';
import { DatabindingComponent } from './databinding/databinding.component';
import { DiretivasComponent } from './diretivas/diretivas.component';


@NgModule({
  declarations: [
    AppComponent,
    TitleComponent,
    DatabindingComponent,
    DiretivasComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
