package jp.ac.osaka_u.ist.sdl.manuca.repository;

import jp.ac.osaka_u.ist.sdl.manuca.entity.ManuscriptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManuscriptRepository extends JpaRepository<ManuscriptEntity, Integer> {}
