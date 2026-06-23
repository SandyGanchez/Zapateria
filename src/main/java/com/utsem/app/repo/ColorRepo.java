package com.utsem.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utsem.app.model.Color;

public interface ColorRepo extends JpaRepository<Color, Long> {

}