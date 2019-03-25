package murach.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


@SuppressWarnings("serial")
public class AreaAndPerimeterFrame extends JFrame {

    // TODO: Add instance variables for text fields
    private JTextField lenghtField;
    private JTextField widthField;
    private JTextField areaField;
    private JTextField perimeterField;
    private JButton computeButton;
    private JButton resetButton;

    public AreaAndPerimeterFrame() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }

    private void initComponents() {
        setTitle("Area and Perimeter Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        
        // components go here
        
        
        lenghtField = new JTextField();
        widthField = new JTextField();
        areaField = new JTextField();
        perimeterField = new JTextField();

        perimeterField.setEditable(false);
        areaField.setEditable(false);

        Dimension dim = new Dimension(250, 20);
       
        widthField.setPreferredSize(dim);
        areaField.setPreferredSize(dim);
        perimeterField.setPreferredSize(dim);
        lenghtField.setMinimumSize(dim);
        widthField.setMinimumSize(dim);
        areaField.setMinimumSize(dim);
        perimeterField.setMinimumSize(dim);

        JButton computeButton = new JButton("Compute");
        JButton resetButton = new JButton("Reset");

        computeButton.addActionListener(e -> computeButtonClicked());
        resetButton.addActionListener(e -> resetButtonClicked());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(computeButton);
        buttonPanel.add(resetButton);        

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(new JLabel("Length:"), getConstraints(0, 0));
        panel.add(lenghtField, getConstraints(1, 0));
        panel.add(new JLabel("Width:"), getConstraints(0, 1));
        panel.add(widthField, getConstraints(1, 1));
        panel.add(new JLabel("Area:"), getConstraints(0, 2));
        panel.add(areaField, getConstraints(1, 2));
        panel.add(new JLabel("Perimeter:"), getConstraints(0, 3));
        panel.add(perimeterField, getConstraints(1, 3));        

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        setSize(new Dimension(900, 900));
        
        setVisible(true);
    }

    // Helper method to return GridBagConstraints objects
    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;
    }

    private void computeButtonClicked() {
        // not sure why this is red  
    	
    	SwingValidator sv = new SwingValidator(this);
    	if (sv.isDouble(lenghtField, "Length")&&
    		sv.isDouble(widthField, "Width");

    	double lenght = Double.parseDouble(lenghtField.getText());
    	double width = Double.parseDouble(widthField.getText());
    	
    	Rectangle r = new Rectangle(lenght, width);
    	areaField.setText(r.getAreaFormat());
    	perimeterField.setText(r.getPerimeterNumberFormat());
    }

    private void resetButtonClicked() {
    	lenghtField.setText("");
    	widthField.setText("");
    	areaField.setText("");
    	perimeterField.setText("");
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            @SuppressWarnings("unused")
			JFrame frame = new AreaAndPerimeterFrame();
    		frame.setSize(600, 300);
    		frame.setVisible(true);
        });        
    }
}








