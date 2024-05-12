package com.mjc.macroinvertebratesCommunity.common.utils;

import com.mjc.macroinvertebratesCommunity.entity.Organism;
import com.mjc.macroinvertebratesCommunity.repository.IOrganismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    IOrganismRepository iOrganismRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadOrganismData();
    }

    private void loadOrganismData(){
        iOrganismRepository.save(new Organism(null, "05-23", "Insecta", "Trichoptera", "Metrichia", 58));
        iOrganismRepository.save(new Organism(null, "05-23", "Insecta", "Ephemeroptera", "Baetidae", 9));
        iOrganismRepository.save(new Organism(null, "05-23", "Insecta", "Diptera", "Chironomidae", 131));
    }
}
