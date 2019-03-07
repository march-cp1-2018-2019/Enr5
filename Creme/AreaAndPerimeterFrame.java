/**
 * Made By Jeremiah Creme
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class AreaAndPerimeterFrame extends JFrame {
	JLabel TF1Label = new JLabel("Type Width Here:");
	JTextField TF1 = new JTextField("");
	JLabel TF2Label = new JLabel("Type Hight Here:");
	JTextField TF2 = new JTextField("");
	JTextField TF3 = new JTextField("Perimeter : Unset");
	JTextField TF4 = new JTextField("Area : Unset");
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
		TF1.setPreferredSize(new Dimension(40, 20));
		TF1.setVisible(true);
		TF2.setPreferredSize(new Dimension(40, 20));
		TF2.setVisible(true);
		TF3.setEditable(false);
		TF3.setVisible(true);
		TF4.setEditable(false);
		TF4.setVisible(true);
		B1.addActionListener(new computeButtonClicked());
		B1.setVisible(true);
		B2.addActionListener(new resetButtonClicked());
		B2.setVisible(true);
		GridBagConstraints test = new GridBagConstraints();

		FlowLayout layout = new FlowLayout();

		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		test = getConstraints(1, 1);
		p.add(TF1Label, test);
		test = getConstraints(2, 1);
		p.add(TF1, test);
		test = getConstraints(1, 2);
		p.add(TF2Label, test);
		test = getConstraints(2, 2);
		p.add(TF2, test);
		test = getConstraints(1, 3);
		p.add(TF3, test);
		test = getConstraints(1, 4);
		p.add(TF4, test);
		JPanel fl = new JPanel();
		fl.setLayout(layout);
		fl.add(p);
		fl.add(B1);
		fl.add(B2);
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

				long TF1Int = Integer.parseInt(TF1.getText());
				long TF2Int = Integer.parseInt(TF2.getText());
				TF3.setText("Perimeter : " + (TF1Int + TF1Int + TF2Int + TF2Int));
				TF4.setText("Area : " + (TF1Int * TF2Int));
				pack();
			} catch (Exception e) {

				TF3.setText("You Have To Type In");
				TF4.setText("Numbers And Only Numbers");
				pack();

			}
		}
	}

	class resetButtonClicked implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			TF1.setText("");
			TF2.setText("");
			TF3.setText("Perimeter : Unset");
			TF4.setText("Area : Unset");
			pack();

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
