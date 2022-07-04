package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Panel {

	private JFrame frmSnavUygulamas;
	private JTextField txtA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel window = new Panel();
					window.frmSnavUygulamas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSnavUygulamas = new JFrame();
		frmSnavUygulamas.setTitle("S\u0131nav Uygulamas\u0131");
		frmSnavUygulamas.setBounds(100, 100, 450, 300);
		frmSnavUygulamas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		// Sýnav sekmesi
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Sýnav Uygulamasý", null, panel, null);
		
		// sýnav butonumuz
		
		JButton btnNewButton_1 = new JButton("SINAVI BA\u015ELAT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// sýnav uygulamasýný butona basýnca baþlat
				
				sinav nw = new sinav();
				nw.sinav();
			}
		});
		panel.add(btnNewButton_1);
		
		// Sýnav buton altý yazýmýz
		
		JTextPane txtpnSnavLtfenHazr = new JTextPane();
		txtpnSnavLtfenHazr.setBackground(UIManager.getColor("Button.background"));
		txtpnSnavLtfenHazr.setText("S\u0131nav\u0131 l\u00FCtfen haz\u0131r oldu\u011Funuz an ba\u015Flat\u0131n. Cevap vermek i\u00E7in s\u00FCreniz olacakt\u0131r.");
		panel.add(txtpnSnavLtfenHazr);
		GroupLayout groupLayout = new GroupLayout(frmSnavUygulamas.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
		);
		
		// Hakkýmýzda sekmesi
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hakkýmýzda", null, panel_1, null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("bg.jpg"));
		panel_1.add(lblNewLabel);
		
		// Yardým sekmesi
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Yardým", null, panel_2, null);
		
		txtA = new JTextField();
		txtA.setBackground(UIManager.getColor("Button.background"));
		txtA.setForeground(Color.BLACK);
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setText("Yard\u0131m i\u00E7in admin@help.com adresine mail at\u0131n\u0131z.");
		panel_2.add(txtA);
		txtA.setColumns(50);
		frmSnavUygulamas.getContentPane().setLayout(groupLayout);
	}
}
