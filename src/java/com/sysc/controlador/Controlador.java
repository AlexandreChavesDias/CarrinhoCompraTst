//Add New Servlet

package com.sysc.controlador;

import com.sysc.config.Data;
import com.sysc.modelo.Carrinho;
import com.sysc.modelo.Cliente;
import com.sysc.modelo.Compra;
import com.sysc.modelo.Pago;
import com.sysc.modelo.Produto;
import com.sysc.modeloDAO.CompraDAO;
import com.sysc.modeloDAO.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    ProdutoDAO pdao = new ProdutoDAO();
    Produto p = new Produto();
    
    List<Produto> produtos = new ArrayList<>();
        
    List<Carrinho> listaCarrinho = new ArrayList<>();
    int item;
    double totalPagar = 0.00;
    int quantidade = 1;
    
    int idp;
    Carrinho car;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
            produtos = pdao.listar();
            
        switch(accion){
            //01
            case "Comprar":
                totalPagar=0.0;
                idp=Integer.parseInt(request.getParameter("id"));    
                p=pdao.listarId(idp);
                    item=item+1;
                    //Carrinho car = new Carrinho();
                      car = new Carrinho();
                      car.setItem(item);
                        car.setIdProduto(p.getId());
                        car.setNomes(p.getNome());
                        car.setDescricao(p.getDescricao());
                        car.setPrecoCompra(p.getPreco());
                        car.setQuantidade(quantidade);
                        car.setSubTotal(quantidade*p.getPreco());
                            listaCarrinho.add(car);
                            
                            for (int i = 0; i < listaCarrinho.size(); i++) {
                        totalPagar = totalPagar+listaCarrinho.get(i).getSubTotal();               
                }
                            request.setAttribute("totalPagar", totalPagar);
                            request.setAttribute("carrinho", listaCarrinho);
                            request.setAttribute("contador", listaCarrinho.size());
                            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
                break;
                
//            //02    
//            case "AddCarrinho":
//            
//                idp=Integer.parseInt(request.getParameter("id"));    
//                p = pdao.listarId(idp);
//                     item=item+1;
//                     car = new Carrinho();
//                     car.setItem(item);
//                     car.setIdProduto(p.getId());
//                     car.setNomes(p.getNome());
//                     car.setDescricao(p.getDescricao());
//                     car.setPrecoCompra(p.getPreco());
//                     car.setQuantidade(quantidade);
//                     car.setSubTotal(quantidade * p.getPreco());
//                     listaCarrinho.add(car);
//                         request.setAttribute("contador", listaCarrinho.size());
//                         request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
//                break;

//                //02    
//            case "AddCarrinho":
//                int pos = 0;
//                quantidade = 1;
//                idp = Integer.parseInt(request.getParameter("id"));    
//                p = pdao.listarId(idp);
//                if (listaCarrinho.size() > 0) {
//                    for (int i = 0; i < listaCarrinho.size(); i++) {
//                        if (idp == listaCarrinho.get(i).getIdProduto()) {
//                            pos = i;
//                        } 
//                        if (idp == listaCarrinho.get(pos).getIdProduto()) {
//                            quantidade = listaCarrinho.get(pos).getQuantidade() + quantidade;
//                            double subtotal = listaCarrinho.get(pos).getPrecoCompra() * quantidade;
//                            listaCarrinho.get(pos).setQuantidade(quantidade);
//                            listaCarrinho.get(pos).setSubTotal(subtotal);
//                        } else {
//                                    item = item + 1;
//                                    car = new Carrinho();
//                                    car.setItem(item);
//                                    car.setIdProduto(p.getId());
//                                    car.setNomes(p.getNome());
//                                    car.setDescricao(p.getDescricao());
//                                    car.setPrecoCompra(p.getPreco());
//                                    car.setQuantidade(quantidade);
//                                    car.setSubTotal(quantidade * p.getPreco());
//                                    listaCarrinho.add(car);
//                        }
//                    }
//                } else {
//                     item = item + 1;
//                     car = new Carrinho();
//                     car.setItem(item);
//                     car.setIdProduto(p.getId());
//                     car.setNomes(p.getNome());
//                     car.setDescricao(p.getDescricao());
//                     car.setPrecoCompra(p.getPreco());
//                     car.setQuantidade(quantidade);
//                     car.setSubTotal(quantidade * p.getPreco());
//                     listaCarrinho.add(car);
//                }
//
//                         request.setAttribute("contador", listaCarrinho.size());
//                         request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
//                break; 
        
                
            //02    
            case "AddCarrinho":
                int pos = 0;
                quantidade = 1;
                idp = Integer.parseInt(request.getParameter("id"));    
                p = pdao.listarId(idp);
                 boolean centinela = true;
                if (listaCarrinho.size() > 0) {
                    for (int i = 0; i < listaCarrinho.size() && centinela == true; i++) {
                        if (idp == listaCarrinho.get(i).getIdProduto()) {
                            centinela = false;
                            
                    //para somar ao carrinho a compra
                          //quantidade += listaCarrinho.get(i).getQuantidade(); 
                          
                    //para permitir apenas uma compra de curso - nao aumenta
                            quantidade = listaCarrinho.get(i).getQuantidade(); 
                            
                            double subtotal = listaCarrinho.get(i).getPrecoCompra() * quantidade;
                            listaCarrinho.get(i).setQuantidade(quantidade);
                            listaCarrinho.get(i).setSubTotal(subtotal);
                        }
                    }
                    if (centinela == true) {
                        item = item + 1;
                        car = new Carrinho();
                        car.setItem(item);
                        car.setIdProduto(p.getId());
                        car.setNomes(p.getNome());
                        car.setDescricao(p.getDescricao());
                        car.setPrecoCompra(p.getPreco());
                        car.setQuantidade(quantidade);
                        car.setSubTotal(quantidade * p.getPreco());
                        listaCarrinho.add(car);
                    }

                } else {
                     item = item + 1;
                     car = new Carrinho();
                     car.setItem(item);
                     car.setIdProduto(p.getId());
                     car.setNomes(p.getNome());
                     car.setDescricao(p.getDescricao());
                     car.setPrecoCompra(p.getPreco());
                     car.setQuantidade(quantidade);
                     car.setSubTotal(quantidade * p.getPreco());
                     listaCarrinho.add(car);
                }

                         request.setAttribute("contador", listaCarrinho.size());
                         request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                break;                
            //03
            case "Delete":
                int idproduto;
                    idproduto = Integer.parseInt(request.getParameter("idp"));
                    
                    for (int i = 0; i < listaCarrinho.size(); i++) {
                    //for (int i = 0; i < listaCarrinho.size(); i--) {    
                        if (listaCarrinho.get(i).getIdProduto() == idproduto) {
                            listaCarrinho.remove(i);
                        }
                }
                break;
                
        //04 mod1,
/*
            case "AtualizarQuantidade":
                int idpro = Integer.parseInt(request.getParameter("idp"));
                int qtde = Integer.parseInt(request.getParameter("Quantidade"));
                    for (int i = 0; i < listaCarrinho.size(); i++) {
                        if (listaCarrinho.get(i).getIdProduto() == idpro) {
                            listaCarrinho.get(i).setQuantidade(qtde);
                            double st = listaCarrinho.get(i).getPrecoCompra()*qtde;
                                listaCarrinho.get(i).setSubTotal(st);
                        } 
                }
                
                break;
*/


        //04
            case "AtualizarQuantidade":
                int idpro;
                idpro = Integer.parseInt(request.getParameter("idp"));
                int qtde;
                qtde = Integer.parseInt(request.getParameter("Quantidade"));
                    for (int i = 0; i < listaCarrinho.size(); i++) {
                        if (listaCarrinho.get(i).getIdProduto() == idpro) {
                            listaCarrinho.get(i).setQuantidade(qtde);
                            double st = listaCarrinho.get(i).getPrecoCompra()*qtde;
                                listaCarrinho.get(i).setSubTotal(st);
                        } 
                }
                
                break;
                
        
        //05 - mesmo que carringo 
            case "Novo":
                listaCarrinho = new ArrayList();
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                
                break;
                



        //05
            case "Carrinho":
                    totalPagar=0.0;
                    request.setAttribute("carrinho", listaCarrinho);
                    for (int i = 0; i < listaCarrinho.size(); i++) {
                        totalPagar = totalPagar+listaCarrinho.get(i).getSubTotal();               
                }
                    request.setAttribute("totalPagar", totalPagar);
                    request.getRequestDispatcher("carrinho.jsp").forward(request, response);
                break;
         

        //06   
            case "GerarCompra":
                Cliente cliente = new Cliente();
                cliente.setId(1);
//                Pago pago = new Pago();
                CompraDAO dao = new CompraDAO();
                Compra compra = new Compra(cliente,1, Data.DataBD(), totalPagar, "compra", listaCarrinho);
                
                int res = dao.GerarCompra(compra);
                if (res != 0 && totalPagar > 0) {
                    request.getRequestDispatcher("vistas/mensaje.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("vistas/mensaje.jsp").forward(request, response);
                }
     
                break;

//Default abaixo    
            default:
//                request.setAttribute("cont", listaCarrinho.size());
                request.setAttribute("produtos", produtos);
                request.getRequestDispatcher("index.jsp").forward(request, response); 
                
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
*/
    /*
    Necessario alterar metodo doPost para que funcionasse a funcao deletar
    alem do mais foi preciso adicionar uma biblioteca do jquery em carrinho.jsp =>  <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "Delete":
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < listaCarrinho.size(); i++) {
                //for (int i = 0; i < listaCarrinho.size(); i--) {    
                    if (listaCarrinho.get(i).getIdProduto() == idproducto) {
                        listaCarrinho.remove(i);
                        
                    }
                }
                break;
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
