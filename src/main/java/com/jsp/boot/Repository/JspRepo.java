package com.jsp.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.boot.Entity.JspEntity;

public interface JspRepo extends JpaRepository<JspEntity, Long> {

}
