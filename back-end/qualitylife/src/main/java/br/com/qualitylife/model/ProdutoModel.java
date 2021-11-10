package br.com.qualitylife.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produto;
	
	@NotBlank(message = "O nome do produto não pode ser branco nem nulo!")
	@Size(min = 3, max = 50, message = "O nome do produto deve ter entre 3 e 50 caracteres.")
	private String nome;
	
	@NotBlank(message = "A imagem do produto não pode ser branco nem nulo!")
	@Size(min = 3, max = 255, message = "A imagem do produto deve ter entre 3 e 255 caracteres.")
	private String imagem;
	
	@NotBlank(message = "A descrição do produto não pode ser branco nem nulo!")
	@Size(min = 3, max = 255, message = "A descrição do produto deve ter entre 3 e 255 caracteres.")
	private String descricao;
	
	@NotNull(message = "O preço do produto é obrigatório!")
	@Positive(message = "O preço do produto deve ser maior que zero.")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private BigDecimal preco;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	@JoinColumn(name = "fk_id_categoria")
	private CategoriaModel categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	@JoinColumn(name = "fk_id_usuario")
	private UsuarioModel usuario;

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	
}
