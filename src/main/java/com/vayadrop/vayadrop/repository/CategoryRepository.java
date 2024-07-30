package com.vayadrop.vayadrop.repository;

import com.vayadrop.vayadrop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
