fun printValues() {
    // ОБЪЯВЛЕНИЕ ПЕРЕМЕННЫХ
    var x = 2 // Объявление переменной без указания типа
    var y: Int = 3 // Объявление переменной с определённым типом данных
    val w = 100 // Объявление константы (неизменяемое значение)
    var z = 4.5

    // ТИПЫ ПЕРЕМЕННЫХ
    var a: Int = 10 // Целочисленные значение со знаком
    var b: Float = 25.5F // 32-битное число с плавающей точкой
    var c: Double = 25.5 // 64-битное число с плавающей точкой двойной точности
    var d: Boolean = true // Логическое значение (true или false)
    var e: String = "Kotlin" // Последовательность символов (строка)
    var f: Char = 'K' // Представление символа
    var g = arrayOf(1, 2, "2", 4)

    // ФУНКЦИИ ВВОДА И ВЫВОДА
    print(a) // Вывод значений в консоль
    print(b) // Вывод значений в консоль
    println()
    println(c) // Вывод значений в консоль c переносом строки в конце
    println(d) // Вывод значений в консоль c переносом строки в конце
    println("Введите ваше имя:")
    var name = readln() // Ввод данных с консоли
//    var surname = readLine()
    println("Добрый день, $name") // Вывод значение переменной внутри строки

    // ОПЕРАЦИИ С ЧИСЛАМИ
    println(x + y) // Сложение
    println(x - y) // Вычитание
    println(x * y) // Умножение
    println(y / x) // Деление целочисленных значений
    println(z / x) // Деление дробного числа на целое возвращает дробное
    println(y % x) // Целочисленное деление с возвратом остатка
    var h = 5
//    var k = ++h // Инкремент с увеличением исходного значения на 1 и записью в новую переменную
    var k = h++ // Инкремент с увеличением исходного значения на 1
    println("h = $h, л = $k")
    // сокращенное присваивание в сочетании с арифметическим оператором
//    x += y // x = x + y
//    x -= y // x = x - y
//    x *= y // x = x * y
//    x /= y // x = x / y
//    x %= y // x = x * y
    println(x)

    // ЛОГИЧЕСКИЕ ОПЕРАТОРЫ
    // Операторы сравнения
    println(x > y) // больше, чем
    println(x < y) // меньше, чем
    println(x == y) // равно
    println(x != y) // не равно
    println(x <= y) // меньше или равно
    println(x >= y) // больше или равно

    println(x < y && x <= y) // Логическое И (конъюнкция)
    println(x < y || x > y) // Логическое ИЛИ (дизъюнкция)
    println(!(x < y)) // Логическое НЕ (отрицание)

    println((x < z) and (y < z)) // возвращает true, если обе операции истинны (true)
    println((x < z) or (y < z)) // возвращает true, если хоты бы одна операция истинна (true)
    println((x < z) xor (y < z)) // возвращает true, если только одна операция истинна (true)
    println((x < z).not()) // возвращает true при ложном выражении, false - при истинном
    println(5 in 1..10)
}

// Самостоятельно написанная функция (подпрограмма)
fun printSum(v1: Int, v2: Int){
    println(v1 + v2)
}

fun calc() {
    val x = readln().toInt() // Преобразование строки в целое число
    val y = readln().toInt() // Преобразование строки в целое число
    println(x + y)
    println(x - y)
    println(x * y)
    println(x / y)
}

// УСЛОВНЫЕ ВЫРАЖЕНИЯ
fun compare() {
    val x = readln().toInt()
    if (x > 10) { // Если x больше 10...
        println("Число больше 10!") // Вывести строку на экран!
    }
    else { // Иначе (в любом другом случае)...
        println("Число меньше 10!") // Вывести другую строку!
    }
}
fun health() {
    var hp = readln().toInt()
    if (hp >= 100) {
        println("Вы полностью исцелены!")
    }
    else if (hp >= 50) {
        println("У вас больше половины здоровья!")
    }
    else if (hp >= 25) {
        println("Здоровья осталась меньше половины!")
    }
    else {
        println("Здоровья совсем мало!")
    }
}
fun compareNumbers() {
    // сокращенная условная конструкция
    val a = readln().toInt()
    val b = readln().toInt()
    println(if (a > b) a else b)
}

// ВЫРАЖЕНИЕ WHEN
fun login() {
    var log = readln()
    when (log) {
        "Администратор" -> println("Администратор вошел в систему")
        "Гость" -> {
            println("Гость вошел в систему")
            println("Ваши данные не будут сохранены при выходе")
        }
        "Студент" -> println("Студент вошел в систему")
        else -> println("Неавторизированный пользователь. Доступ запрещен")
    }
}
fun age(){
    val a = readln().toInt()
    when (a) {
        0, 1 -> println("Младенец")
        in 2..6 -> println("Дошкольник")
        in 7..11 -> println("Младшеклассник")
        in 12..14 -> println("Средняя школа")
    }
}

// ДИАПАЗОНЫ
fun range(a: Int, b:Int) {
    var x = a..b // Создание диапазона. a - начало диапазона, b - конец (включительно)
    var y = b downTo a // Создание обратного диапазона
    var z = a..b step 2 // Создание диапазона с шагом в 2
    var w = b downTo a step 2 // Создание обратного диапазона с шагом 2
    var v = a until b // Создание диапазона без включения последнего элемента
    var c = "a"
    var d = "z"
    var e = c..d // Создание диапазона строки
    println(x)
    println(y)
    println(z)
    println(w)
    println(v)
}

// ЦИКЛЫ
// Цикл for
fun cycle2() {
    for (i in 1..10) {
        println("$i * 2 = ${i * 2}")
    }
}
fun cycleMultipy(){
    for (i in 1..10) {
        for (j in 1..10) {
            println("$j * $i = ${j * i}")
        }
        println()
    }
}
fun cycleRange() {
    // Перебор элементов диапазона
    for (i in 'А'..'я') println(i)
}
//Цикл while
fun cycleWhile() {
    var i = 0
    while (i != 10) {
        println("Продолжаю цикл. Шаг $i")
        i += 1
    }
    println("Цикл завершен!")
}
fun cycleWhileMultiply(){
    var i = 0
    while (i < 100) {
        var a = readln().toInt()
        var b = readln().toInt()
        println(a * b)
        if (a * b == a + b) break
        i += 1
    }
}
// Цикл do..while
fun cycleDoWhile() {
    var i = 10
    do {
        println("${i * i}")
        i -= 1
    }
    while (i > 0)
}

// МАССИВЫ
fun array(){
    var arr = arrayOf(1, 2, 3, 4, 5) // Массив с неявной типизацией
    var numbers: Array<Int> //Пустой массив целых чисел
    var numbers2: Array<Int> = arrayOf(1, 2, 3, 4, 5) // Создание массива целых чисел
    var number3 = arrayOfNulls<Int>(5) // Создание массива неизвестных значений длиной 5
    var number4 = Array(5, {9}) // Создание массива определенной длины с изначальным значением
    var a = 1
    var number5 = Array(5, {a++})
    println(number5[1]) // Обращение к элементу массива через его индекс
    number5[1] = 20 // Замена элемента массива по его индексу
    println(number5.size) // Проверка длины массива
    for (i in number5) { // Перебор значений массива
        println(i)
        println(i * i)
    }
    val names = arrayOf("Андрей", "Иван", "Олег", "Сергей", "Марина")
    println("Андрей" in names) // Проверка наличия элемента в массиве (true/false)
    println("Ольга" in names)
    var x: IntArray = intArrayOf(1, 2, 3) // Создание массива целых чисел
    var y: DoubleArray = doubleArrayOf(1.5, 2.2, 3.4) // Создание массива дробных чисел
    var z: CharArray = charArrayOf('a', 'b', 'c')  // Создание массива символов

}

// Основная функция (запуска программы)
fun main() {
    array()
//    cycleDoWhile()
//    cycleWhileMultiply()
//    cycleRange()
//    cycleMultipy()
//    cycle2()
//    range(1, 10)
//    login()
//    compareNumbers()
//    health()
//    compare()
//    printSum(100, 200)
//    printValues()
//    calc()
}