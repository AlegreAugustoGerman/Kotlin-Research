package class23

import java.util.UUID

data class Email(
    val id: UUID,
    val asunto: String,
    val mensaje:String
)
// definimos el contrato de la función no el como hacerlo pero si que debe hacer
interface EmailRepository{
    val sizeEmails:Int
    fun save(email: Email)
    fun findById(id: UUID):Email?
    fun findAll():List<Email>
    fun deleteEmailById(id: UUID)
}
//¿ahora como aplicamos el contrato declarado anteriormente?

// primero aplicamos herencia : EmailRepository
class InMemoryEmailRepository : EmailRepository {

    val repositoryName: String = "InMemoryEmailRepository"

    private val emails = mutableListOf<Email>()
    
    //siempre da error hastá que se escriban todos los override val , func del contrato establecido 
    
    override val sizeEmails: Int
    get() = emails.size
    
    override fun save(email: Email) {
        emails.add(email)
    }

    override fun findById(id: UUID): Email? {
        return emails.find{ email-> email.id == id}
    }

    override fun findAll(): List<Email> {
        return emails
    }

    override fun deleteEmailById(id: UUID) {
        emails.removeIf { email-> email.id == id }
    }
}

fun main(){

    val emailsRepository: EmailRepository = InMemoryEmailRepository()
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
    println("Crea interface 'EmailNotifier' con:")
    println("1. notify(email: Email)")
    println("2. Implementa 'ConsoleNotifier'")
    println("3. Instancia una clase con el contrato EmailNotifier y ejecuta el metodo notify  ")


    val notifier: EmailNotifier = ConsoleNotifier()
    notifier.notify(
        Email(
            UUID.randomUUID(),
            "Eventos importantes 202x",
            mensaje = "Lista de eventos"
        ))


}

interface EmailNotifier {
    fun notify(email: Email)
}

class ConsoleNotifier : EmailNotifier {
    override fun notify(email: Email) {
        println("Nuevo email: ${email.asunto} ")
    }
}