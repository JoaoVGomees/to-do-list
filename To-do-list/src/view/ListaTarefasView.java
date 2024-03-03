package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.TarefaDAO;
import model.Tarefa;

public class ListaTarefasView extends JFrame {

    private JLabel lblLista = new JLabel("Lista de tarefas: ");
    private JList<String> listaTarefas = new JList<>();
    private JButton btnNovo = new JButton("Nova Tarefa");
    private JButton btnEditar = new JButton("Editar Tarefa");
    private JButton btnConcluir = new JButton("Concluir Tarefa");

    private List<Tarefa> tarefas = new ArrayList<>();
    private int indiceSelecionado = -1;

    public ListaTarefasView() {
        inicializar();
        acoes();

        TarefaDAO dao = new TarefaDAO();
        tarefas = dao.lerTarefa();

        preencherTarefa();
    }

    private void inicializar() {
        this.setLayout(null);
        this.btnNovo.setBounds(50, 30, 150, 20);
        this.btnEditar.setBounds(220, 30, 150, 20);
        this.btnConcluir.setBounds(390, 30, 150, 20);
        this.lblLista.setBounds(50, 70, 300, 20);
        this.listaTarefas.setBounds(50, 90, 500, 160);

        this.getContentPane().add(btnNovo);
        this.getContentPane().add(btnEditar);
        this.getContentPane().add(btnConcluir);
        this.getContentPane().add(lblLista);
        this.getContentPane().add(listaTarefas);

        this.setSize(800, 600);
        this.setVisible(true);
    }

    public void acoes() {
    	btnNovo.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	NovaTarefaView novaTarView = new NovaTarefaView();
    	        novaTarView.show();
    	        
    	        Tarefa temp = novaTarView.getTarefa();
    	        tarefas.add(temp);
    	        
    	        TarefaDAO dao = new TarefaDAO();
    	        try {
    	            dao.gravarTarefa(tarefas);
    	        } catch (Exception e1) {
    	            JOptionPane.showMessageDialog(novaTarView, e1.getMessage());
    	        }
    	        
    	        preencherTarefa();
    	        
    	    }
    	});


        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceSelecionado != -1) {
                    Tarefa tarefaSelecionada = tarefas.get(indiceSelecionado);
                    EditarTarefaView editarTarefaView = new EditarTarefaView(tarefaSelecionada);
                    editarTarefaView.setVisible(true);

                    tarefas.set(indiceSelecionado, editarTarefaView.getTarefa());
                    preencherTarefa();
                } else {
                    JOptionPane.showMessageDialog(ListaTarefasView.this, "Selecione uma tarefa para editar.");
                }
            }
        });

        btnConcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceSelecionado != -1) {
                    Tarefa tarefaSelecionada = tarefas.get(indiceSelecionado);
                    tarefaSelecionada.setFeito(true); 
                    preencherTarefa(); 
                } else {
                    JOptionPane.showMessageDialog(ListaTarefasView.this, "Selecione uma tarefa para concluir.");
                }
            }
        });
        
        listaTarefas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    indiceSelecionado = listaTarefas.getSelectedIndex();
                }
            }
        });
    }

    private void preencherTarefa() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Tarefa tarefa : tarefas) {
            model.addElement(tarefa.toString()); 
        }
        listaTarefas.setModel(model);
    }

   
}
