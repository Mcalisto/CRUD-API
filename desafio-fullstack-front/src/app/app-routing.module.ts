import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpresaComponent } from './components/empresa/empresa.component';
import { FornecedorComponent } from './components/fornecedor/fornecedor.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: 'home/empresa', component: EmpresaComponent },
  { path: 'home/fornecedor', component: FornecedorComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
