package controller;

import DAO.AlunoDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Aluno;

/**
 *
 * @author Luiz Carlos
 */
public class AlunoController {
    
    private Date formatarDataMatricula(String dataMatricula) throws ParseException{
        DateFormat formatar = new SimpleDateFormat("DD/MM/AAAA");
        return new Date (formatar.parse(dataMatricula).getTime());
    }
    
    public void salvar(String nome, String sexo, String cidade, String endereco, String telefone, String turno, Date dataMatricula, String bairro, String celular) throws SQLException, ParseException{
     
        Aluno aluno = new Aluno();
        
        aluno.setNome(nome);
        aluno.setSexo(sexo);
        aluno.setEndereco(endereco);
        aluno.setTelefone(telefone);
        aluno.setTurno(turno);
        aluno.setDataMatricula(dataMatricula);
        aluno.setBairro(bairro);
        aluno.setCelular(celular);
        
        new AlunoDAO().salvar(aluno);
    }
    
    public void atualizar(String nome, String sexo, String cidade, String endereco, String telefone, String turno, Date dataMatricula, String bairro, String celular) throws SQLException, ParseException{
     
        Aluno aluno = new Aluno();
        
        aluno.setNome(nome);
        aluno.setSexo(sexo);
        aluno.setEndereco(endereco);
        aluno.setTelefone(telefone);
        aluno.setTurno(turno);
        aluno.setDataMatricula(dataMatricula);
        aluno.setBairro(bairro);
        aluno.setCelular(celular);
        
        new AlunoDAO().atualizar(aluno);
    }
    
    public List<Aluno> listaAlunos(){
        AlunoDAO alunoDao = new AlunoDAO();
        try{
            return alunoDao.listarTodosAlunos();
        }catch(SQLException e){
            //tratar mensagem de erro
        }
        return null;
    }
    
    public void excluir(int id) throws SQLException{
        new AlunoDAO().excluir(id);
    }
    
    public Aluno pesquisaPorNome(String nome) throws SQLException{
        AlunoDAO alunoDao = new AlunoDAO();
        return alunoDao.filtrarAluno(nome);
    }
    
    
}
