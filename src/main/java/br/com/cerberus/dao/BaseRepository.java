package br.com.cerberus.dao;

public interface BaseRepository<T> {

    public void add(T obj);

    public void get(T obj);

    public void remove(T obj);
}
