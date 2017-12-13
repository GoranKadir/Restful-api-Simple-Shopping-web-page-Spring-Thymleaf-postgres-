package com.gorankadir.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorankadir.se.entities.Clothes;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {

}
