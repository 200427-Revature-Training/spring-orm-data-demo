package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sports")
public class Sport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Column(name="minimum_players")
	private int minimumPlayers;
	private String type;
	private boolean contact;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinimumPlayers() {
		return minimumPlayers;
	}

	public void setMinimumPlayers(int minimumPlayers) {
		this.minimumPlayers = minimumPlayers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isContact() {
		return contact;
	}

	public void setContact(boolean contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (contact ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + minimumPlayers;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sport other = (Sport) obj;
		if (contact != other.contact)
			return false;
		if (id != other.id)
			return false;
		if (minimumPlayers != other.minimumPlayers)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", minimumPlayers=" + minimumPlayers + ", type=" + type
				+ ", contact=" + contact + "]";
	}

	public Sport(int id, String name, int minimumPlayers, String type, boolean contact) {
		super();
		this.id = id;
		this.name = name;
		this.minimumPlayers = minimumPlayers;
		this.type = type;
		this.contact = contact;
	}

	public Sport() {
		super();
		// TODO Auto-generated constructor stub
	}

}
