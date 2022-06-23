import { Component, OnInit } from '@angular/core';
import {Competidor} from './competidor'
import {Competidores} from './competidores.jason';
import {CompetidorService} from "./competidor.service";

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

}
