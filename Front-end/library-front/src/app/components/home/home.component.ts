import { Component, OnInit } from '@angular/core';
import { HomeService, Libro } from '../../services/home.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public busqueda: string;
  public tipoBusqueda: string[] = ['TITULO','AUTOR','AÑO'];
  public tipoSeleccionado: string;
  public libros: Libro[] = [];
  constructor(private _homeService : HomeService) { }

  ngOnInit(): void {
  }

  buscar(): void{
    this._homeService.getLibros(this.busqueda,this.tipoSeleccionado).subscribe((response: any) => {
      this.libros = response.content as Libro[];
    }
    );
  }
}
