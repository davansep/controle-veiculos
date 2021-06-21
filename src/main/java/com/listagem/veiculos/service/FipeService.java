package com.listagem.veiculos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.listagem.veiculos.models.ModeloFipe;
import com.listagem.veiculos.models.ModelosFipe;
import com.listagem.veiculos.models.RetornoFipe;
import com.listagem.veiculos.models.VeiculoFipe;

@Service
public class FipeService {

	
	VeiculoFipe BuscarVeiculoFipe(String marca, String modelo, String ano)
    {
    	RestTemplate restTemplate = new RestTemplate();
    	RetornoFipe[] marcas = restTemplate.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas", RetornoFipe[].class);
    	
    	var codMarcaEncontrada = "";
    	
    	for (RetornoFipe retornoFipe : marcas) {
    		var marcaFipe = retornoFipe.getNome().trim().toUpperCase();

			if (marcaFipe.equals(marca.trim().toUpperCase())) {
				codMarcaEncontrada = retornoFipe.getCodigo();
			}
		}
    	
    	ModelosFipe modelosFipe = restTemplate.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+codMarcaEncontrada+"/modelos", ModelosFipe.class);
    	
    	var codModeloEncontrado = "";
    	var modelos = modelosFipe.getModelos();
    	
    	for (ModeloFipe retornoFipe : modelos) {
    		var marcaFipe = retornoFipe.getNome().trim().toUpperCase();
    		
			if (marcaFipe.equals(modelo.trim().toUpperCase())) {
				codModeloEncontrado = retornoFipe.getCodigo();
			}
		} 
    	
    	RetornoFipe[] anos = restTemplate.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+codMarcaEncontrada+"/modelos/"+codModeloEncontrado+"/anos", RetornoFipe[].class);
    	
    	var anoEncontrado = "";
    	
    	for (RetornoFipe retornoFipe : anos) {
    		var anoFipe = retornoFipe.getNome().trim().toUpperCase();
    		
			if (anoFipe.indexOf(ano.trim()) > -1) {
				anoEncontrado = retornoFipe.getCodigo();
			}
		}  
    	    	
    	VeiculoFipe veiculo = restTemplate.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+codMarcaEncontrada+"/modelos/"+codModeloEncontrado+"/anos/"+anoEncontrado, VeiculoFipe.class);
    	
    	return veiculo;    	
    }
}
