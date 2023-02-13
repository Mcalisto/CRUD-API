import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Empresa } from 'src/app/Empresa';
import { EmpresaService } from 'src/app/service/empresa.service';
import { HttpproviderService } from 'src/app/service/httpprovider.service';

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent {

  empresa: Empresa = new Empresa();
  empresaAux: Empresa[]=[];
  existe = false;
  constructor(private httpservice: HttpproviderService, private empresaService: EmpresaService,
    private router: Router){ }

  ngOnInit(): void {

  }

  inserirEmpresa(){
      this.empresaService.inserirEmpresa(this.empresa).subscribe( data =>{
        console.log(data);
        this.home();
      },
      error => console.log(error));
  }


  home(){
    this.router.navigate(['/home']);
  }
  
  onSubmit(){
    console.log(this.empresa);
    this.inserirEmpresa();
  }

}

