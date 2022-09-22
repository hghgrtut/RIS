import Server.PORT
import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry


object Client {

    // Host or IP of Server
    private const val HOST = "localhost"

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val registry: Registry = LocateRegistry.getRegistry(HOST, PORT) // Search the registry in the specific Host, Port.
        val service: PopulatedPoint = // get PopulatedPoint instance from server
            LocateRegistry.getRegistry(HOST, PORT).lookup(PopulatedPoint::class.java.simpleName) as PopulatedPoint
        service.printPopulation() // execute some code of remote class
    }
}