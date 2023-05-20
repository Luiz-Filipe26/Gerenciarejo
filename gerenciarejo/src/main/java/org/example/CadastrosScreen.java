package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastrosScreen {
    private JFrame frame;
    private JPanel contentPanel;
    private JTextField nomeField;
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton cadastrarButton;
    private JButton voltarButton;

    public CadastrosScreen() {
        // Configuração do frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true); // Remove as bordas do frame
        frame.setSize(getScreenWidth(), getScreenHeight());
        frame.setLocationRelativeTo(null);

        // Configuração do painel de conteúdo com imagem de fundo
        contentPanel = new BackgroundPanel();
        contentPanel.setLayout(new GridBagLayout());
        frame.setContentPane(contentPanel);

        // Configuração do campo de nome
        nomeField = new JTextField(20);
        nomeField.setPreferredSize(new Dimension(180, 40));

        // Configuração do campo de usuário
        usuarioField = new JTextField(20);
        usuarioField.setPreferredSize(new Dimension(180, 40));

        // Configuração do campo de senha
        senhaField = new JPasswordField(20);
        senhaField.setPreferredSize(new Dimension(180, 40));

        // Configuração do botão de cadastrar
        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setPreferredSize(new Dimension(180, 40));
        cadastrarButton.setBackground(Color.decode("#FF9100"));
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setBorderPainted(false);
        cadastrarButton.setFocusPainted(false);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                // Verifica se todos os campos foram preenchidos
                if (nome.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Cria a conexão com o banco de dados
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciarejo", "seu_nome", "sua_senha")) {
                    // Prepara a instrução SQL para inserir o novo usuário
                    String sql = "INSERT INTO usuario (nome, usuario, senha) VALUES (?, ?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, nome);
                        statement.setString(2, usuario);
                        statement.setString(3, senha);

                        // Executa a inserção do novo usuário no banco de dados
                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                            // Limpar os campos após o cadastro
                            nomeField.setText("");
                            usuarioField.setText("");
                            senhaField.setText("");
                            LoginScreen loginScreen = new LoginScreen();
                            loginScreen.show();
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Erro ao cadastrar usuário.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao conectar ao banco de dados.", "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        // Configuração do botão de voltar
        voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(180, 40));
        voltarButton.setBackground(Color.decode("#FF9100"));
        voltarButton.setForeground(Color.WHITE);
        voltarButton.setBorderPainted(false);
        voltarButton.setFocusPainted(false);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chamando a classe para a tela anterior
                FullScreenRatio fullScreenRatio = new FullScreenRatio();
                fullScreenRatio.show();
                frame.dispose();
            }
        });

        // Configuração do layout do painel de conteúdo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(new JLabel("Nome:"), gbc);

        gbc.gridy = 1;
        contentPanel.add(nomeField, gbc);

        gbc.gridy = 2;
        contentPanel.add(new JLabel("Usuário:"), gbc);

        gbc.gridy = 3;
        contentPanel.add(usuarioField, gbc);

        gbc.gridy = 4;
        contentPanel.add(new JLabel("Senha:"), gbc);

        gbc.gridy = 5;
        contentPanel.add(senhaField, gbc);

        gbc.gridy = 6;
        contentPanel.add(cadastrarButton, gbc);

        gbc.gridy = 7;
        contentPanel.add(voltarButton, gbc);
    }

    public void show() {
        frame.setVisible(true);
    }

    private int getScreenWidth() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = ge.getMaximumWindowBounds();
        return bounds.width;
    }

    private int getScreenHeight() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = ge.getMaximumWindowBounds();
        return bounds.height;
    }

    // Classe para o JPanel personalizado com a imagem de fundo
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            backgroundImage = new ImageIcon("org/example/image/breathe (2).png").getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CadastrosScreen cadastrosScreen = new CadastrosScreen();
                cadastrosScreen.show();
            }
        });
    }
}