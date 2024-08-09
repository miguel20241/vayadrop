package com.vayadrop.vayadrop.repository;

import com.vayadrop.vayadrop.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
