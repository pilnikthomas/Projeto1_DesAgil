package br.pro.hashi.ensino.desagil.tequilada;

import java.io.FileReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) {
		System.out.println("Projeto 1");
		
		try {
			
			FileReader labirinto = new FileReader("labirinto.txt");
			
			BufferedReader ler_labirinto = new BufferedReader(labirinto);
			
			String linha = ler_labirinto.readLine();
			
			while(linha != null) {
				caracter=linha.toCharArray();
				
				for(int i=0; i<caracter.length; i++){
					if (caracter[i]==("#")) {
						caracter[i]=("X");
					
					if (caracter[i]==(" ")) {
						caracter[i]=(" ");
					}
				
					}
				}
				System.out.println(caracter);
			}
		labirinto.close();
		}
		
	}
}
