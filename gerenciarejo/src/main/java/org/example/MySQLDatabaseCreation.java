package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDatabaseCreation {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "seu_nome";
        String password = "sua_senha";
        String databaseName = "gerenciarejo";

        try {
            // Estabelecer conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Verificar se o banco de dados já existe
            ResultSet resultSet = statement.executeQuery("SHOW DATABASES LIKE '" + databaseName + "'");
            if (!resultSet.next()) {
                // O banco de dados não existe, então podemos criá-lo
                statement.executeUpdate("CREATE DATABASE " + databaseName);
                System.out.println("Banco de dados criado com sucesso!");
            } else {
                System.out.println("O banco de dados já existe. Ignorando a criação do banco de dados.");
            }

            // Usar o banco de dados
            statement.executeUpdate("USE " + databaseName);

            // Verificar se as tabelas já existem
            resultSet = connection.getMetaData().getTables(null, null, "usuario", null);
            if (!resultSet.next()) {
                // A tabela 'usuario' não existe, então podemos criá-la
                statement.executeUpdate("CREATE TABLE usuario (id bigint primary key auto_increment, nome varchar(75) not null, usuario varchar(50) not null unique, senha varchar(100) not null unique, perfil varchar(10) default 'PADRAO', estado boolean not null default true, data_hora_criacao datetime default current_timestamp, ultimo_login datetime default '001-01-01 00:00:00')");
                System.out.println("Tabela 'usuario' criada com sucesso!");
            } else {
                System.out.println("A tabela 'usuario' já existe. Ignorando a criação da tabela.");
            }

            // Repita o processo acima para as outras tabelas...

            System.out.println("Processo de criação de banco de dados e tabelas concluído!");

            // Fechar conexão
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}