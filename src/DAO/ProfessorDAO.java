/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author 3ºANO
 */
public class ProfessorDAO extends ExecuteSQL{

    private Professor p;

    public ProfessorDAO(Connection con) {
        super(con);
    }
    public String Inserir_Professor(Professor p){
        String sql = "INSERT INTO professor VALUES (0,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, p.getNome());
            ps.setString(2, p.getLogin());
            ps.setString(3, p.getSenha());
            
            if(ps.executeUpdate() > 0){
                return "Professor Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar Professor!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Professor> Listar_Professor() {
        String sql = "SELECT cod_Professor,nome_Professor,login_Professor,senha_Professor FROM professor ORDER BY nome_Professor";
        List<Professor> lista = new ArrayList<Professor>();
       
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Professor p = new Professor();
                    p.setCod(rs.getInt(1));
                    p.setNome(rs.getString(2));
                    p.setLogin(rs.getString(3));
                    p.setSenha(rs.getString(4));
                    
                    lista.add(p);
                }
            return lista;
            }else{
                return null;
            }
        } catch (SQLException e) {
            return null;
        }     
    }
    
    public List<Professor> Pesquisar_Nome_Professor(String nome)
    {
        
        String sql = "SELECT cod_Professor, nome_Professor, login_Professor, senha_Professor FROM professor WHERE nome_Professor LIKE '%" + nome + "%'";
        List<Professor> lista = new ArrayList<Professor>();
        
      
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
             
            if(rs != null){
                while(rs.next()){
                    Professor p = new Professor();
                    p.setCod(rs.getInt(1));
                    p.setNome(rs.getString(2));
                    p.setLogin(rs.getString(3));
                    p.setSenha(rs.getString(4));
                    
                    lista.add(p);
                }
            return lista;
            }else{
                return null;
            }
        } 
        catch (SQLException e)
        {
            return null;
        }
    }

    public List<Professor> Pesquisar_Cod_Professor(int cod) {
         String sql = "SELECT cod_Professor, nome_Professor, login_Professor, senha_Professor FROM professor WHERE cod_Professor = '" + cod + "'";
        List<Professor> lista = new ArrayList<Professor>();
        
      
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
             
            if(rs != null){
                while(rs.next()){
                    Professor p = new Professor();
                    p.setCod(rs.getInt(1));
                    p.setNome(rs.getString(2));
                    p.setLogin(rs.getString(3));
                    p.setSenha(rs.getString(4));
                    
                    lista.add(p);
                }
            return lista;
            }else{
                return null;
            }
        } 
        catch (SQLException e)
        {
            return null;
        }  
    }

    public Professor Consulta_Professor(int cod){
         Professor p = new Professor();
         
        try {     
            String sql = "SELECT * FROM professor WHERE cod_Professor =  " + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            if(rs != null){
                while(rs.next()){
                                      
                    p.setCod(rs.getInt(1));
                    p.setNome(rs.getString(2));
                    p.setLogin(rs.getString(3));
                    p.setSenha(rs.getString(4));
                }
            }
            
        } catch (SQLException e) {
            e.getMessage();
        }
        if(p.getCod() == cod){
            JOptionPane.showMessageDialog(null, "Professor encontrado com sucesso!");
        }else{
        JOptionPane.showMessageDialog(null, "Professor não encontrado!");    
        }
        return p;
    }

    public void Alterar_Professor(Professor p){
        String sql = "UPDATE professor SET nome_Professor = ?, login_Professor = ?, senha_Professor = ?"
                + "WHERE cod_Professor = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getLogin());
            ps.setString(3, p.getSenha());
            ps.setString(4, "" + p.getCod());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Professor Atualizado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Professor!");
            }
        } catch (Exception e) {
           e.getMessage();
        }
    }
        public List<Professor> ListaComboProfessor(){
        String sql = "SELECT nome_Professor FROM professor ORDER BY nome_Professor";
        List<Professor> lista = new ArrayList<Professor>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Professor p = new Professor();
                    p.setNome(rs.getString(1));
                    lista.add(p);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }  
    
    public String Excluir_Professor(Professor p){
        String sql = "DELETE FROM professor WHERE cod_Professor = ?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, p.getCod());
            
            if(ps.executeUpdate() > 0){
                return "Professor Excluído com Sucesso!";
            }else{
                return "Erro ao Excluir!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    
    }
}
