package com.mjc.macroinvertebratesCommunity.repository;

import com.mjc.macroinvertebratesCommunity.entity.Organism;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrganismRepository extends JpaRepository<Organism, Long> {
}
