package com.bss.personal.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"Class_Type\"", schema = "Public")
public class ClassType implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_Sequence")
	@SequenceGenerator(name="id_Sequence", schema="Public", sequenceName="\"Seq_ClassType\"", allocationSize=1)
	@Column(name="\"Class_Id\"", unique=true, nullable=false)         
	private Long id;                                   	    

	@Column(name="\"Class_Type\"")
	private String classType;
}
