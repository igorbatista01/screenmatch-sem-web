package br.com.igorpereira.screenmatch;

import br.com.igorpereira.screenmatch.model.DadoSerie;
import br.com.igorpereira.screenmatch.service.ConsumoApi;
import br.com.igorpereira.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		var  consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?i=tt3896198&apikey=369c723b");
//		System.out.println(json);

//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadoSerie dados = conversor.obterDados(json, DadoSerie.class);

	}
}
