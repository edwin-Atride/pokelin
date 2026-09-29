package org.example.monstres
import java.io.File

/**
 *
 *    * @property id Identifiant de l'espèce.
 *      * @property nom Nom de l'espèce, utilisé aussi pour retrouver son art ASCII.
 *      * @property type Élément de l'espèce, par exemple Feu, Eau ou Plante.
 *      * @property baseAttaque Valeur de départ de l'attaque physique.
 *      * @property baseDefense Valeur de départ de la défense physique.
 *      * @property baseVitesse Valeur de départ de la vitesse.
 *      * @property baseAttaqueSpe Valeur de départ de l'attaque spéciale.
 *      * @property baseDefenseSpe Valeur de départ de la défense spéciale.
 *      * @property basePv Valeur de départ des points de vie maximum.
 *      * @property modAttaque Croissance de l'attaque lors d'une montée de niveau.
 *      * @property modDefense Croissance de la défense lors d'une montée de niveau.
 *      * @property modVitesse Croissance de la vitesse lors d'une montée de niveau.
 *      * @property modAttaqueSpe Croissance de l'attaque spéciale lors d'une montée de niveau.
 *      * @property modDefenseSpe Croissance de la défense spéciale lors d'une montée de niveau.
 *      * @property modPv Croissance des points de vie maximum lors d'une montée de niveau.
 *      * @property description Texte présentant l'espèce.
 *      * @property particularites Traits qui distinguent cette espèce.
 *      * @property caractères Traits de caractère associés à cette espèce
 */
class EspeceMonstre(
    var id : Int,
    var nom: String,
    var type: String,
    val baseAttaque: Int,
    val baseDefense: Int,
    val baseVitesse: Int,
    val baseAttaqueSpe: Int,
    val baseDefenseSpe: Int,
    val basePv: Int,
    val modAttaque: Double,
    val modDefense: Double,
    val modVitesse: Double,
    val modAttaqueSpe: Double,
    val modDefenseSpe: Double,
    val modPv: Double,
    val description: String = "",
    val particularites: String = "",
    val caractères: String = "",){
    /**
     * Affiche la représentation artistique ASCII du monstre.
     * Représente une espèce de monstre.
     *Une espèce définit les caractéristiques de base communes à tous ses individus.
     * Chaque individu peut ensuite avoir ses propres statistiques et son propre niveau.
     *
     *
     *
     *
     * @param deFace Détermine si l'art affiché est de face (true) ou de
    dos (false).
     * La valeur par défaut est true.
     * @return Une chaîne de caractères contenant l'art ASCII du monstre
    avec les codes couleur ANSI.
     * L'art est lu à partir d'un fichier texte dans le dossier
    resources/art.
     */
    fun afficheArt(deFace: Boolean=true): String{
        val nomFichier = if(deFace) "front" else "back";
        val art= File("src/main/resources/art/${this.nom.lowercase()}/$nomFichier.txt").readText()
        val safeArt = art.replace("/", "⁄")
        return safeArt.replace("\\u001B", "\u001B")
    }
}