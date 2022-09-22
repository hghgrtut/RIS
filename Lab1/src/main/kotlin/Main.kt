import java.io.Serializable
import java.rmi.Remote

class Country() {

    val list: MutableList<PopulatedPoint> = mutableListOf()
}

open class PopulatedPoint(var population: Int) : Serializable, Remote {

    fun printPopulation() = println(population)
    private companion object  { const val serialVersionUID = 1L }
}

open class Village(population: Int, val cowsPopulation: Int) : PopulatedPoint(population) {

    private companion object  { const val serialVersionUID = 1L }
}

open class CityTypeVillage(val buildings: List<Building>, population: Int) : PopulatedPoint(population) {

    private companion object  { const val serialVersionUID = 1L }
}

open class City(buildings: List<Building>, population: Int, var cityManager: Name) : CityTypeVillage(buildings, population) {

    private companion object  { const val serialVersionUID = 1L }
}

open class Capital(buildings: List<Building>, population: Int, cityManager: Name, val president: Name) : City(buildings, population, cityManager) {

    private companion object  { const val serialVersionUID = 1L }
}

@JvmInline
value class Name(val name: String)

sealed class Building(val length: Float, val width: Float, val height: Float) {
    class House(var population: Int, length: Float, width: Float, height: Float) : Building(length, width, height)
    class TrainingCenter(var sport: String, length: Float, width: Float, height: Float) : Building(length, width, height)
    class Shop(var products: String, length: Float, width: Float, height: Float) : Building(length, width, height)
    class Market(val shopsInside: Int, length: Float, width: Float, height: Float) : Building(length, width, height)
    class Office(var workers: Int, length: Float, width: Float, height: Float) : Building(length, width, height)
    class Factory(var workers: Int, var production: String,     length: Float, width: Float, height: Float) : Building(length, width, height)
}