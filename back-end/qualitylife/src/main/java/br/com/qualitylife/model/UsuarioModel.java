package br.com.qualitylife.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;

	@NotBlank(message = "O nome do usuário não pode ser branco nem nulo!")
	@Size(min = 3, max = 50, message = "O nome do usuário deve ter entre 3 e 50 caracteres.")
	private String nome;

	@ApiModelProperty(example = "email@email.com")
	@Email(message = "O e-mail do usuário deve ser válido!")
	@NotBlank(message = "O e-mail do usuário não pode ser branco nem nulo!")
	private String email;

	@NotBlank(message = "A senha do usuário não pode ser branca nem nula!")
	@Size(min = 8, message = "A senha do usuário deve ter entre 8 e 16 caracteres.")
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<ProdutoModel> produto;

	public UsuarioModel(long id, String nome, String email, String senha) {
		this.id_usuario = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public UsuarioModel() {

	} 

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

}
