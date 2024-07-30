package com.vayadrop.vayadrop.repository;

import com.vayadrop.vayadrop.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
