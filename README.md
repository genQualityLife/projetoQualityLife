# projetoQualityLife

# Atividade DER + Banco de Dados – Blog Pessoal

## 1) Mostrar o DER 

Esse link mostrará o DER ->https://dbdesigner.page.link/5wjc6yVKzRuHoTNj6

Link para o PDF -> https://github.com/genQualityLife/projetoQualityLife/blob/main/Documentacao/DER%20QualityLife.pdf

## 2) Dicionário de dados

<div>

### Produto
 
<table>
  <thead>
    <th> Restrições de domínio </th>
    <th> Atributos</th>
    <th> Tipo de dado</th>
    <th> Tamanho </th>
    <th> Descrição </th>
  </thead>
  <tbody>
    <tr>
      <td> PK | Not Null </td>
      <td> Id </td>
      <td> bigint </td>
      <td></td>
      <td> Código de identificação da tabela Produtos </td>
    <tr>
      <td> Not null </td>
      <td> Nome_Produto </td>
      <td> Varchar </td>
      <td> 20 </td>
      <td> Nome do Produto </td>
    </tr>
    <tr>
      <td> Not Null </td>
      <td> Imagens_Produto </td>
      <td> Varchar </td>
      <td> 255 </td>
      <td> Imagens que mostrarão o produto </td>
    </tr>
    <tr>
      <td> Not Null </td>
      <td> Descricao </td>
      <td> varchar </td>
      <td> 255 </td>
      <td> Uma breve descrição sobre o produto</td>
    </tr>
    <tr>
      <td> Not Null </td>
      <td> Preco </td>
      <td> decimal </td>
      <td> 7,2 </td>
      <td> Preço do Produto</td>
    </tr>
    <tr>
      <td>FK | Not Null</td>
      <td> Id_Categoria  </td>
      <td> bigint </td>
      <td> 4 </td>
      <td>Chave estrangeira referenciando o id da tabela Categoria </td>
    </tr>
    <tr>
      <td>FK | Not Null</td>
      <td> Id_Usuario </td>
      <td> bigint </td>
      <td> 4 </td>
      <td>Chave estrangeira referenciando o id da tabela Usuario</td>
    </tr>
  </tbody>
</table>

### Temas
<table>
  <thead>
    <th> Restrições de domínio </th>
    <th> Atributos</th>
    <th> Tipo de dado</th>
    <th> Tamanho </th>
    <th> Descrição </th>
  </thead>
  <tbody>
    <tr>
      <td>PK </td>
      <td> Id </td>
      <td> bigint</td>
      <td></td>
      <td>Código de identificação da tabela Temas</td>
    <tr>
      <td>Not Null</td>
      <td> Descricao </td>
      <td> Varchar </td>
      <td>255</td>
      <td> Descrição do tema </td>
    </tr>
  </tbody>
</table>

### Usuário
<table>
  <thead>
    <th> Restrições de domínio </th>
    <th> Atributos</th>
    <th> Tipo de dado</th>
    <th> Tamanho </th>
    <th> Descrição </th>
  </thead>
  <tbody>
    <tr>
      <td>PK</td>
      <td> Id </td>
      <td> bigint</td>
      <td></td>
      <td>Código de identificação da tabela Usuário</td>
    <tr>
      <td>Not Null</td>
      <td> Nome </td>
      <td> Varchar </td>
      <td>255</td>
      <td> Nome dos usuários</td>
    </tr>
    <tr>
      <td>Not Null</td>
      <td> Usuario </td>
      <td> Varchar </td>
      <td>255</td>
      <td> Login do usuário </td>
    </tr>
    <tr>
      <td>Not Null</td>
      <td> Senha </td>
      <td> varchar </td>
      <td>255</td>
      <td>Senha do usuário</td>
    </tr>
  </tbody>
</table>
</div>

<br>

## 3) DER do Blog Pessoal 

 
 <img src = "https://github.com/genQualityLife/projetoQualityLife/blob/main/Documentacao/DER%20QualityLife.jpeg"> </img>
      

## 4) Código em SQL 

        CREATE TABLE `tb_produto` (
          `id_produto` bigint NOT NULL AUTO_INCREMENT,
          `nome_produto` varchar(20) NOT NULL,
          `imagens_produto` varchar(255) NOT NULL,
          `descricao` varchar(255) NOT NULL,
          `preco` DECIMAL(7,2) NOT NULL,
          `fk_id_categoria` bigint(4) NOT NULL,
          `fk_id_usuario` bigint(4) NOT NULL,
          PRIMARY KEY (`id_produto`)
        );

        CREATE TABLE `tb_categoria` (
          `id_categoria` bigint(4) NOT NULL AUTO_INCREMENT,
          `nome_categoria` varchar(20) NOT NULL,
          `imagem` varchar(255) NOT NULL,
          `descricao` varchar(255) NOT NULL,
          PRIMARY KEY (`id_categoria`)
        );

        CREATE TABLE `tb_usuario` (
          `id_usuario` bigint(4) NOT NULL AUTO_INCREMENT,
          `nome_usuario` varchar(40) NOT NULL,
          `email` varchar(50) NOT NULL,
          `senha` varchar(16) NOT NULL,
          PRIMARY KEY (`id_usuario`)
        );

        ALTER TABLE `tb_produto` ADD CONSTRAINT `tb_produto_fk0` FOREIGN KEY (`fk_id_categoria`) REFERENCES `tb_categoria`(`id_categoria`);

        ALTER TABLE `tb_produto` ADD CONSTRAINT `tb_produto_fk1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `tb_usuario`(`id_usuario`);







