package com.santisr.hero.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    @OneToMany( // tell persistence provider 'abilities' is one-to-many relation with Ability
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, // cascade all operation to 'abilities' values
            orphanRemoval = true, // auto delete Ability entity that has no Hero
            mappedBy = 'hero' // mark for bi-directional relation
    )
    List<Ability> abilities

    @ManyToMany(mappedBy = 'heroes')
    @JsonIgnore
    Set<Disaster> disasters

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Hero)) return false

        Hero hero = (Hero) o

        if (id != hero.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }
}