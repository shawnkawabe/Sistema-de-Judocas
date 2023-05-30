package org.fpij.jitakyoei.model.beans;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class EntidadeTest {
    private static Endereco address;
    private static Entidade entity;

    @BeforeClass
    public static void setUp() {
        address = new Endereco();
        address.setBairro("Assunção");
        address.setCep("12345-678");
        address.setCidade("São Bernardo do Campo");
        address.setEstado("SP");
        address.setRua("Av Castelo Branco");

        entity = new Entidade();
        entity.setCnpj("1641646541654");
        entity.setNome("Entidade Teste");
        entity.setTelefone1("91457-4514");
        entity.setTelefone2("99595-5616");
        entity.setEndereco(address);
    }
    
    @Test
    public void checkNameIsNotBlankTest(){
        assertNotNull(entity.getNome());
    }

    @Test
    public void checkTelephone1IsNotBlankTest(){
        assertNotNull(entity.getTelefone1());
    }     

    @Test
    public void checkTelephone2IsNotBlankTest(){
        assertNotNull(entity.getTelefone2());
    }     


    @Test
    public void checkCPFIsNotBlankTest(){
        assertNotNull(entity.getCnpj());
    }

    @Test
    public void checkAddressIsNotBlankTest(){
        assertNotNull(entity.getEndereco());
    }    

    @Test 
    public void entityCopyPropertiesTest(){
        Entidade newEntity = new Entidade();
        newEntity.copyProperties(entity);
    }

    @Test
    public void entityHashCodeTest(){
        assertNotNull(entity.hashCode());
    }     

    @Test 
    public void entityToStringTest(){
        assertEquals(entity.getNome(), entity.toString());
    }

    @Test
    public void entityEqualsTest(){
        Entidade entityOther = new Entidade();
        entityOther.setCnpj("4165162162126");
        entityOther.setNome("Entidade Equal Teste");

        assertEquals(false,entity.equals(entityOther));
        assertEquals(true,entity.equals(entity));
    }    
}