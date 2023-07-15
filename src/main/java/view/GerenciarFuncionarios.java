package view;


import classes.Usuario;
import persistencia.UsuarioDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GerenciarFuncionarios {
    private JFrame frame;
    private JPanel contentPanel;
    private JTable table;

    public GerenciarFuncionarios(boolean visible) {
        // Configuração do frame
        frame = new JFrame("Gerenciar Funcionarios");
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

        // Criar tabela com cabeçalhos das colunas
        String[] columnHeaders = {"NOME FUNCIONÁRIO", "TIPO DE ACESSO"};
        DefaultTableModel model = new DefaultTableModel(columnHeaders, 0);
        table = new JTable(model);

        // Definir altura da tabela em 10 linhas
        int rowHeight = table.getRowHeight();
        int numRows = Math.min(10, model.getRowCount()); // Limita a altura em 10 linhas
        int tableWidth = 500;
        int tableHeight = rowHeight * numRows;

        // Criar JScrollPane e definir seu tamanho preferencial
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(tableWidth, tableHeight));
        // Definir o fundo do JScrollPane como transparente
        scrollPane.setOpaque(false);
        // Obter o componente JViewport do JScrollPane
        JViewport viewport = scrollPane.getViewport();
        // Definir o fundo do JViewport como transparente
        viewport.setOpaque(false);
        // Adicionar o JScrollPane ao painel de conteúdo
        contentPanel.add(scrollPane, BorderLayout.CENTER);



        // Criar painel para o menu
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setLayout(new GridLayout(1, 5));

        // Criar botões do menu
        JButton button1 = createVerticalButton("Início");
        JButton button2 = createVerticalButton("Caixa");
        JButton button3 = createVerticalButton("Gerenciar Estoque");
        JButton button4 = createVerticalButton("Gerenciar Funcionários");
        JButton button5 = createVerticalButton("Sair");

        // Adicionar os botões ao painel do menu
        menuPanel.add(button1);
        menuPanel.add(button2);
        menuPanel.add(button3);
        menuPanel.add(button4);
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

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para chamar a classe correspondente ao botão 3
                // ...
                // Fechar a tela atual
                frame.dispose();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para chamar a classe correspondente ao botão 4
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
        // Popular a tabela com dados fictícios
        List<Usuario> todosUsuarios = new UsuarioDAO().todosUsuarios();
        DefaultTableModel model = (DefaultTableModel) table.getModel();




        // Paginar os usuários em grupos de 10
        int page = 0;
        final int[] currentPage = {page};
        int pageSize = 1;
        int startIndex = page * pageSize;
        int endIndex = Math.min(startIndex + pageSize, todosUsuarios.size());
        List<Usuario> usuariosPaginados = todosUsuarios.subList(startIndex, endIndex);

        // Limpar a tabela antes de adicionar as novas linhas
        model.setRowCount(0);

        // Adicionar as linhas dos usuários paginados à tabela
        for (Usuario usuario : usuariosPaginados) {
            String nome = usuario.getNome();
            String perfil = usuario.getPerfil().toString();

            model.addRow(new String[]{nome, perfil});
        }



        // Se houver mais usuários além da página atual, mostrar botão de próxima página
        if (endIndex < todosUsuarios.size()) {
            JButton nextPageButton = createVerticalButton("Próxima Página");
            JButton backPageButton = createVerticalButton("Página Anterior");
            addButton(nextPageButton,backPageButton,endIndex,todosUsuarios.size(),pageSize);
            nextPageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentPage[0]++; // Increment the current page

                    int startIndex = currentPage[0] * pageSize;
                    int endIndex = Math.min(startIndex + pageSize, todosUsuarios.size());
                    List<Usuario> usuariosPaginados = todosUsuarios.subList(startIndex, endIndex);

                    // Limpar a tabela antes de adicionar as novas linhas
                    model.setRowCount(0);

                    // Adicionar as linhas dos usuários paginados à tabela
                    for (Usuario usuario : usuariosPaginados) {
                        String nome = usuario.getNome();
                        String perfil = usuario.getPerfil().toString();

                        model.addRow(new String[]{nome, perfil});
                    }
                    addButton(nextPageButton,backPageButton,endIndex,todosUsuarios.size(),pageSize);

                }
            });
            backPageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentPage[0] > 0) {
                        currentPage[0]--; // Decrement the current page

                        int startIndex = currentPage[0] * pageSize;
                        int endIndex = Math.min(startIndex + pageSize, todosUsuarios.size());
                        List<Usuario> usuariosPaginados = todosUsuarios.subList(startIndex, endIndex);

                        // Limpar a tabela antes de adicionar as novas linhas
                        model.setRowCount(0);

                        // Adicionar as linhas dos usuários paginados à tabela
                        for (Usuario usuario : usuariosPaginados) {
                            String nome = usuario.getNome();
                            String perfil = usuario.getPerfil().toString();

                            model.addRow(new String[]{nome, perfil});

                        }
                        addButton(nextPageButton,backPageButton,endIndex,todosUsuarios.size(),pageSize);
                    }
                }
            });
            JPanel paginationPanel = new JPanel();
            paginationPanel.setLayout(new FlowLayout());
            paginationPanel.add(backPageButton);
            paginationPanel.add(nextPageButton);

            // Adicionar o painel de paginação ao painel de conteúdo
            contentPanel.add(paginationPanel, BorderLayout.SOUTH);
        }

        frame.setVisible(true);
    }

    private void addButton( JButton nextPageButton,  JButton backPageButton, int endIndex,int todosUsuariosSize,int pageSize) {
        if (endIndex <todosUsuariosSize ) {
            nextPageButton.setVisible(true);

        } else {
            nextPageButton.setVisible(false);
        }
        if (endIndex > pageSize) {
            backPageButton.setVisible(true);
        }else{
            backPageButton.setVisible(false);
        }
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
                GerenciarFuncionarios gFunc = new GerenciarFuncionarios(true);
                gFunc.show();
            }
        });
    }
}
