package com.vayadrop.vayadrop.repository;

import com.vayadrop.vayadrop.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
