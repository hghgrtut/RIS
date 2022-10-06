import pickle # подключение библиотеки


class Photo: # Родительский(базовый) класс Photo
    col_photos = 0 # статическая переменная для подсчета количества фотографий (созданных объектов)

    def __init__(self, name_photo, size_photo): # конструктор класса
        self.name_photo = name_photo
        self.size_photo = size_photo
        Photo.col_photos += 1

    def get_photo(self): # метод для получения фотографии
        print(self.name_photo, self.size_photo)


class PhotoAlbum(Photo): # дочерний класс
    di = {} # статический словарь

    def __init__(self, name_photo, size_photo): # конструктор класса
        Photo.__init__(self, name_photo, size_photo) # инициализация полей класса
        PhotoAlbum.di['name_photo' + str(Photo.col_photos)] = self.name_photo # заполнение словаря
        PhotoAlbum.di['size_photo' + str(Photo.col_photos)] = self.size_photo

    def serialization(self): # метод сериализации данных класса
        print('Serialized album of ' + str(Photo.col_photos) +' photos:\n' + str(pickle.dumps(PhotoAlbum.di)))
        pickle.dump(PhotoAlbum.di, open('photoAlbum.txt', 'wb'))
   
    def deserialization(self): # метод десириализации данных класса
        x = pickle.load(open('photoAlbum.txt', 'rb'))
        print('\nDeserialized album of ' + str(Photo.col_photos) + ' photos:\n' + str(x))
               

if __name__ == '__main__':
    a = PhotoAlbum('Igor', 32.2)
    b = PhotoAlbum('Dima', 12.323)
    z = PhotoAlbum('Kirill', 0.999)
    z.serialization()
    z.deserialization()

