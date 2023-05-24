package javaapplication1.org.fpij.jitakyoei.business;

import java.util.List;

import javaapplication1.org.fpij.jitakyoei.model.beans.Aluno;

public interface AlunoBO {
	public void createAluno(Aluno aluno) throws Exception;
	public void updateAluno(Aluno aluno) throws Exception;
	public List<Aluno> searchAluno(Aluno aluno) throws Exception;
	public List<Aluno> listAll() throws Exception;
}
