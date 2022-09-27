import Pyro4
import pickle

@Pyro4.expose
class Potato:
    def __init__(self, potato_cal):
        self.potato_cal = potato_cal

class Tomato:
    def __init__(self, tomato_cal):
        self.tomato_cal = tomato_cal

class Onion:
    def __init__(self, onion_cal):
        self.onion_cal = onion_cal

class Cucumber:
    def __init__(self, cucumber_cal):
        self.cucumber_cal = cucumber_cal

class Salad(Potato, Tomato, Onion, Cucumber):
    def set_information(self, potato_cal, tomato_cal, onion_cal, cucumber_cal):
        Potato.__init__(self, potato_cal)
        Tomato.__init__(self, tomato_cal)
        Onion.__init__(self, onion_cal)
        Cucumber.__init__(self, cucumber_cal)

    def get_salad_cal(self):
        n = self.potato_cal + self.tomato_cal + self.onion_cal + self.cucumber_cal
        return n

    def serialization(self):
        print('\n')
        z = {'potato_cal': self.potato_cal, 'tomato_cal': self.tomato_cal, 'onion_cal': self.onion_cal, 'cucumber_cal': self.cucumber_cal, 'salad_cal': self.get_salad_cal() }
        print(pickle.dumps(z))
        pickle.dump(z, open('simple1.pkl', 'wb'))
        

    def deserialization(self):
        print('\n')
        x = pickle.load(open('simple1.pkl', 'rb'))
        print(x)


daemon = Pyro4.Daemon()                
uri = daemon.register(Salad)   

print("URI =", uri)
daemon.requestLoop() 
