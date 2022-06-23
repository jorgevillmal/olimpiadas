import { Component, OnInit } from '@angular/core';
import {Competidor} from "./competidor";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {
  public competidor: Competidor = new Competidor();
  public titulo:string = "Crear Competidor"
  constructor() { }

  ngOnInit(): void {
  }
  public create(): void{
    console.log("Clicked!")
    console.log(this.competidor)
  }
}
