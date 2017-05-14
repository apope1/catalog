package com.service;

import com.domain.Notare;
import com.repository.RepositoryNotare;

/**
 * Created by Andu on 13.05.2017.
 */
public class ServiceNotare {
    private RepositoryNotare repo;

    public ServiceNotare(RepositoryNotare repo) {
        this.repo = repo;
    }

    public void addNotare(Notare notare) {
        repo.add(notare);
    }

}
