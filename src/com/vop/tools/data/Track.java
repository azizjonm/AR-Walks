package com.vop.tools.data;

import java.util.ArrayList;

/**
 * Represents a Track
 * 
 * @author henri
 * 
 */
public class Track {

	private final Integer id;
	private String name;
	private Person person;
	private ArrayList<Point> walk;

	public Track(Integer id, String name, Person person, ArrayList<Point> walk) {
		super();
		this.id = id;
		this.name = name;
		this.person = person;
		this.walk = walk;
	}

	public Track(String name, Person person, ArrayList<Point> walk) {
		super();
		this.id = null;
		this.name = name;
		this.person = person;
		this.walk = walk;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Person getPerson() {
		return person;
	}

	public ArrayList<Point> getWalk() {
		return walk;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setWalk(ArrayList<Point> walk) {
		this.walk = walk;
	}

	public void addPoint(Point p) {
		walk.add(p);
	}

	@Override
	public String toString() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {

		if (o instanceof Track) {
			return ((Track) o).getId().equals(this.id);
		} else {
			return super.equals(o);
		}
	}
	
	
}
