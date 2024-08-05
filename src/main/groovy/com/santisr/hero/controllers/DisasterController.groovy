package com.santisr.hero.controllers

import com.santisr.hero.models.Disaster
import com.santisr.hero.services.DisasterService
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping('disaster')
@Transactional
class DisasterController {
    @Autowired
    DisasterService disasterService

    @GetMapping('')
    List findAll() {
        disasterService.findAll()
    }

    @GetMapping('{id}')
    Disaster findById(@PathVariable long id) {
        disasterService.findById(id)
    }

    @PostMapping('')
    Disaster create(@RequestBody Disaster disaster) {
        disasterService.save(disaster)
    }

    @PutMapping('{id}')
    Disaster update(@RequestBody Disaster disaster, @PathVariable long id) {
        disasterService.update(disaster, id)
    }

    @PostMapping('{id}/hero/{heroId}')
    Disaster assignHero(@PathVariable long id, @PathVariable long heroId) {
        disasterService.assignHero(id, heroId)
    }

    @DeleteMapping('{id}/hero/{heroId}')
    Disaster removeHero(@PathVariable long id, @PathVariable long heroId) {
        disasterService.removeHero(id, heroId)
    }

    @PostMapping('{id}')
    Disaster resolve(@PathVariable long id) {
        disasterService.resolve(id)
    }

    @DeleteMapping('{id}')
    Disaster deleteById(@PathVariable long id) {
        disasterService.deleteById(id)
    }
}