import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'; 
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { DatePipe } from '@angular/common';
@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private urlEndpoint = 'http://localhost:8080/Library/libro/obtener-por-filtro/';
  constructor(private http: HttpClient,public datepipe: DatePipe) { }


  getLibros(busqueda: String , tipo: string): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.get(this.urlEndpoint + tipo  + '/' + busqueda, httpOptions).pipe(
      catchError( e => {
     
        return throwError(e);
      })
    );
  }
}
export interface tipoBusqueda {
  tipo: string;
}


export class Libro {
  id: number;
  titulo: string;
  anio: string;
  genero: string;
  numeroPaginas: number;
}