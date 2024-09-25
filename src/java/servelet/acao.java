/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelet;

import dao.UsuarioDAO;
import dao.PessoaDAO;
import entidade.Pessoa;
import entidade.Usuario;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Elias
 */
public class acao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acao</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String a = request.getParameter("a");
        if (a.equals("editarPessoa")) {
            System.out.println("entrei");
            String id = request.getParameter("id");
            int codigo = Integer.parseInt(id);

            Pessoa pessoa = new PessoaDAO().consultar(codigo);
            request.setAttribute("pessoa", pessoa);

            encaminharPagina("cadastro.jsp", request, response);
        }
        if (a.equals("excluirPessoa")) {
            String id = request.getParameter("id");
            int codigo = Integer.parseInt(id);

            if (new PessoaDAO().excluir(codigo)) {
                encaminharPagina("list.jsp", request, response);
            } else {
                encaminharPagina("erro-cadastro.jsp", request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //processRequest(request, response);
       String a = request.getParameter("a");

        if (a.equals("login")) {
            // logica do login
            // pegar usuario
            // pegar senha
            // autenticar = verificar
            // sucesso = vai pro sistema || erro = login de novo

            String user = request.getParameter("user");
            String password = request.getParameter("password");

            System.out.println("User: " + user);
            System.out.println("password: " + password);

            Usuario usuario = new UsuarioDAO().autenticar(user, password);

            if (usuario != null) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("user", usuario);

                encaminharPagina("home.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }
        }
        if (a.equals("logout")) {
            HttpSession sessao = request.getSession();
            sessao.invalidate();

            response.sendRedirect("login.jsp");
        }
        if (a.equals("salvarUsuario")) {
            String codigo = request.getParameter("id");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String dataNascimento = request.getParameter("dataNascimento");

            Pessoa pessoa = new Pessoa();

            if (codigo != null && !codigo.isEmpty()) {
                int id = Integer.parseInt(codigo);
                pessoa.setId(id);
            } else {
                pessoa.setId(0);
            }
            
            pessoa.setNome(nome);
            pessoa.setEmail(email);
            pessoa.setSenha(senha);
            pessoa.setDataNascimento(dataNascimento);

            String errorMessage = new PessoaDAO().validarDados(pessoa);

            if (errorMessage == null) {
                if (pessoa.getId() == 0) {
                    if (new PessoaDAO().salvar(pessoa)) {
                        encaminharPagina("sucesso.jsp", request, response);
                    } else {
                        encaminharPagina("erro-cadastro.jsp", request, response);
                    }
                } else { // Atualizando usuário existente
                    if (new PessoaDAO().atualizar(pessoa)) {
                        encaminharPagina("sucesso.jsp", request, response);
                    } else {
                        encaminharPagina("erro-cadastro.jsp", request, response);
                    }
                }
            } else {
                request.setAttribute("erroMensagem", errorMessage);
                encaminharPagina("erro-cadastro.jsp", request, response);
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao encaminhar: " + e);
        }
    }
}
