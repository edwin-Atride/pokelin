package org.example
import org.example.dresseur.Entraineur
import org.example.monstres.EspeceMonstre
import org.example.monde.Zone
import org.example.monstres.IndividuMonstre

//Player
var joueur = Entraineur(1,"Sacha",100)

//pokemon
var arcko = EspeceMonstre(1, "arcko", "plante", 9, 11, 10, 12, 14, 60, 6.5, 9.0, 8.0, 7.0, 10.0, 34.0, "Petit monstre espiègle rond comme une graine, adore le soleil.", "Sa feuille sur la tête indique son humeur.", "Curieux, amical, timide")

var ouisticram = EspeceMonstre(4, "ouisticram", "feux", 12, 8, 13, 16, 7, 50, 10.0, 5.5, 9.5, 9.5, 6.5, 22.0, "Petit animal entouré de flammes, déteste le froid.", "Sa flamme change d’intensité selon son énergie.", "Impulsif, joueur, loyal")

var grenousse = EspeceMonstre(7, "grenousse", "eau", 10, 11, 9, 14, 14, 55, 9.0, 10.0, 7.5, 12.0, 12.0, 27.0, "Créature vaporeuse semblable à un nuage, produit des gouttes pures.", "Fait baisser la température en s’endormant.", "Calme, rêveur, mystérieux")

//Zone
//var route1 = Zone(1,"route1",5,mutableListOf(ouisticram))
//var route2 = Zone(2,"route2",5,mutableListOf(arcko))


fun main() {
    //route1.zoneSuivante = route2
    //route2.zonePrecedente = route1
    //joueur.afficheDetail()
    //println(ouisticram.afficheArt())
    //println(grenousse.afficheArt())
    //println(arcko.afficheArt())

        val monstre1 = IndividuMonstre(1, "Ouisticram", 56789.0, ouisticram)
        val monstre2 = IndividuMonstre(2, "Arcko", 1500.0, arcko)
        val monstre3 = IndividuMonstre(3, "Grenousse", 1500.0, grenousse)
    ///exp teste
        //println("${monstre1.nom} - Niveau ${monstre1.niveau}")
        //println("${monstre2.nom} - Niveau ${monstre2.niveau}")
        //println("${monstre3.nom} - Niveau ${monstre3.niveau}")
    ///attaque teste
        //println("PV de Grenousse avant : ${monstre3.pv}")
        //monstre1.attaquer(monstre3)
        //println("PV de Grenousse après : ${monstre3.pv}")
    ///renommer teste
        println(monstre1.nom)
        monstre1.renommer()
        println(monstre1.nom)
}
/**
 * Change la couleur du message donné selon le nom de la couleur spécifié.
 * Cette fonction utilise les codes d'échappement ANSI pour appliquer une couleur à la sortie console. Si un nom de couleur
 * non reconnu ou une chaîne vide est fourni, aucune couleur n'est appliquée.
 *
 * @param message Le message auquel la couleur sera appliquée.
 * @param couleur Le nom de la couleur à appliquer (ex: "rouge", "vert", "bleu"). Par défaut c'est une chaîne vide, ce qui n'applique aucune couleur.
 * @return Le message coloré sous forme de chaîne, ou le même message si aucune couleur n'est appliquée.
 */

fun changeCouleur(message: String, couleur: String = ""): String {
    val reset = "\u001B[0m"

    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        else -> "" // pas de couleur si non reconnu
    }

    return "$codeCouleur$message$reset"
}
