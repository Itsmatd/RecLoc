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

    public List<Professor> Pesquisar_Nome_Professor(String text) {
        String sql = "SELECT codigo,nome,login,senha FROM professor";
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
            }else{
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
        
    }

    public List<Professor> Listar_Professor() {
        String sql = "SELECT codigo,nome,login,senha FROM professor";
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
    public List<Professor> Pesquisar_Cod_Professor(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}