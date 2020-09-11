
package com.sysc.modeloDAO;

//implementar todos os metodos que precisamos para gerar a comrpa ( Evolua)

import com.sysc.config.Conexao;
import com.sysc.modelo.Carrinho;
import com.sysc.modelo.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraDAO {
        Connection con;
        Conexao cnx = new Conexao();
        PreparedStatement ps;
        ResultSet rs;
        int r=0; //havia esquecid 
        
    public int GerarCompra(Compra compra){
        
        int idcompras;
        
        String sql = "insert into compras(com_idCliente,com_dataCompras,com_Monto,com_Estado,com_idPago ) values(?,?,?,?,?)" ;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
                ps.setInt(1, compra.getCliente().getId());
                ps.setString(2, compra.getDataCompra());
                ps.setDouble(3, compra.getMonto());
                ps.setString(4, compra.getEstado());
                ps.setInt(5, compra.getIdpago());           
            r = ps.executeUpdate();
                
            sql = "Select @@IDENTITY AS com_idCompras";
            rs = ps.executeQuery(sql);
            rs.next();
            idcompras = rs.getInt("det_idCompras");
            rs.close();
            
            for (Carrinho detalhe : compra.getDetalheCompra()) {
                sql = "insert into detalhe_compras(det_idProduto, det_idCompras, det_Qtde, det_PrecoCompra ) values(?,?,?,?)" ;
                ps = con.prepareStatement(sql);
                    ps.setInt(1, detalhe.getIdProduto());
                    ps.setInt(2, idcompras); //idcompras capturado no select anterior - det_idCompras
                    ps.setInt(3, detalhe.getQuantidade());
                    ps.setDouble(4, detalhe.getPrecoCompra());
                r = ps.executeUpdate(); 
            }
            
            
        } catch (SQLException e) {
        }
        return r;

    }
    
    
}
