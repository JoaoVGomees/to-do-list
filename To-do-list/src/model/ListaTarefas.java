package model;

import java.util.ArrayList;

import util.Log;

public class ListaTarefas {

	private ArrayList<Tarefa> lista;
	
	public ListaTarefas() {
		this.lista = new ArrayList<Tarefa>();
	}
	
	public void addTarefa(Tarefa tarefa) {
		lista.add(tarefa);
	}
	
	public void removeTarefa(int indexTarefa) {
		if(indexTarefa < 0 || indexTarefa > lista.size()) {
			Log.escrever("Tarefa não encontrada para remover");
		}
		lista.remove(indexTarefa);
	}
	
	public void marcarTarefaConcluida(int index) {
	    if (index >= 0 && index < lista.size()) {
	        Tarefa tarefa = lista.get(index);
	        
	        if(tarefa.getFeito() == false) {
	        	tarefa.setFeito(true);
	        } else {
	        	Log.escrever("Tarefa ja foi marcada como conluída");
	        }
	    
	    } else {
	        Log.escrever("Índice inválido");
	    }
	}
	
}
