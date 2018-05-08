/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
import Modelo.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author 3ºANO
 */
public class ProfessorDAO extends ExecuteSQL{

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

    public List<Funcionario> Pesquisar_Nome_Professor(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}