
import Pyro4

uri = input("What is the Pyro uri of the greeting object? ").strip()
name = 'Igor'
size = 23

connection = Pyro4.Proxy(uri)         # get a Pyro proxy to the greeting object
connection.set_information(name, size)   # call method normally
connection.serialization()
connection.deserialization()