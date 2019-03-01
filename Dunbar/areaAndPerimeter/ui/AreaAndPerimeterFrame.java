package areaAndPerimeter.ui;

import java.awt.BorderLayout;

// Noah 2/28/2019

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import areaAndPerimeter.business.Rectangle;

@SuppressWarnings("serial")
public class AreaAndPerimeterFrame extends JFrame{
  // TODO: Add instance variables for text fields
  private JTextField lengthTextField;
  private JTextField widthTextField;
  private JTextField areaTextField;
  private JTextField perimeterTextField;

  private JButton computeButton;
  private JButton resetButton;

  public AreaAndPerimeterFrame(){
    try{
      UIManager.setLookAndFeel(
          UIManager.getSystemLookAndFeelClassName());
    }catch(ClassNotFoundException | InstantiationException |
           IllegalAccessException | UnsupportedLookAndFeelException e){
      System.out.println(e);
    }

    initComponents();
  }

  private void initComponents() {
    setTitle("Area and Perimeter Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationByPlatform(true);
    
    // components go here
    lengthTextField = new JTextField();
    widthTextField = new JTextField();
    areaTextField = new JTextField();
    perimeterTextField = new JTextField();

    final Dimension minSize = new Dimension(50, 24);
    final Dimension size = new Dimension(250, 24);

    lengthTextField.setMinimumSize(minSize);
    widthTextField.setMinimumSize(minSize);
    areaTextField.setMinimumSize(minSize);
    perimeterTextField.setMinimumSize(minSize);

    lengthTextField.setPreferredSize(size);
    widthTextField.setPreferredSize(size);
    areaTextField.setPreferredSize(size);
    perimeterTextField.setPreferredSize(size);

    areaTextField.setEditable(false);
    perimeterTextField.setEditable(false);

    JPanel panel = new JPanel();

    panel.setLayout(new GridBagLayout());

    panel.add(new JLabel("Length:"), getConstraints(0, 0));
    panel.add(lengthTextField, getConstraints(1, 0));
    
    panel.add(new JLabel("Width:"), getConstraints(0, 1));
    panel.add(widthTextField, getConstraints(1, 1));
    
    panel.add(new JLabel("Area:"), getConstraints(0, 2));
    panel.add(areaTextField, getConstraints(1, 2));

    panel.add(new JLabel("Perimeter:"), getConstraints(0, 3));
    panel.add(perimeterTextField, getConstraints(1, 3));

    computeButton = new JButton("Compute");
    resetButton = new JButton("Reset");
    
    computeButton.addActionListener(e -> computeButtonClicked());
    resetButton.addActionListener(e -> resetButtonClicked());

    JPanel buttonPanel = new JPanel();
    FlowLayout buttonLayout = new FlowLayout();

    buttonLayout.setAlignment(FlowLayout.RIGHT);
    buttonPanel.setLayout(buttonLayout);

    buttonPanel.add(computeButton);
    buttonPanel.add(resetButton);

    add(panel);
    add(buttonPanel, BorderLayout.SOUTH);

    setSize(350, 200);
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

  private void computeButtonClicked(){
    double length;
    double width;

    try{
      length = Double.parseDouble(lengthTextField.getText());
      width = Double.parseDouble(widthTextField.getText());
    }catch(NumberFormatException ex){
      resetButtonClicked();
      return;
    }

    Rectangle rect = new Rectangle(length, width);

    areaTextField.setText("" + rect.getArea());
    perimeterTextField.setText("" + rect.getPerimeter());
  }

  private void resetButtonClicked(){
    lengthTextField.setText("");
    widthTextField.setText("");
    areaTextField.setText("");
    perimeterTextField.setText("");
  }
  
  public static void main(String[] args){
    java.awt.EventQueue.invokeLater(() -> {
      @SuppressWarnings("unused")
			JFrame frame = new AreaAndPerimeterFrame();
    });
  }
}