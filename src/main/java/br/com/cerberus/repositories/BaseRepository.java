package br.com.cerberus.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cerberus.dao.BaseDao;

public abstract class BaseRepository<T> implements BaseDao<T> {

	public static int index = 1;
	public Map<Integer, T> repo = new HashMap<Integer,T>();

	public void add(T obj) {
		this.repo.put(index, obj);
		index++;
	}

	public T get(Integer key) {
		return this.repo.get(key);
	}
	
	public List<T> getAll(){
		return new ArrayList<T>(this.repo.values());
	}

	public void remove(Integer k) {
		this.repo.remove(k);
	}
	
	//Usa o toString() do objeto da classe T.
	public void show() {
		this.repo.values().forEach(System.out::println);
	}
	
	public void showListaChaveValor() {
		for (Map.Entry<Integer, T> entry : repo.entrySet()) {
			System.out.println("ID: "+ entry.getKey() + ", " + entry.getValue().toString());
		}
	}
}