package com.mjc.macroinvertebratesCommunity.mapper;

import com.mjc.macroinvertebratesCommunity.dto.OrganismDto;
import com.mjc.macroinvertebratesCommunity.entity.Organism;

public class OrganismMapper {

    public static OrganismDto mapToOrganismDto(Organism organism){
        return new OrganismDto(
                organism.getId(),
                organism.getCampaign(),
                organism.getClassTaxa(),
                organism.getOrderTaxa(),
                organism.getFamily(),
                organism.getN()
        );
    }

    public static Organism mapToOrganism(OrganismDto organismDto){
        return new Organism(
                organismDto.getId(),
                organismDto.getCampaign(),
                organismDto.getClassTaxa(),
                organismDto.getOrderTaxa(),
                organismDto.getFamily(),
                organismDto.getN()
        );
    }
}
