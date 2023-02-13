import { Component, OnInit } from '@angular/core';
import { Empresa} from 'src/app/Empresa';
import { Fornecedor} from 'src/app/Fornecedor';
import { EmpresaService } from 'src/app/service/empresa.service';
import { HttpproviderService } from 'src/app/service/httpprovider.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  empresas!: Empresa[];
  fornecedores!: Fornecedor[];
  empresa!: Empresa;

  constructor(private httpservice: HttpproviderService, private empresaService: EmpresaService) { 
   
  }

  ngOnInit(): void {
    this.listarEmpresas();

  }

  listarEmpresas(){
    this.httpservice.listarEmpresas().subscribe(
      (res)=>{
        this.empresas = res;
      }
    );
  }

  listarFornecedores(){
    this.httpservice.listarFornecedores().subscribe(
      (res)=>{
        this.fornecedores = res;
      }
    );
  }

  inserirEmpresa(){
    this.empresaService.inserirEmpresa(this.empresa).subscribe();
  }

  editarEmpresa(id: number){
    this.empresaService.editarEmpresa(id, this.empresa).subscribe();
  }

  deletarEmpresa(id: number){
    this.empresaService.deletarEMpresa(id).subscribe();
  }

  
}
