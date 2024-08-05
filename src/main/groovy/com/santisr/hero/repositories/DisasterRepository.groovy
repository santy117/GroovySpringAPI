package com.santisr.hero.repositories


import com.santisr.hero.models.Disaster
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

// we only need CRUD for Disaster because it won't have its own endpoints
interface DisasterRepository extends CrudRepository<Disaster, Long> {}