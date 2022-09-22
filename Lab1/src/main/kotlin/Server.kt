import java.rmi.AlreadyBoundException
import java.rmi.Remote
import java.rmi.RemoteException
import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry


object Server {

    private const val PORT = 1099
    private val registry: Registry by lazy { LocateRegistry.createRegistry(PORT) }

    @Throws(RemoteException::class, AlreadyBoundException::class)
    fun registerObject(name: String, remoteObj: Remote) {
        registry.bind(name, remoteObj)
        println("Registered: $name -> ${remoteObj.javaClass.name}[$remoteObj]")
    }

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Server starting...")
        registerObject(PopulatedPoint::class.java.simpleName, PopulatedPoint(15))
        // Server was the start, and was listening to the request from the
        println("Server started!")
        while (true) {}
    }
}