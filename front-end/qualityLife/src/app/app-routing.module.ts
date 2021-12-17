import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArtigosComponent } from './artigos/artigos.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { CategoriasComponent } from './categorias/categorias.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { ProdutoDeleteComponent } from './delete/produto-delete/produto-delete.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { ProdutoEditComponent } from './edit/produto-edit/produto-edit.component';
import { LoginComponent } from './login/login.component';
import { ProdutosComponent } from './produtos/produtos.component';

const routes: Routes = [
  {path: '', redirectTo: 'produtos', pathMatch: 'full'},

  {path: 'login', component: LoginComponent},
  {path: 'cadastro', component: CadastroComponent},
  {path: 'produtos', component: ProdutosComponent},
  {path: 'categorias', component: CategoriasComponent},
  { path: 'categoria-edit/:id', component: CategoriaEditComponent },
  { path: 'categoria-delete/:id', component: CategoriaDeleteComponent },
  { path: 'produto-edit/:id', component: ProdutoEditComponent },
  { path: 'produto-delete/:id', component: ProdutoDeleteComponent },
  { path: 'artigos', component: ArtigosComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
