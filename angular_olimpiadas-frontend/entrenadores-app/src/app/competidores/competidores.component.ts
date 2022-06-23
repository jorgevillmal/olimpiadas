import { Component, OnInit } from '@angular/core';
import {Competidor} from './competidor'
import {Competidores} from './competidores.jason';
import {CompetidorService} from "./competidor.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-competidores',
  templateUrl: './competidores.component.html',
})
export class CompetidoresComponent implements OnInit {
  competidores: Competidor[];
  constructor(private competidorService: CompetidorService) { }

  ngOnInit(): void {
    this.competidorService.getCompetidores().subscribe(
      competidores => this.competidores = competidores
    );
  }
  delete(competidor: Competidor): void {
    Swal.fire({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar al cliente ${competidor.nombre} ${competidor.apellido}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      buttonsStyling: false,
      reverseButtons: true
    }).then((result) => {
      if (result.value) {
        this.competidorService.delete(competidor.id).subscribe(
          response => {
            this.competidores = this.competidores.filter(cli => cli !== competidor)
            Swal.fire(
              'Cliente Eliminado!',
              `Cliente ${competidor.nombre} eliminado con éxito.`,
              'success'
            )
          })
      }
    })
  }
}
