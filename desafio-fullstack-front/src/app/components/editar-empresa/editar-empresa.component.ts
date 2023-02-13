import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empresa } from '../../Empresa';
import { EmpresaService } from '../../service/empresa.service';
import { HttpproviderService } from '../../service/httpprovider.service';

@Component({
  selector: 'app-editar-empresa',
  templateUrl: './editar-empresa.component.html',
  styleUrls: ['./editar-empresa.component.css']
})
export class EditarEmpresaComponent {

  empresa: Empresa = new Empresa();
  empresaAux: Empresa[]=[];
  id!: number;
  constructor(private httpservice: HttpproviderService, private empresaService: EmpresaService,
    private router: Router, private route: ActivatedRoute){ }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.empresaService.carregarEmpresa(this.id).subscribe(data => {
      this.empresa = data;
    }, error => console.log(error));
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
