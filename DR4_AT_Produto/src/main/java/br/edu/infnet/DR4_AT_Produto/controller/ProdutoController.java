package br.edu.infnet.DR4_AT_Produto.controller;

import br.edu.infnet.DR4_AT_Produto.model.negocio.Csv;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.edu.infnet.DR4_AT_Produto.model.negocio.Produto;
import br.edu.infnet.DR4_AT_Produto.model.service.AmazonClient;
import br.edu.infnet.DR4_AT_Produto.model.service.ProdutoService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	private AmazonClient amazonClient;

	@Autowired
	public ProdutoController(ProdutoService produtoService, AmazonClient amazonClient) {
		this.produtoService= produtoService;
		this.amazonClient = amazonClient;
	}
	
	@PostMapping("/registraProduto")
	public Produto registra(int codigoProduto, String nomeProduto,  String classificacao, @RequestPart(value = "file") MultipartFile file) {
		amazonClient.uploadFile(file);
		return produtoService.registra(codigoProduto,nomeProduto,classificacao);
	}
	
	@PostMapping("/ListaCotacoes")
	public Iterable<Produto> listagemCotacoes(){
		
		return produtoService.findListagem();
	}
        
        @PostMapping("/ExportarCotacoes")
	public List<Csv> exportarArquivo(){
		Iterable<Produto> cotacoes = produtoService.findListagem();
		
		try {
			return produtoService.exportarCotacoes(cotacoes);
		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping(value = "/deletaProduto/{id}")
	public void excluir(@PathVariable Short id) {
		produtoService.excluir(id);	
	}
	
	@DeleteMapping("/deleteFile")
	public String deleteFile(@RequestPart(value = "url") String fileUrl) {
		return this.amazonClient.deleteFileFromBucketS3(fileUrl);
	}
	
}