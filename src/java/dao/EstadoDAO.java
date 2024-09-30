/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import entidade.Estado;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DAO para Estado
 * 
 * @author Elias
 */
public class EstadoDAO {
    public ArrayList<Estado> consultar() {
        ArrayList<Estado> estados = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM estado";
            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Estado e = new Estado();
                e.setId(resultado.getInt("id"));
                e.setNome(resultado.getString("nome"));
                e.setSigla(resultado.getString("sigla"));
                e.setRegiao(resultado.getString("regiao"));
                e.setPaisId(resultado.getInt("pais"));
                estados.add(e);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Estado: " + e);
        }

        return estados;
    }

    public boolean salvar(Estado e) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO estado (nome, sigla, regiao, pais) VALUES ("
                    + "'" + e.getNome() + "', "
                    + "'" + e.getSigla() + "', "
                    + "'" + e.getRegiao() + "', "
                    + e.getPaisId()
                    + ")";

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);

            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao salvar Estado: " + ex);
            return false;
        }
    }

    public String validarDados(Estado estado) {
        if (estado.getNome() == null || estado.getNome().trim().isEmpty()) {
            return "O campo nome é obrigatório.";
        }
        if (estado.getNome().length() > 100) {
            return "O nome deve ser menor que 100 caracteres.";
        }
        if (estado.getSigla() == null || estado.getSigla().trim().isEmpty()) {
            return "O campo sigla é obrigatório.";
        }
        if (estado.getSigla().length() != 2) {
            return "A sigla do estado deve ter exatamente 2 caracteres.";
        }
        if (estado.getRegiao() == null || estado.getRegiao().trim().isEmpty() || estado.getRegiao().length() > 100) {
            return "O campo região é obrigatório.";
        }
        if (estado.getPaisId() <= 0) {
            return "O ID do país deve ser válido.";
        }

        return null; // Sem erros
    }

    public boolean atualizar(Estado e) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE estado SET " +
                    "nome = '" + e.getNome() + "', " +
                    "sigla = '" + e.getSigla() + "', " +
                    "regiao = '" + e.getRegiao() + "', " +
                    "pais = " + e.getPaisId() + " " +
                    "WHERE id = " + e.getId();

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);
            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao atualizar Estado: " + ex);
            return false;
        }
    }

    public boolean excluir(int codigo) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM estado WHERE id = " + codigo;
            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);
            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao excluir Estado: " + ex);
            return false;
        }
    }

    public Estado consultar(int codigo) {
        Estado estado = new Estado();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM estado WHERE id = " + codigo;
            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                estado.setId(resultado.getInt("id"));
                estado.setNome(resultado.getString("nome"));
                estado.setSigla(resultado.getString("sigla"));
                estado.setRegiao(resultado.getString("regiao"));
                estado.setPaisId(resultado.getInt("pais"));
            }

        } catch (Exception ex) {
            System.out.println("Erro ao consultar Estado: " + ex);
        }

        return estado;
    }
}
