import { Component, OnInit } from '@angular/core';
import {Competidor} from "./competidor"
import {CompetidorService} from "./competidor.service"
import {Router, ActivatedRoute} from "@angular/router"
import Swal from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {
  public competidor: Competidor = new Competidor();
  public titulo:string = "Crear Competidor"
  constructor(private competidorService :CompetidorService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarCompetidor()
  }
  public create(): void{
    //console.log("Clicked!")
    //console.log(this.competidor)
    this.competidorService.create(this.competidor).subscribe(
      competidor => {
        this.router.navigate(['/competidores'])
        Swal.fire('Nuevo Competidor', `Competidor ${this.competidor.nombre} creado con exito`, 'success')
      }
    )
  }
  cargarCompetidor(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.competidorService.getCompetidor(id).subscribe( (cliente) => this.competidor = cliente)
      }
    })
  }
  update():void{
    this.competidorService.update(this.competidor)
      .subscribe( cliente => {
          this.router.navigate(['/competidores'])
          Swal.fire('Competidor Actualizado', `competidor ${this.competidor.nombre} actualizado con éxito!`, 'success')
        }

      )
  }
}
