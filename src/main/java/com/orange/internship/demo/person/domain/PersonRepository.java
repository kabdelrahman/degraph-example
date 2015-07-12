package com.orange.internship.demo.person.domain;

import java.util.List;

public interface PersonRepository {
	public void saveOrUpdate(List<Person> persons);
}
