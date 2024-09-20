/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entidade.Usuario;
import apoio.ConexaoBD;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Elias
 */
public class UsuarioDAO {
    public Usuario autenticar(String nome, String senha) {
        Usuario u = new Usuario();

        //try {
            // Cria a conexão com o banco de dados
          //  Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            // Monta a consulta SQL
          //  String sql = "SELECT * FROM usuario WHERE nome = '" + nome + "' AND senha = '" + senha + "'";
           // ResultSet rs = st.executeQuery(sql);

            // Se encontrar um resultado, autentica o usuário
            //if (rs.next()) {
                //autenticado = true;
            //}

            // Fecha a conexão
            //rs.close();
            //st.close();

        //} catch (Exception e) {
            //System.out.println("Erro ao autenticar usuário: " + e.getMessage());
        //}

        return u;
    }
    
    public Usuario autenticarBanco(String nome, String senha) {
        Usuario usuario = null;
        
        try {
            // Cria a conexão com o banco de dados
            Connection con = ConexaoBD.getInstance().getConnection();
            
            // Monta a consulta SQL usando PreparedStatement para evitar SQL Injection
            String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            // Define os parâmetros da consulta
            ps.setString(1, nome);
            ps.setString(2, senha);
            
            // Executa a consulta
            ResultSet rs = ps.executeQuery();
            
            // Se encontrar um resultado, cria um objeto Usuario
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha")); // Por boas práticas, não é ideal retornar a senha, mas fiz para o exemplo
            }
            
            // Fecha os recursos
            rs.close();
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao autenticar usuário: " + e.getMessage());
        }
        
        return usuario;
    }
}
