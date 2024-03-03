package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Tarefa;

public class NovaTarefaView extends JDialog{

	JLabel lblNome = new JLabel("Nome da tarefa:");
	JTextField txtNome = new JTextField(null, 20);
	JLabel lblDesc = new JLabel("Descrição da tarefa:");
	JTextField txtDesc = new JTextField(null, 50);
	JButton btnGravar = new JButton("Adicionar"); 
	
	private Tarefa tarefa = new Tarefa();
	
	public NovaTarefaView() {
		this.setLayout(new FlowLayout()); 	
		this.getContentPane().add(lblNome);
		this.getContentPane().add(txtNome);
		
		this.getContentPane().add(lblDesc);
		this.getContentPane().add(txtDesc);		
		
		this.getContentPane().add(btnGravar); 


	
	btnGravar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			tarefa.setNome(txtNome.getText());
			tarefa.setDescricao(txtDesc.getText());
			
			hide();
		}
	});
	
	this.setModal(true); 
	this.setSize(600, 480);
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	
}
