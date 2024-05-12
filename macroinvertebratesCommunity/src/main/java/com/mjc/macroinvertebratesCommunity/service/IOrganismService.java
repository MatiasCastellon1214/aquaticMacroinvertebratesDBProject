package com.mjc.macroinvertebratesCommunity.service;

import com.mjc.macroinvertebratesCommunity.dto.OrganismDto;

import java.util.List;

public interface IOrganismService {

    OrganismDto createOrganism(OrganismDto organismDto);
    OrganismDto getOrganism(Long organismId);
    List<OrganismDto> getAllOrganisms();
    OrganismDto updateOrganism(Long organismId, OrganismDto updateOrganism);
    void deleteOrganism(Long organismId);
}
