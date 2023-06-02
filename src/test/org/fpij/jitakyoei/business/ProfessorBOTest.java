package org.fpij.jitakyoei.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.fpij.jitakyoei.facade.AppFacade;
import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.model.beans.Professor;
import org.fpij.jitakyoei.view.AppView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfessorBOTest {
    private ProfessorBOImpl professorBO;
    private Professor teacher;

    private AppView appViewMock = new AppView() {
        @Override
        public void handleModelChange(Object obj) {}

        @Override
        public void displayException(Exception e) {}

        @Override
        public void registerFacade(AppFacade facade) {}
    };

    @BeforeEach
    public void setUp() {
        Filiado affiliated = new Filiado();
        affiliated.setId(456465645L);
        affiliated.setNome("Professor Equals Teste");

        teacher = new Professor();
        teacher.setFiliado(affiliated);

        professorBO = new ProfessorBOImpl(appViewMock);
    }

    @Test
    public void createProfessorTest() throws Exception {
        professorBO.createProfessor(teacher);
        Professor savedTeacher = professorBO.searchProfessor(teacher).get(0);

        assertEquals(savedTeacher, teacher);
        assertNotEquals(new Professor(), teacher);
    }

    @Test
    public void updateProfessorTest() throws Exception {
        professorBO.createProfessor(teacher);

        Professor savedTeacher = professorBO.listAll().get(0);

        savedTeacher.getFiliado().setNome("Professor Update Teste");
        professorBO.updateProfessor(savedTeacher);

        assertEquals("Professor Update Teste", professorBO.listAll().get(0).getFiliado().getNome());
        assertNotEquals("Professor teste Update invalido", professorBO.listAll().get(0).getFiliado().getNome());
    }

    @Test
    public void createProfessorExceptionTest() {
        Professor teacherNull = new Professor();
        teacherNull.setFiliado(null);

        Exception exception = assertThrows(Exception.class, () -> {
            professorBO.createProfessor(teacherNull);
        });

        String expectedMessage = "Desculpe, ocorreu um erro desconhecido ao salvar o professor.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void updateProfessorExceptionTest() {
        Professor teacherNull = new Professor();
        teacherNull.setFiliado(null);

        Exception exception = assertThrows(Exception.class, () -> {
            professorBO.updateProfessor(teacherNull);
        });

        String expectedMessage = "Desculpe, ocorreu um erro desconhecido ao atualizar o professor.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
