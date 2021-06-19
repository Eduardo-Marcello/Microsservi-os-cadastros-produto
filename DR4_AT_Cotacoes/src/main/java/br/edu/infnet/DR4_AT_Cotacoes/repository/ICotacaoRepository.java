package br.edu.infnet.DR4_AT_Cotacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.DR4_AT_Cotacoes.model.negocio.Cotacao;
import br.edu.infnet.DR4_AT_Cotacoes.model.negocio.Produto;

@Repository
public interface ICotacaoRepository extends JpaRepository<Cotacao, Short> {
	@Query(value = "SELECT p FROM Produto p WHERE p.nomeProduto LIKE '%' || :keyword || '%'")
    public Produto search(@Param("keyword") String keyword);
}
