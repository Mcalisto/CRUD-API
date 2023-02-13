import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


var baseUrl = "http://localhost:8080/";
var listarEmpresas = baseUrl + "empresa/listaempresas"
var listarFornecedores = baseUrl + "fornecedor/listafornecedores"

@Injectable({
  providedIn: 'root'
})

export class HttpproviderService {
  

  constructor(private httpClient: HttpClient) { }

  listarEmpresas(): Observable<any> {
      return this.httpClient.get(listarEmpresas);
   }

   listarFornecedores(): Observable<any> {
    return this.httpClient.get(listarFornecedores);
 }
 

}
