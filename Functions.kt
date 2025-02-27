fun main(){
//    for (i in 1..10){
//        hello()
//        user(readln(), readln().toInt())
//        user2("Андрей", 26, "Преподаватель")
//        user2("Олег", 15)
//        user2(age = 12, name = "Степан")
//        user2("Ольга", position = "Студент", age = 17)
//        employeeAge(intArrayOf(1, 2, 3))
//    }
//    println(sqr(2))
//    // Уравнение (a^2 + 3) / (x - 1)
//    var x: Int = readln().toInt()
//    var a: Int = readln().toInt()
//    println((sqr(a) + 3) / (x - 1))
//    employee("Андрей", "Олег", "Иван")
//    position("Преподаватель", "Марина", "Иван", "Оксана", "Михаил")
//    students("1213", "Михаил", "Даниил", "Марк", "Анна", course=2)
    val n = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    numbers(*n)
}

// Простая функция
fun hello(){
    println("Hello World!")
}
// Функция с параметром. Параметры именнованные
fun user(name: String, age: Int){
    println("Имя: $name, Возраст: $age")
}
// Функция с необязательным параметром. Параметры именнованные
fun user2(name: String, age: Int, position: String="Безработный"){ // position имеет изначальное значение
    println("Имя: $name, Возраст: $age, Сфера работы: $position")
}

// Параметры функции изменить нельзя!
//fun employee(name: String, surname: String){
//    surname = readln()
//}

// Изменение значений параметра, представляющего из себя сложный объект (массив чисел)
fun employeeAge(empl: IntArray){
    println("Изначальное значение empl[0] - ${empl[0]}")
    empl[0] = empl[0] + 1
    println("Изменённое значение empl[0] - ${empl[0]}")
}

// Возврат результата выполнения команд функции
fun sqr(x: Int): Int{
    return x * x
}

// Функция с параметром, принимающим переменное количество значений одного типа (String)
fun employee(vararg names: String){
    for (i in names) println(i)
}

// Функция с обычным (name, может иметь одно значение) и переменным (employee, много значений) аргументами
fun position(name: String, vararg employee: String){
    println(name)
    for (i in employee) println(i)
}

fun students(name: String, vararg student: String, course: Int){
    println(name)
    for (i in student) println(i)
    println(course)
}

fun numbers(vararg number: Int){
    for (i in number) println(i)
}