import { Injectable } from '@angular/core';
import {Competidores} from "./competidores.jason";
import {Competidor} from "./competidor";
import {Observable} from "rxjs";
import {of} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class CompetidorService {
  private urlEndPoint: string = 'http://localhost:8080/api/entrenadores';
  constructor(private http: HttpClient) { }

  getCompetidores():Observable<Competidor[]>{
    //return of(Competidores);
    return this.http.get<Competidor[]>(this.urlEndPoint)
  }

  create(cliente: )
}
