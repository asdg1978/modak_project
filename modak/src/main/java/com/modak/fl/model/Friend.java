package com.modak.fl.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.modak.fl.enums.EnumPersonDocumentType;

/**
 *
 */
@Entity
@Table(name = "FRIENDS")
public class Friend extends BaseModelImpl {



    /**
	 *
	 */
	private static final long serialVersionUID = 5557427183019281997L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DOCUMENT_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumPersonDocumentType documentType;

    @Column(name = "DOCUMENT_NUMBER", nullable = false)
    private Long documentNumber;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;


    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "friends_lessons",
				joinColumns = @JoinColumn(name = "friend_id"),
				inverseJoinColumns = @JoinColumn(name = "lesson_id"))
	private Set<Lesson> lessons = new HashSet<>();


    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false, updatable = false)
	private User user;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EnumPersonDocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(EnumPersonDocumentType documentType) {
		this.documentType = documentType;
	}

	public Long getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}



}
