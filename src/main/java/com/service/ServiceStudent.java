package com.service;

import com.domain.Student;
import com.repository.RepositoryStudent;

import java.util.List;

/**
 * Created by Andu on 12.05.2017.
 */
public class ServiceStudent {
    private RepositoryStudent repo;

    public ServiceStudent(RepositoryStudent repo) {
        this.repo = repo;
    }

    public void addStudent(Student student) {
        repo.add(student);
    }

    public List<Student> getAll() {
        return repo.getAll();
    }

    public Student getStudent(Integer id) {
        return repo.getOne(id);
    }

    public Student getStudent(String username, String password) {
        return repo.getOne(username, password);
    }

    public List<String> getNoteStudent(int entity) {
        return repo.getNoteStudent(entity);
    }

    public void updateStudent(Integer id, Student newStudent) {
        repo.update(id, newStudent);
    }

    public void removeStudent(Student student) {
        repo.delete(student);
    }
}
