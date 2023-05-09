package chat.client.view;

import chat.client.controller.ChatController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaInicial extends JFrame {
	static final int LARGURA_JANELA = 960;
    static final int ALTURA_JANELA = 640;
    
	private JPanel contentPane;
	private JTextField txtNomeUsuario;

	private final ChatController chatController;

	public void iniciar() {
		
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	            System.err.println(ex);
	    
	 }
		
		EventQueue.invokeLater(() -> {
			try {
				TelaInicial frame = new TelaInicial();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public TelaInicial() {
		this.chatController = new ChatController(this);
		setSize(LARGURA_JANELA, ALTURA_JANELA);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 730, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 940, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 1460, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 1880, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeUsuario = new JLabel("Nome do Usuário:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNomeUsuario, 143, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNomeUsuario, 225, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNomeUsuario, 172, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNomeUsuario, 379, SpringLayout.WEST, contentPane);
		lblNomeUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNomeUsuario.setForeground(Color.WHITE);
		lblNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNomeUsuario);
		
		txtNomeUsuario = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNomeUsuario, 0, SpringLayout.NORTH, lblNomeUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNomeUsuario, 6, SpringLayout.EAST, lblNomeUsuario);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNomeUsuario, 172, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNomeUsuario, -255, SpringLayout.EAST, contentPane);
		txtNomeUsuario.setFont(new Font("Dialog", Font.PLAIN, 16));
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnConectar, 130, SpringLayout.SOUTH, txtNomeUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnConectar, 389, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnConectar, -223, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnConectar, -345, SpringLayout.EAST, contentPane);
		btnConectar.setForeground(Color.WHITE);
		btnConectar.setBackground(new Color(85, 107, 47));
		btnConectar.addActionListener(e -> chatController.logar());
		btnConectar.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(btnConectar);
	}

	public String getNomeDeUsuario(){
		return txtNomeUsuario.getText();
	}

	public void marcarErroDePreenchimento(){
		this.txtNomeUsuario.setBorder(BorderFactory.createLineBorder(Color.RED));
	}
}
