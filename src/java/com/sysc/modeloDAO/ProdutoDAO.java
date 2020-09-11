
package com.sysc.modeloDAO;

//import com.mysql.jdbc.Connection;
import com.sysc.config.Conexao;
import com.sysc.modelo.Produto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class ProdutoDAO extends Conexao{
    Connection con;
    Conexao cnx = new Conexao();
    PreparedStatement ps;
    ResultSet rs;
    int r=0; //havia esquecido

    public Produto listarId(int id){
    String sql="select * from produto where prod_idProduto="+id;
    Produto p = new Produto();
        try {
            con=cnx.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                    p.setId(rs.getInt(1));
                    p.setNome(rs.getString(2));
                    p.setFoto(rs.getBinaryStream(3));
                    p.setDescricao(rs.getString(4));
                    p.setPreco(rs.getDouble(5));
                    p.setEstoque(rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println("ERRO 4" + e);
        }
        return p;
    }
    
    
    public List listar(){
        List<Produto>produtos = new ArrayList();
        String sql="select * from produto;";
        try {
            con=cnx.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Produto p = new Produto();
                    p.setId(rs.getInt(1));
                    p.setNome(rs.getString(2));
                    p.setFoto(rs.getBinaryStream(3));
                    p.setDescricao(rs.getString(4));
                    p.setPreco(rs.getDouble(5));
                    p.setEstoque(rs.getInt(6));

                    produtos.add(p);
            }
                        
        } catch (SQLException e) {
            System.out.println("ERRO 2 " + e);
        }
        return produtos;
    }
    
    
    public void listarImagens(int id, HttpServletResponse response) throws IOException{
        String sql="select * from produto where prod_idProduto="+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        
        try {
            outputStream = response.getOutputStream();
            con=cnx.getConnection();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                if (rs.next()) {
                    inputStream = rs.getBinaryStream("prod_Foto"); 
            }
                bufferedInputStream = new BufferedInputStream(inputStream);
                bufferedOutputStream = new BufferedOutputStream(outputStream);
                    int i = 0;
                        while( (i = bufferedInputStream.read()) != -1 ) {
                                bufferedOutputStream.write(i);        
                        }                
        } catch (SQLException e) {
            System.out.println("ERRO 3 " + e);
        }   
    }
}
