package dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Tarefa;
import util.Log;
import view.NovaTarefaView;

public class TarefaDAO {

	private String pathBanco = "C:\\Users\\shinmuraa\\Desktop\\testeArquivos\\BancoTarefas\\ListaDeTarefas.txt";

	public void gravarTarefa(List<Tarefa> tarefas) throws Exception  {
		
		// Escrita
		PrintWriter pw;
		try {
			pw = new PrintWriter(pathBanco, Charset.forName("UTF-8"));

			for (Tarefa t : tarefas) {
				pw.print(t.getNome());
				pw.print("; " + t.getDescricao());
				pw.println();
			}

			pw.close();
		} catch (Exception e) {
			Log.escrever("Erro ao tentar gravar tarefas: " + e.getMessage());
		}
	}
	
	public List<Tarefa> lerTarefa() {
		List<Tarefa> resposta = new ArrayList<Tarefa>();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(pathBanco));

			String linha;
			
			Tarefa temp;
			while ((linha = br.readLine()) != null) {

				String[] palavras = linha.split(";");
				temp = new Tarefa();
				temp.setNome(palavras[0]);
				temp.setDescricao(palavras[1]);
				
				resposta.add(temp);
			}

		} catch (Exception e) {
			Log.escrever("Erro lendo as tarefas: " + e.getMessage());	
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				Log.escrever(e.getMessage());	
			}
		}
		
		return resposta;
	}
	
	
}
