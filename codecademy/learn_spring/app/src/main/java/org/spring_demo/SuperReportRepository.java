package org.spring_demo;

import java.util.ArrayList;
import java.util.List;

public class SuperReportRepository {
    private List<SuperReport> repository = new ArrayList<>(); 

    public void save(SuperReport heroReport) {
        repository.add(heroReport);
    }


}
