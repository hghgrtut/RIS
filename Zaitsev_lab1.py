import re # подключаем библиотеку re


def base(): # создаем функцию base

    reg = re.match(r'[abcdefghijklmnopqrstuv5320736]{29}', input('Enter base string: ')) # методом match ищем заданное регулярное выражение
    
    if reg is None: # если введенная строка не соответствует регулярному выражению, то в pat записывается None
        print('BAAAAD JOOOB') # выводим 'BAAAAD JOOOB', если pat == None
    else:
        print('GOOOOOOOD JOOOB')


def Zaitsev(): # создаем функцию Zaitsev

    reg = re.match(r'#[0-9a-fA-F]{6}', input('Enter color identificator: ')) # методом match ищем заданное регулярное выражение
    
    if reg is None: # если введенная строка не соответствует регулярному выражению, то в pat записывается None
        print('BAAAAD JOOOB')
    else:
        print('GOOOOOOOD JOOOB')


if __name__ == '__main__':
    while True: # бесконечный цикл
        base() # вызываем функции:)
        Zaitsev()
