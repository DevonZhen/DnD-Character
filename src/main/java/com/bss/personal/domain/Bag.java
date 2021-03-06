package com.bss.personal.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
@Entity
@Table(name = "\"Bag\"", schema = "Public")
public class Bag implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_Sequence")
	@SequenceGenerator(name="id_Sequence", schema="Public", sequenceName="\"Seq_Bag\"", allocationSize=1)
	@Column(name="\"Bag_Id\"", unique=true, nullable=false)         
	private Long id; 
	
	@Column(name="\"Bag_Name\"")
	private String bagName;

	@Column(name="\"Char_Id\"")
	private Long charId;
	
	// 1 - ∞ Bag to Items
	@OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Item> itemList = Lists.newArrayList();
	
	//∞ - 1 Bag to Characters
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"Char_Id\"", nullable = false,insertable=false, updatable=false)
    private Character character;
}
