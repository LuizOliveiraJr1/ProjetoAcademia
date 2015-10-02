package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

/**
 *
 * @author Luiz Carlos
 */
public class AlunoDAO extends GenericDAO{
    
    public void salvar(Aluno aluno) throws SQLException{
        String insert = "INSERT INTO alunos (nome, sexo, cidade, endereco, telefone, turno, dataMatricula, bairro, celular) "
                        + "VALUE(?,?,?,?,?,?,?,?,?)";
        salvar(insert, aluno.getNome(), aluno.getSexo(), aluno.getCidade(), aluno.getEndereco(), aluno.getTelefone(), aluno.getTurno(), aluno.getDataMatricula(), aluno.getBairro(), aluno.getCelular());
    }
    
    public void atualizar(Aluno aluno)throws SQLException{
        String update = "UPDATE alunos SET nome = ?, sexo = ?, cidade = ?, telefone = ?, turno = ?, dataMatricula = ?, bairro = ?, celular = ? WHERE id = ?";
        atualizar(update, aluno.getIdAluno(), aluno.getNome(), aluno.getSexo(), aluno.getCidade(), aluno.getEndereco(), aluno.getTelefone(), aluno.getTelefone(), aluno.getTurno(), aluno.getDataMatricula(), aluno.getBairro(), aluno.getCelular());
    }
    
    public void excluir(int id) throws SQLException{
        String delete = "DELETE * FROM alunos WHERE id = ?";
        delete(delete, id);
    }
    
    public List<Aluno> listarTodosAlunos() throws SQLException{
        List<Aluno> alunos = new ArrayList<Aluno>();
        
        String select = "SELECT * FROM alunos";
        
        PreparedStatement statement = getConnection().prepareStatement(select);
        
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            Aluno aluno = new Aluno();
            aluno.setIdAluno(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setSexo(rs.getString("sexo"));
            aluno.setCidade(rs.getString("cidade"));
            aluno.setEndereco(rs.getString("endereco"));
            aluno.setTelefone(rs.getString("telefone"));
            aluno.setTurno(rs.getString("turno"));
            aluno.setDataMatricula(rs.getDate("dataMatricula"));
            aluno.setBairro(rs.getString("bairro"));
            aluno.setCelular(rs.getString("celular"));
        }
        return alunos;
    }
    
    public Aluno filtrarAluno(String nome) throws SQLException{
        String filtrar = "SELECT * FROM alunos WHERE nome = ?";
        
        Aluno aluno = null;
        
        PreparedStatement statement = getConnection().prepareStatement(filtrar);
        
        statement.setString(1, nome);
        
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            aluno.setIdAluno(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setSexo(rs.getString("sexo"));
            aluno.setCidade(rs.getString("cidade"));
            aluno.setEndereco(rs.getString("endereco"));
            aluno.setTelefone(rs.getString("telefone"));
            aluno.setTurno(rs.getString("turno"));
            aluno.setDataMatricula(rs.getDate("dataMatricula"));
            aluno.setBairro(rs.getString("bairro"));
            aluno.setCelular(rs.getString("celular"));
        }
        rs.close();
        statement.close();
        return aluno;
    }
}
