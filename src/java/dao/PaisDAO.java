package dao;

import apoio.ConexaoBD;
import entidade.Pais;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe responsável por acessar os dados dos países no banco de dados.
 */
public class PaisDAO {

    // Método para consultar a lista de países
    public ArrayList<Pais> consultar() {
        ArrayList<Pais> paises = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM pais";
            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Pais p = new Pais();
                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setSigla(resultado.getString("sigla"));
                p.setPopulacao(resultado.getLong("populacao"));
                p.setContinente(resultado.getString("continente"));
                paises.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar País: " + e);
        }

        return paises;
    }
}
