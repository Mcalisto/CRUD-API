import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empresa } from '../Empresa';

var baseUrl = "http://localhost:8080/empresa/";

@Injectable({
  providedIn: 'root'
})

export class EmpresaService {

  empresa!: Empresa;

  constructor(private httpClient: HttpClient) { }

   inserirEmpresa(empresa: Empresa): Observable<Object>{
    return this.httpClient.post(`${baseUrl +"inserirempresa"}`, empresa);
  }
 
  editarEmpresa(id: number, empresa: Empresa): Observable<Object>{
    return this.httpClient.put(`${baseUrl +"editar"}/${id}`, empresa);
  }

  deletarEMpresa(id: number): Observable<Object>{
    return this.httpClient.delete(`${baseUrl +"deletar"}/${id}`);
  }

  carregarEmpresa(id: number): Observable<Empresa>{
    return this.httpClient.get<Empresa>(`${"carregar"}/${id}`);
  }
}
