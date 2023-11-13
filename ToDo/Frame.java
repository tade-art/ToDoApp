import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Frame extends JFrame{

    private DefaultListModel<String> toDoListModel;
    private JList<String> toDoList;
    private JTextField taskInput;
    private JButton addButton =new JButton("Add Task");

    
    public Frame(){
        setTitle("To-Do Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setUpContent();
    }

    private void setUpLayout(){
        setLayout(new BorderLayout());
        add(new JScrollPane(toDoList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);
    }

    private void setUpContent(){
        toDoListModel = new DefaultListModel<>();
        toDoList = new JList<>(toDoListModel);
        taskInput = new JTextField();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        setUpLayout();
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            toDoListModel.addElement(task);
            taskInput.setText("");
        }
    }
}
