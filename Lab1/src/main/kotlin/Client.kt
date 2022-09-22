import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry


object Client {

    // Host or IP of Server
    private const val HOST = "localhost"
    private const val PORT = 1099

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        // Search the registry in the specific Host, Port.
        val registry: Registry = LocateRegistry.getRegistry(HOST, PORT)
        // Lookup WeatherService in the Registry.
        val service: PopulatedPoint =
            LocateRegistry.getRegistry(HOST, PORT).lookup(PopulatedPoint::class.java.simpleName) as PopulatedPoint
        service.printPopulation()
    }
}