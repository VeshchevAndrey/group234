fun main() {
    val comp1 : Companion = Companion()
    println(comp1.name)
    println(comp1.lastMessage)
    comp1.name = "Andrey"
    comp1.lastMessage = "Hello!"
    comp1.toString()
    println(comp1.name)
    println(comp1.lastMessage)
    comp1.showLastMessage()
    println(comp1.companionsName())
    println(comp1.isOnline(true))

    var comp2 : Companion2 = Companion2("Steve", "I'm Steve!")

    val user1 : User = User("mveshchev")
    println(user1.username)
    val user3 : User = User("student", "Студент 1")
    val user2 : User = User("admin", "Администратор", 18)

    val group1 : Group = Group("Students", 15)
    val autorization1 : Authorization = Authorization("admin", "admin")
    println("Login: ${autorization1.login}, password: ${autorization1.password}")

    val groupMember1 : GroupMember = GroupMember("Oleg")
    groupMember1.printName()
//    groupMember1.changeGroupName("My Group")
    val groupAdmin1 = GroupAdmin("Andrey")
    groupAdmin1.printName()
    groupAdmin1.changeGroupName("Andrey's Group")

    val per1: Person = Person("Мария")
    per1.personInfo()
    val per2: Adult = Adult("Олег")
    per2.personInfo()
    per2.job("Учитель")
    per2.spouse("Ольга")
    println("${per2.isWorks}, ${per2.isMarried}")
    per2.personInfo()
    val per3: Employee = Employee("Василий", "Менеджер", "Яндекс")
    per3.personInfo()
}


// Объявление класса
class Companion {
    var name : String = ""
    var lastMessage : String = ""

    fun showLastMessage(){
        println("$name's last message: $lastMessage")
    }

    fun companionsName(): String{
        return name
    }

    fun isOnline(online: Boolean) : String {
        return if (online) "Companion is online!" else "Companion is offline!"
    }
}

// Объявление класса с телом класса
class Companion2(objName: String, objLastMessage: String) {
    var name : String = objName
    var lastMessage : String = objLastMessage
}

// Объявление класса с первичным и вторичными конструкторами
class User(objUsername: String){
    var username : String = objUsername
    var name : String = ""
    var age : Int = 0

    constructor(objUsername: String, objName: String): this(objUsername){
        name = objName
    }

    constructor(objUsername: String, objName: String, objAge: Int): this(objUsername, objName){
        age = objAge
    }
}

// Создание свойств через первичный конструктор
class Group(var nameGroup: String, var countMember: Int)

// Объявление класса с инициализатором
class Authorization(objLogin: String, objPassword: String){
    var login: String = objLogin
    var password: String = objPassword

    init {
        login = objLogin
        if (objLogin != objPassword) password = objPassword else password = ""
    }
}

class Autorization2(objLogin: String, objPassword: String){
    var login: String = ""
    var password: String = ""

    init {
        login = objLogin
        if (objLogin != objPassword) password = objPassword
    }
}

// Класс с наследованием
open class GroupMember(objName: String){
    var name: String = objName
    var avatarID: Int = 0
    var joinedDate: String = ""
    var isOnline: Boolean = false

    fun printName(){
        println("Name: $name")
    }
}

class GroupAdmin(adminName: String): GroupMember(adminName){
    fun changeGroupName(newName: String){
        println("Group name changed to $newName")
    }
}

//class GroupAdmin: GroupMember{
//    constructor() : super()
//}

// Переопределение свойств и функций
open class Person(objName: String) {
    var name: String = objName
    open var age: Int = 0 // Открытое для переопределения свойство

    open fun personInfo(){
        println("Имя: $name, возраст: $age")
    }
}

open class Adult(objName: String): Person(objName){
    override var age: Int = 18 // Переопределённое свойство базового класса (суперкласса)
    var isWorks: Boolean = false
    var isMarried: Boolean = false
    open var job: String = "нет"
    var spouse: String = "нет"

    override fun personInfo() {
        println("Имя: $name, возраст: $age, работа: $job, супруг(а): $spouse")
    }

    fun job(objJob: String){
        job = objJob
        isWorks = true
    }
    fun spouse(spouseName: String){
        spouse = spouseName
        isMarried = true
    }
}

class Employee(objName: String, objJob: String, objCompany: String): Adult(objName){
    var company: String = objCompany
    override var job: String = objJob

    override fun personInfo() {

        println("Имя: $name, возраст: $age, работа: $job, компания: $company")
    }
}
