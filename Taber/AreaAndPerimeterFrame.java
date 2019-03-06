package murach.ui;


import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class AreaAndPerimeterFrame extends JFrame {

    // TODO: Add instance variables for text fields

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


        areaTextField.setEditable(false);
        perimeterTextField.setEditable(false);
        



        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
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
        
    	String length = lengthField.getText();
    	try {
    		length
    	}catch()
    	}
    	
    	double length = Double.parseDouble(lengthField.getText));
    	double width = Double.parseDouble(widthField.getText));
    	
    	Rectangle r = new Rectangle(length, width);
    	areaField.setText(r.getAreaNumberFormat());
    	perimeterField.setText
    }

    private void resetButtonClicked() {
        // TODO: Implement code
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            @SuppressWarnings("unused")
			JFrame frame = new AreaAndPerimeterFrame();
            
            
        });        
    }
}