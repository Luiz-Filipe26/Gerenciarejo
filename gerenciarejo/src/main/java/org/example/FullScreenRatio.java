package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FullScreenRatio {
    private JFrame frame;
    private BackgroundPanel contentPanel;
    private JButton loginButton;
    private JButton cadastrosButton;

    public FullScreenRatio() {
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

        // Configuração dos botões
        loginButton = new JButton("Login");
        cadastrosButton = new JButton("Cadastros");

        // Define o tamanho dos botões
        Dimension buttonSize = new Dimension(180, 40);
        loginButton.setPreferredSize(buttonSize);
        cadastrosButton.setPreferredSize(buttonSize);

        // Configuração do estilo dos botões
        loginButton.setBackground(Color.WHITE);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setOpaque(true);

        cadastrosButton.setBackground(Color.WHITE);
        cadastrosButton.setBorderPainted(false);
        cadastrosButton.setFocusPainted(false);
        cadastrosButton.setOpaque(true);

        // Ação do botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chamando a classe para a tela de login
                HomeScreen homeScreen = new HomeScreen();
                homeScreen.show();
                frame.dispose();
                frame.dispose();
            }
        });

        // Ação do botão de cadastros
        cadastrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chamando a classe para a tela de cadastros
                CadastrosScreen cadastrosScreen = new CadastrosScreen();
                cadastrosScreen.show();
                frame.dispose();
            }
        });

        // Configuração do layout do painel de conteúdo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(loginButton, gbc);

        gbc.gridy = 1;
        contentPanel.add(cadastrosButton, gbc);

        // Configuração do evento de tecla Esc para fechar a tela
        // Configuração do evento de tecla Esc para fechar a tela
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    frame.dispose();
                }
            }
        });

        // Define o foco do teclado para o frame
        frame.setFocusable(true);
        frame.requestFocus();


    }

    public void show() {
        frame.setVisible(true);
    }

    private int getScreenWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    private int getScreenHeight() {
        return (getScreenWidth() * 9) / 16;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FullScreenRatio fullScreenRatio = new FullScreenRatio();
                fullScreenRatio.show();
            }
        });
    }

    // Classe para o JPanel personalizado com a imagem de fundo
    private class BackgroundPanel extends JPanel {
        private BufferedImage backgroundImage;

        public BackgroundPanel() {
            try {
                backgroundImage = ImageIO.read(new File("org/example/image/breathe (1).png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
