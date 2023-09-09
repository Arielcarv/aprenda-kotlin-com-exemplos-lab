import java.util.UUID

enum class Level { BASIC, INTERMEDIATE, ADVANCED }

class User(
    id: UUID,
    private val name: String,
    private val surname: String? = null,
    var age: Int? = null,
    var email: String
) {
    init {
        println("Id: $id, Name: $name, Surname: $surname")
    }

    override fun toString(): String {
        return "$name $surname"
    }
}

data class EducationalContent(var name: String, val duration: Int) {
    init {
        println("Registered Content: $name - $duration min")
    }
}

data class Course(val name: String, var content: List<EducationalContent>, val level: Level) {
    init {
        println("Registered Course: $name - $level")
    }

    override fun toString(): String {
        return name
    }

    val registeredUsers = mutableListOf<User>()

    fun register(user: User) {
        println("Adding $user to $name...")
        registeredUsers.add(user)
    }

    fun unregister(user: User) {
        println("Removing $user from $name...")
        registeredUsers.remove(user)
    }
}

fun main() {

    println("============  USERS CREATION ================")
    val user1 = User(UUID.randomUUID(), "John", "Doe", email = "johndoe@gmail.com")
    val user2 = User(UUID.randomUUID(), "Walter", "White", 52, "walterwhite@gmail.com")
    val user3 = User(UUID.randomUUID(), "Luffy", "Monkey D.", 19, "monkeyd@gmail.com")

    println("============  CONTENT CREATION ================")
    val content1 = EducationalContent("Knowing Kotlin and its Documentation", 60)
    val content2 = EducationalContent("Introduction to Kotlin", 120)
    val content3 = EducationalContent("Control Structures and Collections", 120)
    val content4 = EducationalContent("Object Oriented Programming & Classes in Kotlin", 120)
    val content5 = EducationalContent("Kotlin Functions", 120)

    println("============  COURSE CREATION ================")
    val course = Course(
        "Mobile Android with Kotlin",
        listOf(content1, content2, content3, content4, content5),
        Level.INTERMEDIATE
    )

    println("============  REGISTER USERS ON COURSE ================")
    course.register(user1)
    course.register(user2)
    course.register(user3)

    println("REGISTERED USERS: $course ${course.registeredUsers}")

    println("============  UNREGISTER USERS TO COURSE ================")
    course.unregister(user1)
    course.unregister(user3)
    println("REGISTERED USERS: $course ${course.registeredUsers}")
}
