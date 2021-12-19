package br.com.qualitylife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.qualitylife.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
	
	
	@Query (value="select * from tb_produto as prod inner join tb_categoria as cat on fk_id_categoria = id_categoria \n"
			+ "		where cat.nome like %:categoria%", nativeQuery=true)
	public List<ProdutoModel> findAllByCategoriaContainingIgnoreCase(@Param("categoria") String categoria);
}
