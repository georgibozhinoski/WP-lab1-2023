package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Production;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductionService {
    List<Production> listAll();
    Optional<Production> findByID(Long id);
}
