package com.ssh.repository.impl;

import com.ssh.entity.Person;

import com.ssh.repository.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by XRom
 * On 11/16/2017.11:55 PM
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public Person load(Long id) {
        return (Person) getCurrentSession().load(Person.class, id);
    }

    @Override
    public Person get(Long id) {
        return (Person) getCurrentSession().get(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public void persist(Person entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Long save(Person entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Person entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        Person person = load(id);
        getCurrentSession().delete(person);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public Long login(HashMap map) {
        return null;
    }
}
