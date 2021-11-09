package br.com.qualitylife.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
@Table(name="tb_categoria")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_categoria;
	
	@NotBlank(message = "O nome da categoria não pode ser nulo nem branco")	
	@Size(min = 3, max = 50, message = "O nome deve possuir entre 3 e 20 caracteres")
	private String nome;
	
	@NotNull(message = "O nome da categoria não pode ser nulo")	
	private String imagem;
	
	@NotNull(message = "O nome da categoria não pode ser nulo")	
	@Size(min = 30, max = 255,message = "A descricao deve possuir entre 30 e 200 caracteres" )
	private String descricao;

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
