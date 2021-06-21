package br.edu.infnet.DR4_AT_Produto.model.service;

import br.edu.infnet.DR4_AT_Produto.model.negocio.Cotacao;
import br.edu.infnet.DR4_AT_Produto.model.negocio.Csv;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.DR4_AT_Produto.model.negocio.Produto;
import br.edu.infnet.DR4_AT_Produto.model.repository.IProdutoRepository;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class ProdutoService {
	
		@Autowired
		private IProdutoRepository pr;
		
		public ProdutoService(IProdutoRepository pr) {
	        this.pr = pr;
	    }
		
		public Produto registra(int codigoProduto, String nomeProduto, String classificacao) {
			Produto produto = new Produto(codigoProduto, nomeProduto, classificacao);
			return this.pr.save(produto);
		}
		
		public Produto findByKeyword(String keyword) {
			return pr.search(keyword);
		}
		
		public Iterable<Produto> findListagem(){
			Iterable<Produto> p = pr.findCotacoes();

			return p;
		}
		
		public Short findIdByKeyword(String keyword) {
			return pr.search(keyword).getIdProduto();
		}
		
		public void excluir(Short id) {
			this.pr.deleteById(id);
		}
                
		public List<Csv> exportarCotacoes(Iterable<Produto> cotacoes)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<Csv> cots = new ArrayList<>();
		for (Produto p : cotacoes) {
			Iterable<Cotacao> c = p.getCotacoes();
			for(Cotacao cs: c) {
				cots.add(new Csv(p.getIdProduto(), cs.getId(), p.getNomeProduto(), cs.getPreco()));
			}
		}
		Writer writer = Files.newBufferedWriter(Paths.get("cotacoes.csv"));
		StatefulBeanToCsv<Csv> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

		beanToCsv.write(cots);

		writer.flush();
		writer.close();
		return cots;
	}
}

