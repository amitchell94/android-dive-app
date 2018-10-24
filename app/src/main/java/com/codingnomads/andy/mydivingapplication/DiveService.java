package com.codingnomads.andy.mydivingapplication;

import java.util.List;

public class DiveService {

    private DiveRepository diveRepository;

    public DiveService(DiveRepository diveRepository) {
        this.diveRepository = diveRepository;
    }

    public List<Dive> getAllDives(){
        return diveRepository.getAllDives();
    }
}
