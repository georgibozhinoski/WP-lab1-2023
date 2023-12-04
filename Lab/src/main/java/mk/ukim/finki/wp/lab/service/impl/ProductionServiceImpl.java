package mk.ukim.finki.wp.lab.service.impl;


import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.repository.ProductionRepository;
import mk.ukim.finki.wp.lab.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionServiceImpl  implements ProductionService {
    private final ProductionRepository productionRepository;
    public ProductionServiceImpl(ProductionRepository productionRepository){
        this.productionRepository=productionRepository;
    }
    @Override
    public List<Production> listAll() {
        return productionRepository.findAll();
    }

    @Override
    public Optional<Production> findById(Long id) {
        return productionRepository.findById(id);
    }

}