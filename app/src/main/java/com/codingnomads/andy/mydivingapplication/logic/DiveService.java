package com.codingnomads.andy.mydivingapplication.logic;

import com.codingnomads.andy.mydivingapplication.data.DiveRepository;
import com.codingnomads.andy.mydivingapplication.logic.Dive;

import java.util.List;

public class DiveService {

    private DiveRepository diveRepository;

    public DiveService(DiveRepository diveRepository) {
        this.diveRepository = diveRepository;
    }

    public List<Dive> getAllDives(){
        return diveRepository.getAllDives();
    }

    public Dive saveDive(Dive dive) {return diveRepository.saveDive(dive);}
}
