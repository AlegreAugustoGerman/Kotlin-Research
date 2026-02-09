package clase21

import java.util.UUID
import javax.security.auth.Subject

data class Email(
    val id:String,
    var subject: String,
    var body: String,
    var isRead: Boolean = false
)

fun main(){

    println("1. LET")

    val emailId:String = UUID.randomUUID().toString()

    val email = emailId.let{

        Email(
            id = it,
            subject = "Reunion",
            body = "Mensaje",
        )
    }

    println("Transformafos $emailId a un $email")

    println("2. APPLY")

    val email2= Email(
        id = UUID.randomUUID().toString(),
        subject = "Reunion",
        body = "Mensaje",
    ).apply {
        subject = "Fiesta fin de año"
    }

    println("email2 $email2")

    println("3. RUN")

    val email3= Email(
        id = UUID.randomUUID().toString(),
        subject = "Oferta",
        body = "Oferta de trabajo",
    )
    val asunto = email3.run {
        isRead = true
        subject = subject.uppercase()
        "Email procesado:$subject"
    }


    println("4. WITH")

    val email4= Email(
        id = UUID.randomUUID().toString(),
        subject = "Importante",
        body = "Mensaje urgente",
    )
    val summary = with(email4){
        isRead = true
        //  ...
        "ID:${id}, Asunto $subject , Leído:$isRead"
    }
    println("El resumen de $email4 es: $summary")

    println("5. ALSO")

    val email5= Email(
        id = UUID.randomUUID().toString(),
        subject = "Importante",
        body = "Mensaje urgente",
    ).also {
        println("Enviar correo $it ....")
    }

    println("\n=== EJERCICIO ===")
    println("Crea función 'validateEmail' que:")
    println("1. Use let para verificar que email no sea null")
    println("2. Use apply para limpiar espacios con la función trim")
    println("3. Use also para hacer print del correo limpiado.")
    println("4. Use run para validar y retornar resultado")

    println("\nValidaciones:")
    println("juan@test.com: ${validateEmail("juan@test.com")}")
    println("invalido: ${validateEmail("invalido")}")
    println("null: ${validateEmail(null)}")
}

fun validateEmail(email: String?): Boolean {
    return email?.let { emailStr ->
        emailStr.apply {
            trim()
        }.also {
            println("Validando: $it")
        }.run {
            contains("@") && contains(".")
        }
    } ?: false
}