package com.santisr.hero.repositories


import com.santisr.hero.models.Hero
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface HeroRepository extends CrudRepository<Hero, Long> {
    Iterable<Hero> findAll(Sort sort);

    Page<Hero> findAll(Pageable pageable);
}