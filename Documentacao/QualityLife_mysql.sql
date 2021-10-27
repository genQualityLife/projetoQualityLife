CREATE TABLE `tb_produto` (
	`id_produto` bigint NOT NULL AUTO_INCREMENT,
	`nome_produto` varchar(20) NOT NULL,
	`imagens_produto` varbinary(4) NOT NULL,
	`quantidade` int(50) NOT NULL,
	`descricao` varchar(255) NOT NULL,
	`preco` DECIMAL(7,2) NOT NULL,
	`risco` int(10) NOT NULL,
	`fk_id_categoria` bigint(4) NOT NULL,
	`fk_id_usuario` bigint(4) NOT NULL,
	PRIMARY KEY (`id_produto`)
);

CREATE TABLE `tb_categoria` (
	`id_categoria` bigint(4) NOT NULL AUTO_INCREMENT,
	`nome_categoria` varchar(20) NOT NULL,
	`imagem` varbinary(4) NOT NULL,
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




