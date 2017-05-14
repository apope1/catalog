package com.service;

import com.domain.Profesor;
import com.repository.RepositoryProfesor;

import java.util.List;

/**
 * Created by Andu on 12.05.2017.
 */
public class ServiceProfesor {
    private RepositoryProfesor repo;

    public ServiceProfesor(RepositoryProfesor repo) {
        this.repo = repo;
    }

    public void addProfesor(Profesor profesor) {
        repo.add(profesor);
    }

    public List<Profesor> getAll() {
        return repo.getAll();
    }

    public Profesor getProfesor(Integer id) {
        return repo.getOne(id);
    }

    public Profesor getProfesor(String username, String password) {
        return repo.getOne(username, password);
    }

    public List<String> getNoteProfesor(int profesor)
    {
        return repo.getNoteProfesor(profesor);
    }

    public void updateProfesor(Integer id, Profesor newProfesor) {
        repo.update(id, newProfesor);
    }

    public void removeProfesor(Profesor profesor) {
        repo.delete(profesor);
    }
}
