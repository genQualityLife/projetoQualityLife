import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';
import { Produto } from '../model/Produto';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import { CategoriasService } from '../service/categorias.service';
import { ProdutosService } from '../service/produtos.service';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.css']
})
export class ProdutosComponent implements OnInit {

  categoria: Categoria = new Categoria()
  produto: Produto = new Produto()
  usuario: Usuario = new Usuario()
  listaCategorias: Categoria[]
  listaProdutos: Produto[]
  idCategoria: number
  idUsuario = environment.id


  constructor(
    private produtoService: ProdutosService,
    private categoriaService: CategoriasService,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(){
    window.scroll(0,0)

    this.findAllCategorias()
    this.getAllProdutos()
  }

  findAllCategorias(){
    this.categoriaService.getAllCategorias().subscribe((resp: Categoria[]) => {
      this.listaCategorias = resp
    })
  }

  findByIdCategorias(){
    this.categoriaService.getByIdCategorias(this.idCategoria).subscribe((resp: Categoria) => {
      this.categoria = resp
    })
  }

  getAllProdutos(){
    this.produtoService.getAllProdutos().subscribe((resp: Produto[]) => {
      this.listaProdutos = resp
    })
  }

  findByIdUsuario(){
    this.authService.getByIdUsuario(this.idUsuario).subscribe((resp: Usuario) => {
      this.usuario = resp
    })
  }


  cadastrar(){

    this.categoria.id_categoria = this.idCategoria
    this.produto.categoria  = this.categoria
    this.usuario.id_usuario = this.idUsuario
    this.produto.usuario = this.usuario

    this.produtoService.postProduto(this.produto).subscribe((resp: Produto) => {
      this.produto = resp
      alert('Produto cadastrado com sucesso!')
      this.produto = new Produto()
      this.getAllProdutos()
    })
  }

}
