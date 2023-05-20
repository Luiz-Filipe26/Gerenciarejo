package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {
    private JFrame frame;
    private JPanel contentPanel;
    private JButton backButton;

    public HomeScreen() {
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

        // Configuração do botão de sair
        backButton = new JButton("Sair");
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
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(10, 10, 10, 10);
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
