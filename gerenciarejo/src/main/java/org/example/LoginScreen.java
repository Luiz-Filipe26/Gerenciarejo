package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginScreen {
    private JFrame frame;
    private JPanel contentPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton backButton;

    public LoginScreen() {
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

        // Configuração do campo de nome de usuário
        usernameField = new JTextField(20);
        usernameField.setPreferredSize(new Dimension(180, 40));

        // Configuração do campo de senha
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(180, 40));

        // Configuração do botão de login
        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(180, 40));
        loginButton.setBackground(Color.decode("#FF9100"));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usernameField.getText();
                String senha = new String(passwordField.getPassword());

                // Verifica se os campos de usuário e senha foram preenchidos
                if (usuario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Cria a conexão com o banco de dados
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciarejo", "seu_nome", "sua_senha")) {
                    // Prepara a instrução SQL para buscar o usuário no banco de dados
                    String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, usuario);
                        statement.setString(2, senha);

                        // Executa a consulta no banco de dados
                        try (ResultSet resultSet = statement.executeQuery()) {
                            if (resultSet.next()) {
                                // Autenticação bem-sucedida
                                JOptionPane.showMessageDialog(frame, "Login bem-sucedido!", "Login", JOptionPane.INFORMATION_MESSAGE);
                                // Limpar os campos após o login
                                usernameField.setText("");
                                passwordField.setText("");
                                HomeScreen homeScreen = new HomeScreen();
                                homeScreen.show();
                                frame.dispose();
                            } else {
                                // Autenticação falhou
                                JOptionPane.showMessageDialog(frame, "Usuário ou senha inválidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao conectar ao banco de dados.", "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        // Configuração do botão de voltar
        backButton = new JButton("Voltar");
        backButton.setPreferredSize(new Dimension(180, 40));
        backButton.setBackground(Color.decode("#FF9100"));
        backButton.setForeground(Color.WHITE);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ActionListener() {
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
        contentPanel.add(new JLabel("Nome de Usuário:"), gbc);

        gbc.gridy = 1;
        contentPanel.add(usernameField, gbc);

        gbc.gridy = 2;
        contentPanel.add(new JLabel("Senha:"), gbc);

        gbc.gridy = 3;
        contentPanel.add(passwordField, gbc);

        gbc.gridy = 4;
        contentPanel.add(loginButton, gbc);

        gbc.gridy = 5;
        contentPanel.add(backButton, gbc);
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
                HomeScreen homeScreen = new HomeScreen();
                homeScreen.show();
            }
        });
    }
}
