package br.com.cerberus.utils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintUtils {

	private static final int BLANKSIZE = 30; 
	private static final String blankspace = Stream.generate(() -> " ").limit(BLANKSIZE).collect(Collectors.joining());
	
	public final static void separador() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ((BLANKSIZE * 2) + 2); i++) {
			sb.append("=");
		}
		System.out.println(sb);
	}
	public final static void cabecalho(String titulo) {
		String conteudo = "=" + blankspace + titulo + blankspace + "=" ;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < conteudo.length(); i++) {
			sb.append("=");
		}
		System.out.println(sb.toString());
		System.out.println(conteudo);
		System.out.println(sb.toString());
	}
}
