package com.techm.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.techm.mvc.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
