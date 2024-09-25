/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import apoio.ConexaoBD;
import entidade.Pessoa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Elias
 */
public class PessoaDAO {
    public boolean salvar(Pessoa p) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO pessoa (nome, email, senha, dataNascimento) VALUES ("
                    + "'" + p.getNome() + "', "
                    + "'" + p.getEmail() + "', "
                    + "'" + p.getSenha()+ "', "
                    + "'" + p.getDataNascimento() + "'"
                    + ")";

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar Pessoa: " + e);
            return false;
        }
    }

    public String validarDados(Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
            return "O campo nome é obrigatório.";
        }
        if (pessoa.getEmail() == null || pessoa.getEmail().trim().isEmpty()) {
            return "O campo email é obrigatório.";
        }
        if (pessoa.getDataNascimento() == null || pessoa.getDataNascimento().trim().isEmpty()) {
            return "O campo data de nascimento é obrigatório.";
        }
         // Verificação de idade mínima (13 anos)
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataNascimento = LocalDate.parse(pessoa.getDataNascimento(), formatter);
            LocalDate dataAtual = LocalDate.now();

            // Calcula a idade da pessoa
            int idade = Period.between(dataNascimento, dataAtual).getYears();

            if (idade < 13) {
                return "É necessário ter pelo menos 13 anos para se cadastrar.";
            }
        } catch (Exception e) {
            return "Data de nascimento inválida. Utilize o formato yyyy-MM-dd.";
        }

        return null; // Sem erros
    }
    
    public boolean atualizar(Pessoa p) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE pessoa SET " +
                    "nome = '" + p.getNome() + "', " +
                    "email = '" + p.getEmail() + "', " +
                    "dataNascimento = '" + p.getDataNascimento() + "' " +
                    "WHERE id = " + p.getId();

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Pessoa: " + e);
            return false;
        }
    }
    
    public ArrayList<Pessoa> consultar() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM pessoa";
            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Pessoa p = new Pessoa();
                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setEmail(resultado.getString("email"));
                p.setSenha(resultado.getString("senha"));
                p.setDataNascimento(resultado.getString("dataNascimento"));
                pessoas.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Pessoa: " + e);
        }

        return pessoas;
    }
    public boolean excluir(int codigo) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM pessoa WHERE id = " + codigo;
            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Pessoa: " + e);
            return false;
        }
    }
    public Pessoa consultar(int codigo) {
        Pessoa pessoa = new Pessoa();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM pessoa WHERE id = " + codigo;
            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                pessoa.setId(resultado.getInt("id"));
                pessoa.setNome(resultado.getString("nome"));
                pessoa.setEmail(resultado.getString("email"));
                pessoa.setSenha(resultado.getString("senha"));
                pessoa.setDataNascimento(resultado.getString("dataNascimento"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar UMA Pessoa: " + e);
        }

        return pessoa;
    }
}
