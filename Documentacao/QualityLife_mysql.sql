CREATE TABLE `tb_produto` (
	`id_produto` bigint(4) NOT NULL AUTO_INCREMENT,
	`nome` varchar(50) NOT NULL,
	`imagem` varchar(255) NOT NULL,
	`descricao` varchar(255) NOT NULL,
	`preco` DECIMAL(7,2) NOT NULL,
	`fk_id_categoria` bigint(4) NOT NULL,
	`fk_id_usuario` bigint(4) NOT NULL,
	PRIMARY KEY (`id_produto`)
);

CREATE TABLE `tb_categoria` (
	`id_categoria` bigint(4) NOT NULL AUTO_INCREMENT,
	`nome` varchar(50) NOT NULL,
	`imagem` varchar(255) NOT NULL,
	`descricao` varchar(255) NOT NULL,
	PRIMARY KEY (`id_categoria`)
);

CREATE TABLE `tb_usuario` (
	`id_usuario` bigint(4) NOT NULL AUTO_INCREMENT,
	`nome` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`senha` varchar(16) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

ALTER TABLE `tb_produto` ADD CONSTRAINT `tb_produto_fk0` FOREIGN KEY (`fk_id_categoria`) REFERENCES `tb_categoria`(`id_categoria`);

ALTER TABLE `tb_produto` ADD CONSTRAINT `tb_produto_fk1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `tb_usuario`(`id_usuario`);




