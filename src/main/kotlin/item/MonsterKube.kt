package org.example.item

import org.example.monstres.IndividuMonstre
import org.example.joueur
import kotlin.random.Random

class MonsterKube(
    id: Int,
    nom: String,
    description: String,
    var chanceCapture: Double
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {

        println("Vous lancez le Monster Kube !")

        if (cible.entraineur != null) {
            println("Le monstre ne peut pas être capturé.")
            return false
        }

        val nbAleatoire = Random.nextDouble(0.0, 100.0)

        if (nbAleatoire < chanceCapture) {

            println("Le monstre est capturé !")

            cible.renommer()

            if (joueur.equipeMonstre.size >= 6) {
                joueur.boiteMonstre.add(cible)
            } else {
                joueur.equipeMonstre.add(cible)
            }

            cible.entraineur = joueur

            return true
        }

        println("Presque ! Le Kube n'a pas pu capturer le monstre !")

        return false
    }
}