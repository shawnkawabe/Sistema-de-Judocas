package org.fpij.jitakyoei.business;

import org.fpij.jitakyoei.facade.AppFacade;
import org.fpij.jitakyoei.model.beans.Entidade;
import org.fpij.jitakyoei.view.AppView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EntidadeBOTest {
    private EntidadeBOImpl entidadeTest;
    private Entidade entity;

    public static AppView appView(){
        return new AppView() {
            @Override
            public void handleModelChange(Object obj) {}

            @Override
            public void displayException(Exception e) {}

            @Override
            public void registerFacade(AppFacade facade) {}
        };
    }

    @Before
    public void setUp(){
        entidadeTest = new EntidadeBOImpl(appView());
        entity = new Entidade();
        entity.setNome("Entidade Teste");
    }

    @Test
    public void createEntidadeTest() throws Exception {
        entidadeTest.createEntidade(entity);

        Entidade wantedEntity = entidadeTest.searchEntidade(entity).get(0);

        assertEquals(entity.getNome(), wantedEntity.getNome());
    }

    @Test
    public void updateEntidadeTest() throws Exception {
        entidadeTest.createEntidade(entity);

        Entidade wantedEntity = entidadeTest.listAll().get(0);

        wantedEntity.setNome("Entidade Update Teste");
        entidadeTest.updateEntidade(wantedEntity);

        Entidade updatedEntity = entidadeTest.listAll().get(0);

        assertEquals("Entidade Update Teste", updatedEntity.getNome());
        assertNotEquals("Entidade Teste Update inválido", updatedEntity.getNome());
    }
}
