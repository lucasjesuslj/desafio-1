package br.com.itau;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import br.com.itau.modelo.Lancamento;
import br.com.itau.service.LancamentoService;

public class Exercicio {

	public static void main(String[] args) {
		List<Lancamento> lancamentos = new LancamentoService().listarLancamentos();
		
		//Gastos ordenados por meses.
		Comparator<Lancamento>  camparingMonth = Comparator.comparingInt(Lancamento::getMes);
		List<Lancamento> listagem_lancamentos= lancamentos.stream().sorted(camparingMonth).collect(Collectors.toList());
		System.out.println("Listagem de todos os Lançamentos:\n");
		listagem_lancamentos.forEach(System.out::println);
        
		//Escrever todos os lancamentos de uma mesma categoria de sua escolha.
        List<Lancamento> listagem_categoria = lancamentos.stream().filter(lancamento -> lancamento.getCategoria() == 1).collect(Collectors.toList());
        System.out.println("\nListagem dos Lançamentos de categoria 1:\n");
        listagem_categoria.forEach(System.out::println);
        
        //Mostrar o total da fatura de um mes em específico de sua escolha.
        System.out.println("\nFatura do mês 5 (Maio):\n");
    	Double total = lancamentos.stream().filter(lancamento -> lancamento.getMes() ==5).map(x -> x.getValor()).reduce((double) 0, Double::sum);
    	System.out.println(total);
        	    
        	    
	}

}
