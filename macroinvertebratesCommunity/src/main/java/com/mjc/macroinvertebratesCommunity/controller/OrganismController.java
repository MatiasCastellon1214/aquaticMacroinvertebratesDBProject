package com.mjc.macroinvertebratesCommunity.controller;

import com.mjc.macroinvertebratesCommunity.dto.OrganismDto;
import com.mjc.macroinvertebratesCommunity.service.IOrganismService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/organisms")
public class OrganismController {

    private IOrganismService iOrganismService;

    @PostMapping
    public ResponseEntity<OrganismDto> createOrganism(@RequestBody OrganismDto organismDto){
        OrganismDto savedOrganism = iOrganismService.createOrganism(organismDto);
        return new ResponseEntity<>(savedOrganism, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrganismDto> getOrganism(@PathVariable("id") Long organismId){
        OrganismDto organismDto = iOrganismService.getOrganism(organismId);
        return ResponseEntity.ok(organismDto);
    }

    @GetMapping
    public ResponseEntity<List<OrganismDto>> getAllOrganisms(){
        List<OrganismDto> organisms = iOrganismService.getAllOrganisms();
        return ResponseEntity.ok(organisms);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrganismDto> updateOrganism(@PathVariable("id") Long organismId, @RequestBody OrganismDto updateOrganism){
        OrganismDto organismDto = iOrganismService.updateOrganism(organismId, updateOrganism);
        return ResponseEntity.ok(organismDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrganism(@PathVariable("id") Long organismId){
        iOrganismService.deleteOrganism(organismId);
        return ResponseEntity.ok("Organism deleted succesfully!");
    }
}
