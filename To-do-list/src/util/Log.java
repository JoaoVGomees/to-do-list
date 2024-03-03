package util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.LocalDate;

public class Log {

	private static String pathLog = "C:\\Users\\shinmuraa\\Desktop\\testeArquivos\\Log-to-do-list";
	
	public static boolean escrever(String frase) {
		String pathDestino = pathLog 
				+ LocalDate.now().getYear() + "_"
				+ LocalDate.now().getMonth() + "_"
				+ LocalDate.now().getDayOfMonth() + ".log";
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(pathDestino, Charset.forName("UFT-8"), true));
			
			pw.append(frase).append("\n");
			pw.close();
			
			return true;
			
		} catch (Exception e) {
			System.err.println("Erro em escrever: " + e.getMessage());
			return false;
		}
		
	}
	
	public void ler() {}
	
}
