import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataGUI extends JFrame {
    private JTextField inputField;
    private JButton analyzeButton;
    private JTextArea resultsArea;

    public DataGUI() {
        setTitle("Data Sorter");
        setSize(600, 600);
        setLayout(new BorderLayout());

        inputField = new JTextField("albums.txt", 15);
        
        analyzeButton = new JButton("Sort Data");
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeBySort();
            }
        });

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1, 5, 5));
        rightPanel.add(inputField);
        rightPanel.add(analyzeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void analyzeBySort() {
        String fileName = inputField.getText();
        DataRunner dataRunner = new DataRunner(fileName, 498); 
        String[] sortedData = dataRunner.sort();

        resultsArea.setText("");
        for (String word : sortedData) {
            resultsArea.append(word + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI());
    }
}
