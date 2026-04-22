package weka.project;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.PixelVector;

public class DashboardFrame extends JFrame {
    
    private DrawingPanel drawingPanel;
    private Classifier nbModel;
    private Classifier rfModel;
    private JComboBox<String> modelSelector;
    private JLabel resultLabel;

    public DashboardFrame(Classifier nbModel, Classifier rfModel) {
        this.nbModel = nbModel;
        this.rfModel = rfModel;
        
        setTitle("Reconnaissance de Chiffres MNIST");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new BorderLayout());

        
        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel();
        
        
        modelSelector = new JComboBox<>(new String[]{"Random Forest", "Naive Bayes"});
        bottomPanel.add(modelSelector);

        
        JButton btnClear = new JButton("Effacer");
        btnClear.addActionListener(e -> drawingPanel.clear());
        bottomPanel.add(btnClear);

        
        JButton btnPredict = new JButton("Prédire");
        btnPredict.addActionListener(e -> lancerPrediction());
        bottomPanel.add(btnPredict);

        
        resultLabel = new JLabel(" Résultat : ? ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        bottomPanel.add(resultLabel);

        add(bottomPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null); 
    }

    
    private void lancerPrediction() {
        PixelVector pv = drawingPanel.getPixelVector(); 
        Classifier selectedModel = modelSelector.getSelectedIndex() == 0 ? rfModel : nbModel;
        
        try {
            int prediction = selectedModel.predict(pv); 
            resultLabel.setText(" Résultat : C'est un " + prediction + " !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}