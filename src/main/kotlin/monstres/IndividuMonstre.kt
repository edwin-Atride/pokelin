package org.example.monstres


import org.example.dresseur.Entraineur

/**
 * Représente un individu monstre.
 *
 * Plusieurs individus peuvent appartenir à la même espèce.
 * Exemple : plusieurs Canaros peuvent exister.
 */
class IndividuMonstre(
    var id: Int,
    var nom: String,
    expInit: Double,
    var espece: EspeceMonstre,
    var entraineur: Entraineur? = null
) {
    var niveau: Int = 1
    var attaque: Int = espece.baseAttaque + (-2..2).random()
    var defense: Int = espece.baseDefense + (-2..2).random()
    var vitesse: Int = espece.baseVitesse + (-2..2).random()
    var attaqueSpe: Int = espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe: Int = espece.baseDefenseSpe + (-2..2).random()
    var pvMax: Int = espece.basePv + (-5..5).random()
    var potentiel: Double = (50..200).random() / 100.0

    /**
     *  @property pv  Points de vie actuels.
     * Ne peut pas être inférieur à 0 ni supérieur à [pvMax].
     */
    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
           if(nouveauPv<0){
               field=0
           }else if (nouveauPv>pvMax){
               field=pvMax
           } else{
               field=nouveauPv
           }
        }
























}