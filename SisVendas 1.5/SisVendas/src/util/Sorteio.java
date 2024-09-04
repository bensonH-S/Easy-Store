package util;

import java.util.List;
import java.util.Random;

public class Sorteio {
	private static Random rand = new Random();
	private static char[] letras = "0123456789".toCharArray();

	public String sortearNumero(int length, List<String> lista) {		
		String a = numeroAleatorio(length);
		while (lista.contains(a)) {
			a = numeroAleatorio(length);				
		}			
		return a;	
	}


	private String numeroAleatorio(int nCaracteres) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nCaracteres; i++) {
			int ch = rand.nextInt (letras.length);
			sb.append (letras [ch]);
		}    
		return sb.toString();    
	}

}
