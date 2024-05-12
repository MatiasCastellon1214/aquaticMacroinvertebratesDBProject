package com.mjc.macroinvertebratesCommunity.entity;

import com.mjc.macroinvertebratesCommunity.dto.OrganismDto;
import com.mjc.macroinvertebratesCommunity.service.impl.OrganismImpl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrganismTest {

    @Autowired
    private OrganismImpl organism;

    @Test
    @Order((1))
    void testAitShouldAddAnOrganismWhitId(){
        OrganismDto organismDto = new OrganismDto(1L,"12-22","Insecta", "Ephemeoptera", "Camelobaetidius", 4);
        OrganismDto createdOrganism = organism.createOrganism(organismDto);
        assertNotNull(createdOrganism.getId());
        assertEquals("Insecta", createdOrganism.getClassTaxa());
    }

    @Test
    @Order(2)
    void shouldReturnANonEmptyList(){
        List<OrganismDto> organisms = organism.getAllOrganisms();
        assertFalse(organisms.isEmpty());
    }

    @Test
    @Order(3)
    void shouldReturnAnOrganismWithIdEqualTo1(){

        OrganismDto organismDto = organism.getOrganism(1L);
        assertFalse(organismDto.getId()!=1L);
    }

}

