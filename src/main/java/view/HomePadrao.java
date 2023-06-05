package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePadrao {
    private JFrame frame;
    private JPanel contentPanel;

    public HomePadrao(boolean visible) {
        // Configuração do frame
        frame = new JFrame("Início");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Definir tamanho da janela
        frame.setSize(800, 600);
        // Centralizar janela na tela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int windowWidth = frame.getWidth();
        int windowHeight = frame.getHeight();
        int x = (screenWidth - windowWidth) / 2;
        int y = (screenHeight - windowHeight) / 2;
        frame.setLocation(x, y);

        // Configuração do painel de conteúdo com imagem de fundo
        contentPanel = new BackgroundPanel();
        contentPanel.setLayout(new BorderLayout());
        frame.setContentPane(contentPanel);

        // Criar painel para o menu
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setLayout(new GridLayout(1, 5));

        // Criar botões do menu
        JButton button1 = createVerticalButton("Início");
        JButton button2 = createVerticalButton("Adicionar Venda");
        JButton button5 = createVerticalButton("Sair");

        // Adicionar os botões ao painel do menu
        menuPanel.add(button1);
        menuPanel.add(button2);
        menuPanel.add(button5);

        // Adicionar o painel do menu ao topo do painel de conteúdo
        contentPanel.add(menuPanel, BorderLayout.NORTH);

        frame.setVisible(visible);

        // Adicionar ActionListener a cada botão
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para chamar a classe correspondente ao botão 1
                // ...
                // Fechar a tela atual
                frame.dispose();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para chamar a classe correspondente ao botão 2
                // ...
                // Fechar a tela atual
                frame.dispose();
            }
        });


        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Login login = new Login();
                login.setVisible(true);

            }
        });

    }

    private JButton createVerticalButton(String text) {
        JButton button = new JButton(text);

        // Definir a cor de fundo do botão
        button.setBackground(Color.WHITE);

        // Definir a cor da borda do botão
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#ff9000")));

        // Definir a cor do texto do botão
        button.setForeground(Color.decode("#ff9000"));

        return button;
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
            backgroundImage = new ImageIcon("D:\\Gerenciarejo2\\src\\main\\java\\imagens\\bg.jpg").getImage();
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
                HomePadrao homePadrao = new HomePadrao(true);
                homePadrao.show();
            }
        });
    }
}
