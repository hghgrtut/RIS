import Pyro4
import pickle

@Pyro4.expose
class Photo:  # Родительский(базовый) класс Photo
    col_photos = 0  # статическая переменная для подсчета количества фотографий (созданных объектов)

    def __init__(self, name_photo, size_photo):  # конструктор класса
        self.name_photo = name_photo
        self.size_photo = size_photo
        Photo.col_photos += 1

    def get_photo(self):  # метод для получения фотографии
        print(self.name_photo, self.size_photo)


class PhotoAlbum(object, Photo):  # дочерний класс
    di = {}  # статический словарь

    def set_information(self, name_photo, size_photo):  # конструктор класса
        Photo.__init__(self, name_photo, size_photo)  # инициализация полей класса
        PhotoAlbum.di['name_photo' + str(Photo.col_photos)] = self.name_photo  # заполнение словаря
        PhotoAlbum.di['size_photo' + str(Photo.col_photos)] = self.size_photo

    def serialization(self):  # метод сериализации данных класса
        print('Serialized album of ' + str(Photo.col_photos) + ' photos:\n' + str(pickle.dumps(PhotoAlbum.di)))
        pickle.dump(PhotoAlbum.di, open('photoAlbum.txt', 'wb'))

    def deserialization(self):  # метод десириализации данных класса
        x = pickle.load(open('photoAlbum.txt', 'rb'))
        print('\nDeserialized album of ' + str(Photo.col_photos) + ' photos:\n' + str(x))


daemon = Pyro4.Daemon()                # make a Pyro daemon
uri = daemon.register(PhotoAlbum)   # register the greeting maker as a Pyro object

print("URI =", uri)      # print the uri so we can use it in the client later
daemon.requestLoop()                   # start the event loop of the server to wait for calls