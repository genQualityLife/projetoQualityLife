import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';
import { AuthService } from '../service/auth.service';
import { CategoriasService } from '../service/categorias.service';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

  categoria: Categoria = new Categoria()
  listaCategorias: Categoria[]

  constructor(
    private categoriaService: CategoriasService,
    private router: Router
  ) { }

  ngOnInit(){
    window.scroll(0,0)

    if(environment.token == ''){
      alert('Sua sessão expirou, faça o login novamente.')
      this.router.navigate(['/login'])
    }

    this.findAllCategorias()
  }

  findAllCategorias(){
    this.categoriaService.getAllCategorias().subscribe((resp: Categoria[]) => {
      this.listaCategorias = resp
    })
  }

  cadastrar(){
    this.categoriaService.postCategorias(this.categoria).subscribe((resp: Categoria) => {
      this.categoria = resp
      alert('Categoria cadastrada com sucesso!')
      this.findAllCategorias()
      this.categoria = new Categoria()
    })
  }

}
