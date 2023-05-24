package javaapplication1.org.fpij.jitakyoei.model.validator;

import javaapplication1.org.fpij.jitakyoei.model.beans.Aluno;

public class AlunoValidator implements Validator<Aluno>{
        @Override
	public boolean validate(Aluno obj) {
		return true;
	}
}