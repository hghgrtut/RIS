import java.rmi.AlreadyBoundException
import java.rmi.Remote
import java.rmi.RemoteException
import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry


object Server {

    const val PORT = 1099 // Port for our server
    private val registry: Registry by lazy { LocateRegistry.createRegistry(PORT) } // Registry for our server

    @Throws(RemoteException::class, AlreadyBoundException::class) // Explicitly annotate to show that this method can produce Remote and AlreadyBound exceptions
    fun registerObject(name: String, remoteObj: Remote) {
        registry.bind(name, remoteObj) // binds some class instance to specific name
        println("Registered: $name -> ${remoteObj.javaClass.name}[$remoteObj]") // Log initialized object
    }

    @JvmStatic // Annotation to generate all variants of this function
    fun main(args: Array<String>) {
        println("Server starting...") // Log start of initializing of the server
        registerObject(PopulatedPoint::class.java.simpleName, PopulatedPoint(15))
        println("Server started!") // Log end of initializing of the server
        while (true) {} // Endless cycle that prevents server from immediately shutting down
    }
}