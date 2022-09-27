import Pyro4

uri = input("What is the Pyro uri of the greeting object? ").strip()

s = Pyro4.Proxy(uri)


while True:
    key = int(input('\n0. Exit\n1. Enter new caloricity for vegetables\n2. Get salad caloricity\n3. Serialization\n4. Deserialization\nEnter number of task: '))      
    if(key == 0):
        break
    elif(key == 1): 
        x = int(input('\nEnter caloricity potato: '))
        y = int(input('Enter caloricity tomato: '))
        z = int(input('Enter caloricity onion: '))
        w = int(input('Enter caloricity cucumber: '))
        s.set_information(x, y, z, w)
    elif(key == 2):
        print('\nSalad caloricity: ' + str(s.get_salad_cal()))
    elif(key == 3):
        s.serialization()
    elif(key == 4): 
        s.deserialization()
    else:
        print('Task don\'t find!!!')
