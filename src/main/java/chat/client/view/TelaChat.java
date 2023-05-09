package chat.client.view;

import chat.client.controller.ChatController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.TextArea;
import javax.swing.JButton;

public class TelaChat extends JFrame {
	static final int LARGURA_JANELA = 960;
    static final int ALTURA_JANELA = 640;
	private final ChatController chatController;
    
	private JPanel contentPane;

	
	public void iniciar() {

		EventQueue.invokeLater(() -> {
			try {
				this.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}


	public TelaChat(ChatController chatController) {
		this.chatController = chatController;
		setSize(LARGURA_JANELA, ALTURA_JANELA);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.GRAY);
		panel.setBounds(30, 11, 300, 579);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -534, SpringLayout.SOUTH, panel);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(85, 107, 47));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_usuarios_online = new JLabel("Usuários Online");
		lbl_usuarios_online.setBounds(85, 11, 112, 19);
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_usuarios_online, 21, SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, lbl_usuarios_online, 198, SpringLayout.WEST, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lbl_usuarios_online, 55, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_usuarios_online, -29, SpringLayout.EAST, panel_1);
		panel_1.add(lbl_usuarios_online);
		lbl_usuarios_online.setForeground(Color.WHITE);
		lbl_usuarios_online.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_usuarios_online.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(331, 61, 603, 476);
		contentPane.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(330, 11, 604, 50);
		contentPane.add(panel_3);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_3, 2, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_3, -4, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_3, 50, SpringLayout.NORTH, panel_2);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JLabel lblNewLabel = new JLabel(chatController.getNomeDoUsuario());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel, 199, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel, 40, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel, -215, SpringLayout.EAST, panel_3);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(341, 540, 449, 50);
		contentPane.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		TextArea textArea = new TextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Dialog", Font.BOLD, 16));
		textArea.setBackground(Color.LIGHT_GRAY);
		sl_panel_4.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, textArea, 0, SpringLayout.SOUTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, panel_4);
		panel_4.add(textArea);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(85, 107, 47));
		btnNewButton.setBounds(802, 539, 132, 50);
		contentPane.add(btnNewButton);
	}
}
