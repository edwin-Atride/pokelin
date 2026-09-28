package org.example.monde

import org.example.monstres.EspeceMonstre

import java.time.LocalDateTime

/**
 * Représente une zone du monde.
 *
 * Les zones forment une chaîne de routes.
 */
class Zone(
    var id: Int,
    var nom: String,
    var expZone: Int,
    var especesMonstres: MutableList<EspeceMonstre> = mutableListOf(),
    var zoneSuivante: Zone? = null,
    var zonePrecedente: Zone? = null
) {

    // TODO faire la méthode genereMonstre()

    // TODO faire la méthode rencontreMonstre()
}