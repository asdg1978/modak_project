package com.modak.fl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.modak.fl.enums.EnumLessonType;

/**
 *
 */
@Entity
@Table(name = "LESSONS")
public class Lesson extends BaseModelImpl {




	/**
	 *
	 */
	private static final long serialVersionUID = -5136431514519798596L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "LESSON_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumLessonType documentType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnumLessonType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(EnumLessonType documentType) {
		this.documentType = documentType;
	}



}
