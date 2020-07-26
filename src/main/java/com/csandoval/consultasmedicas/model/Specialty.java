package com.csandoval.consultasmedicas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Specialty
{

	@Id
	@Column
	private Integer id;

	@Column
	private String name;
}
