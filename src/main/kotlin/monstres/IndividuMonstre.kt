package org.example.monstres
import kotlin.math.roundToInt
import kotlin.math.pow
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


    var exp: Double = 0.0
        get() = field
        set(value) {
            field = value

            val estNiveau1 = niveau == 1

            while (field >= palierExp(niveau)) {

                levelUp()

                if (estNiveau1 == false) {
                    println("Le monstre $nom est maintenant niveau $niveau !")
                }
            }
        }

    fun palierExp(niveau: Int): Double {
        return 100 * (niveau - 1).toDouble().pow(2.0)
    }


    /**
     * Augmente le niveau du monstre et ses caractéristiques.
     */
    fun levelUp() {
        niveau++

        attaque += (espece.modAttaque * potentiel).roundToInt() + (-2..2).random()
        defense += (espece.modDefense * potentiel).roundToInt() + (-2..2).random()
        vitesse += (espece.modVitesse * potentiel).roundToInt() + (-2..2).random()
        attaqueSpe += (espece.modAttaqueSpe * potentiel).roundToInt() + (-2..2).random()
        defenseSpe += (espece.modDefenseSpe * potentiel).roundToInt() + (-2..2).random()

        val ancienPvMax = pvMax

        pvMax += (espece.modPv * potentiel).roundToInt() + (-5..5).random()

        val pvGagnes = pvMax - ancienPvMax

        pv += pvGagnes
    }
    init {
        this.exp = expInit // applique le setter et déclenche un éventuel level-up
    }


fun attaquer(cible: IndividuMonstre){
    val degatBrut = this.attaque

    var degatTotal = degatBrut - (this.defense / 2)

    if (degatTotal < 1) {
        degatTotal = 1
    }

    val pvAvant = cible.pv

    cible.pv -= degatTotal

    val pvApres = cible.pv

    println("$nom inflige ${pvAvant - pvApres} dégâts à ${cible.nom}")
}


    fun renommer() {
        println("Nouveau nom pour votre Pokémon :")

        var nouveauNom = readln()

        if (nouveauNom.isNotEmpty()) {
            this.nom = nouveauNom
        }
    }














}