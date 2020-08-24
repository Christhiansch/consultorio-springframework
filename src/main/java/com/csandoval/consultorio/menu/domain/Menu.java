package com.csandoval.consultorio.menu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.csandoval.consultorio.rol.domain.Rol;

@Entity
@Table(name = "menus")
public class Menu
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "description", nullable = false, length = 50)
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_rol"
	, joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id")
	, inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
	private List<Rol> roles;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<Rol> getRoles()
	{
		return roles;
	}

	public void setRoles(List<Rol> roles)
	{
		this.roles = roles;
	}

}
