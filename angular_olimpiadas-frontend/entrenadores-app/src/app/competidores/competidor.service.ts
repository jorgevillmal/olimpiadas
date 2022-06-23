import { Injectable } from '@angular/core';
import {Competidores} from "./competidores.jason";
import {Competidor} from "./competidor";
import {Observable,throwError} from "rxjs";
import { map, catchError, tap } from 'rxjs/operators';
import {of} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import Swal from "sweetalert2";
import { Router } from '@angular/router';

@Injectable()
export class CompetidorService {
  private urlEndPoint: string = 'http://localhost:8080/api/entrenadores';
  constructor(private http: HttpClient, private router: Router){ }

  private httpHeders= new HttpHeaders({'Content-type': 'application/json'})

  getCompetidores():Observable<Competidor[]>{
    //return of(Competidores);
    return this.http.get<Competidor[]>(this.urlEndPoint)
  }

  create(cliente:Competidor ) : Observable<any> {
    return this.http.post<any>(this.urlEndPoint,cliente , {headers:this.httpHeders}).pipe(
      map((response: any) => response.competidor as Competidor),
      catchError(e => {

        if (e.status == 400) {
          return throwError(e);
        }

        console.error(e.error.message);
        Swal.fire(e.error.message, e.error.error, 'error');
        return throwError(e);
      })
    );
  }
  getCompetidor(id): Observable<Competidor> {
    return this.http.get<Competidor>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e => {
        this.router.navigate(['/competidor']);
        console.error(e.error.message);
        Swal.fire('Error al editar', e.error.message, 'error');
        return throwError(e);
      })
    );
  }

  update(cliente: Competidor): Observable<Competidor>{
    return this.http.put<Competidor>(`${this.urlEndPoint}/${cliente.id}`, cliente, {headers: this.httpHeders}).pipe(
      catchError(e => {

        if (e.status == 400) {
          return throwError(e);
        }

        console.error(e.error.message);
        Swal.fire(e.error.message, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  delete(id: number): Observable<Competidor>{
    return this.http.delete<Competidor>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeders}).pipe(
      catchError(e => {
        console.error(e.error.message);
        Swal.fire(e.error.message, e.error.error, 'error');
        return throwError(e);
      })
    );
  }
}
