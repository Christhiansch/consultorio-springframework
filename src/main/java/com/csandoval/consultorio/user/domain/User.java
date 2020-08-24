package com.csandoval.consultorio.user.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.csandoval.consultorio.rol.domain.Rol;



@Entity
@Table(name = "users")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username", nullable = false, length = 50)
	private String username;

	@Column(name = "password", nullable = false, length = 100)
	private String password;

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@Column(name = "state", nullable = false)
	private boolean state;

	@ManyToMany(fetch = FetchType.EAGER)
	
	@JoinTable(name = "user_rol"	
	, joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_rol"))
	, inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "rol_user")))
	private List<Rol> roles;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isState()
	{
		return state;
	}

	public void setState(boolean state)
	{
		this.state = state;
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
