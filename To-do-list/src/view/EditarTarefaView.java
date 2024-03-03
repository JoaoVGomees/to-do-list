package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Tarefa;

public class EditarTarefaView extends JDialog {

    JLabel lblNome = new JLabel("Novo Nome da Tarefa:");
    JTextField txtNome = new JTextField(null, 20);
    JLabel lblDesc = new JLabel("Nova Descrição da Tarefa:");
    JTextField txtDesc = new JTextField(null, 50);
    JButton btnEditar = new JButton("Editar");
    

    private Tarefa tarefa;

    public EditarTarefaView(Tarefa tarefa) {
        this.tarefa = tarefa;

        this.setLayout(new FlowLayout());
        this.getContentPane().add(lblNome);
        this.getContentPane().add(txtNome);

        this.getContentPane().add(lblDesc);
        this.getContentPane().add(txtDesc);

        this.getContentPane().add(btnEditar);

        txtNome.setText(tarefa.getNome());
        txtDesc.setText(tarefa.getDescricao());

        btnEditar.addActionListener(new ActionListener() {
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
