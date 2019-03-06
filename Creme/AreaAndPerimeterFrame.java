import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class AreaAndPerimeterFrame extends JFrame {
	JTextField TF1 = new JTextField("Type Width Here");
	JTextField TF2 = new JTextField("Type Hight Here");
	JTextField TF3 = new JTextField("Perimeter : Unknown");
	JTextField TF4 = new JTextField("Area : Unknown");
	JButton B1 = new JButton("Calculate");
	JButton B2 = new JButton("Reset");

	// TODO: Add instance variables for text fields

	public AreaAndPerimeterFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.out.println(e);
		}
		initComponents();
	}

	private void initComponents() {
		setTitle("Area and Perimeter Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TF1.setSize(300, 200);
		TF1.setVisible(true);
		TF2.setSize(300, 200);
		TF2.setVisible(true);
		TF3.setSize(300, 200);
		TF3.setEditable(false);
		TF3.setVisible(true);
		TF4.setSize(300, 200);
		TF4.setEditable(false);
		TF4.setVisible(true);
		B1.addActionListener(new computeButtonClicked());
		B1.setVisible(true);
		B2.addActionListener(new resetButtonClicked());
		B2.setVisible(true);
		FlowLayout layout = new FlowLayout();

		JPanel p = new JPanel();
		p.setLayout(layout);
		GridBagConstraints test = getConstraints(1, 0);
		p.add(TF1, test);
		test = getConstraints(1, 2);
		p.add(TF2, test);
		test = getConstraints(2, 3);
		p.add(TF3, test);
		test = getConstraints(3, 4);
		p.add(TF4, test);
		JPanel fl = new JPanel();
		fl.setLayout(layout);
		fl.add(B1);
		fl.add(B2);
		fl.add(p);
		add(fl);
		fl.setVisible(true);
		p.setVisible(true);

		pack();

		setLocationByPlatform(true);

		// components go here

		setVisible(true);
	}

	class computeButtonClicked implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			String TF1Text = TF1.getText();
			String TF2Text = TF2.getText();
			try {
				int TF1Int = Integer.parseInt(TF1.getText());
				int TF2Int = Integer.parseInt(TF2.getText());
				TF3.setText("Perimeter : " + (TF1Int + TF1Int + TF2Int + TF2Int));
				TF4.setText("Area : " + (TF1Int * TF2Int));
			} catch (Exception e) {
				TF3.setText("Perimeter : Error");
				TF4.setText("Area : Error");
			}
		}
	}

	class resetButtonClicked implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			TF1.setText("Type Width Here");
			TF2.setText("Type Hight Here");
			TF3.setText("Perimeter : Unknown");
			TF4.setText("Area : Unknown");
		}
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

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			@SuppressWarnings("unused")
			JFrame frame = new AreaAndPerimeterFrame();

		});
	}
}
