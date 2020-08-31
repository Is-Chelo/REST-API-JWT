package com.khoubyari.example.service;

import com.khoubyari.example.domain.Alimento;
import com.khoubyari.example.dao.jpa.AlimentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class AlimentoService {

    private static final Logger log = LoggerFactory.getLogger(AlimentoService.class);

    @Autowired
    private AlimentoRepository alimentoRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public AlimentoService() {
    }

    public Alimento createAlimento(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    public Alimento getAlimento(long id) {
        return alimentoRepository.findOne(id);
    }

    public void updateAlimento(Alimento alimento) {
        alimentoRepository.save(alimento);
    }

    public void deleteAlimento(Long id) {
        alimentoRepository.delete(id);
    }

    //http://goo.gl/7fxvVf
    public Page<Alimento> getAllAlimentos(Integer page, Integer size) {
        Page pageOfAlimentos = alimentoRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("Khoubyari.AlimentoService.getAll.largePayload");
        }
        return pageOfAlimentos;
    }
}
