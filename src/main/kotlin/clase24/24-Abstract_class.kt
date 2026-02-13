package class24


import class23.Email
import java.util.UUID
//lograr algo similar a interfaces con abstract
abstract class BaseEmailRepository{
    abstract val sizeEmails:Int
    abstract fun save(email: Email)
    abstract fun findById(id: UUID):Email?
    abstract fun findAll():List<Email>
    abstract fun deleteEmailById(id: UUID)
}

class InMemoryAbstractEmailRepository: BaseEmailRepository() {

    private val emails = mutableListOf<Email>()

    override val sizeEmails: Int
        get() = emails.size

    override fun save(email: Email) {
        emails.add(email)
    }

    override fun findById(id: UUID): Email? {
        return emails.find{ email-> email.id == id}
    }

    override fun findAll(): List<Email> =  emails

    override fun deleteEmailById(id: UUID) {
        emails.removeIf { email-> email.id == id }
    }
}

fun main(){

    val emailsRepository = InMemoryAbstractEmailRepository()

    println("Emails en repositorio:${emailsRepository.sizeEmails}" )
    emailsRepository.save(
        Email(
            UUID.randomUUID(),
            asunto = "email 1",
            mensaje = "Contenido"
        )
    )

    println( emailsRepository.sizeEmails)
    println("Emails en repositorio:${emailsRepository.sizeEmails}" )
    println("lista emails:${emailsRepository.findAll()}" )

    emailsRepository.deleteEmailById(emailsRepository.findAll().first().id)

    println("Emails en repositorio:${emailsRepository.sizeEmails}" )

    println("\n=== EJERCICIO ===")
    println("Crea abstract class 'BaseEmailNotifier' con:")
    println("1. notify(email: Email)")
    println("2. Extiende de BaseEmailNotifier una clase 'ConsoleNotifier'")
    println("3. Instancia una clase ConsoleNotifier y ejecuta el metodo notify  ")

    val notifier = ConsoleNotifier()
    notifier.notify(
        Email(
            UUID.randomUUID(),
            "Eventos importantes 202x",
            mensaje = "Lista de eventos"
        ))

}

abstract class EmailNotifier {
    abstract fun notify(email: Email)
}

class ConsoleNotifier : EmailNotifier() {
    override fun notify(email: Email) {
        println("Nuevo email: ${email.asunto} ")
    }
}