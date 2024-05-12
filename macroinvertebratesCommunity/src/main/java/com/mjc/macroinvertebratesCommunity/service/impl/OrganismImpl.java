package com.mjc.macroinvertebratesCommunity.service.impl;

import com.mjc.macroinvertebratesCommunity.dto.OrganismDto;
import com.mjc.macroinvertebratesCommunity.entity.Organism;
import com.mjc.macroinvertebratesCommunity.exception.ResourceNotFoundException;
import com.mjc.macroinvertebratesCommunity.mapper.OrganismMapper;
import com.mjc.macroinvertebratesCommunity.repository.IOrganismRepository;
import com.mjc.macroinvertebratesCommunity.service.IOrganismService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganismImpl implements IOrganismService {

    private IOrganismRepository iOrganismRepository;
    @Override
    public OrganismDto createOrganism(OrganismDto organismDto) {
        Organism organism = OrganismMapper.mapToOrganism(organismDto);
        Organism savedOrganism = iOrganismRepository.save(organism);
        return OrganismMapper.mapToOrganismDto(savedOrganism);
    }

    @Override
    public OrganismDto getOrganism(Long organismId) {
        Organism organism = iOrganismRepository.findById(organismId)
                .orElseThrow(()-> new ResourceNotFoundException("Organism not exist given that id: " + organismId));
        return OrganismMapper.mapToOrganismDto(organism);
    }

    @Override
    public List<OrganismDto> getAllOrganisms() {
        List<Organism> organisms = iOrganismRepository.findAll();
        return organisms.stream().map((organism )-> OrganismMapper.mapToOrganismDto(organism))
                .collect(Collectors.toList());
    }

    @Override
    public OrganismDto updateOrganism(Long organismId, OrganismDto updateOrganism) {
        Organism organism = iOrganismRepository.findById(organismId)
                .orElseThrow(()-> new ResourceNotFoundException("Organism is not exist with given id: " + organismId));
        organism.setCampaign(updateOrganism.getCampaign());
        organism.setClassTaxa(updateOrganism.getClassTaxa());
        organism.setOrderTaxa(updateOrganism.getOrderTaxa());
        organism.setFamily(updateOrganism.getFamily());
        organism.setN(updateOrganism.getN());

        Organism updateOrganismObj = iOrganismRepository.save(organism);

        return OrganismMapper.mapToOrganismDto(updateOrganismObj);
    }

    @Override
    public void deleteOrganism(Long organismId) {
        Organism organism = iOrganismRepository.findById(organismId)
                .orElseThrow(()-> new ResourceNotFoundException("Organism is not exist with given id: " + organismId));

        iOrganismRepository.deleteById(organismId);

    }
}
