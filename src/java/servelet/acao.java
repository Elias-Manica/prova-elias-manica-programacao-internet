/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelet;

import dao.UsuarioDAO;
import dao.EstadoDAO;
import entidade.Estado;
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


        if (a.equals("editarEstado")) {
            String id = request.getParameter("id");
            int codigo = Integer.parseInt(id);

            Estado estado = new EstadoDAO().consultar(codigo);
            request.setAttribute("estado", estado);

            encaminharPagina("cadastro-estados.jsp", request, response);
        }

        if (a.equals("excluirEstado")) {
            String id = request.getParameter("id");
            int codigo = Integer.parseInt(id);

            if (new EstadoDAO().excluir(codigo)) {
                encaminharPagina("listar-estados.jsp", request, response);
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
        if (a.equals("salvarEstado")) {
            String codigo = request.getParameter("id");
            String nome = request.getParameter("nome");
            String sigla = request.getParameter("sigla");
            String regiao = request.getParameter("regiao");
            String paisId = request.getParameter("pais");

            Estado estado = new Estado();

            if (codigo != null && !codigo.isEmpty()) {
                int id = Integer.parseInt(codigo);
                estado.setId(id);
            } else {
                estado.setId(0);
            }

            estado.setNome(nome);
            estado.setSigla(sigla);
            estado.setRegiao(regiao);
            estado.setPaisId(Integer.parseInt(paisId));

            String errorMessage = new EstadoDAO().validarDados(estado);

            if (errorMessage == null) {
                if (estado.getId() == 0) { // Novo estado
                    if (new EstadoDAO().salvar(estado)) {
                        encaminharPagina("sucesso.jsp", request, response);
                    } else {
                        encaminharPagina("erro-cadastro.jsp", request, response);
                    }
                } else { // Atualizando estado existente
                    if (new EstadoDAO().atualizar(estado)) {
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
