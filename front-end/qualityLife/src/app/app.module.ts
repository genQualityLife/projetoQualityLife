import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { LoginComponent } from './login/login.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { CategoriasComponent } from './categorias/categorias.component';
import { ProdutoEditComponent } from './edit/produto-edit/produto-edit.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { ProdutoDeleteComponent } from './delete/produto-delete/produto-delete.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    RodapeComponent,
    CadastroComponent,
    LoginComponent,
    ProdutosComponent,
    CategoriasComponent,
    ProdutoEditComponent,
    CategoriaEditComponent,
    ProdutoDeleteComponent,
    CategoriaDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
