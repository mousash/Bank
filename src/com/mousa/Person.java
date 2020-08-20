package com.mousa;

public class Person {

	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	protected String getName() {
		return name;
	}
	
	protected int getAge() {
		return age;
	}
	
	@Override
    public String toString() {
        return "Person [Name: " + name + ", Age: " + age + "]";
    }
}
