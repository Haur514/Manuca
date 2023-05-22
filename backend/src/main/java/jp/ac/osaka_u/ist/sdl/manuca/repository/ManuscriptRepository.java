package jp.ac.osaka_u.ist.sdl.manuca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.osaka_u.ist.sdl.manuca.entity.ManuscriptEntity;

public interface ManuscriptRepository extends JpaRepository<ManuscriptEntity, Integer> {}
