package controller;

import java.util.ArrayList;
import java.util.List;

import dao.TarefaDAO;
import model.Tarefa;
import util.Log;
import view.ListaTarefasView;

public class ListaController {

	public static void main(String[] args) {
		
		ListaTarefasView tarView = new ListaTarefasView();
		
		Tarefa tar1 = new Tarefa("Sei lá", "SEI LA NA DESCRIÇÃO", false);
		Tarefa tar2 = new Tarefa("Sei lá2", "SEI LA NA DESCRIÇÃO2", false);
		Tarefa tar3 = new Tarefa("Sei lá3", "SEI LA NA DESCRIÇÃO3", false);
		
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		listaTarefas.add(tar1);
		listaTarefas.add(tar2);
		listaTarefas.add(tar3);

		TarefaDAO dao = new TarefaDAO();
		try {
			dao.gravarTarefa(listaTarefas);
			Log.escrever("Sucesso em gravar as Tarefas");
		} catch (Exception e) {
			Log.escrever("O erro: " + e);
		}
		
	}

}
