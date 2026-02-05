package clase20

data class Email(
    val subject:String,
    val sender: String,
    val isRead: Boolean = false
)
fun main(){

    val emails = listOf(
        Email("Reunion", "jefeempresa.com", false),
        Email("Reporte", "admin@empresa.com", false),
        Email("rgente", "cliente@test.com", false)
    )

    val formatearEmail:(Email) -> String = { email ->
        "${email.subject} de ${email.sender}"
    }

    val emailFormateos = emails.map(formatearEmail)

    emails.map { email ->
        "${email.subject} de ${email.sender}"
    }

    val emailsFiltrados = emails.filter { email->
        email.sender.first() == 'a'
    }
    val emailWithSubjectR = emails.last {
        it.subject.first().lowercase() == "r"
    }
    println("${emailWithSubjectR}")

    emailsFiltrados.forEachIndexed { index,email->
        println("Correo numero[$index]:$email")
    }


    val email1 = emails.get(0)
    val email2 = emails.get(1)
    enviarEmail(
        email1,
        onSuccess = { e, mensaje ->
            println("${e.subject}  $mensaje")
        },
        onError = { mensaje, error->
            println("Error:${mensaje}  Codigo Error: $error")
        }
    )

    println("\n=== EJERCICIO ===")
    println("Crea función 'buscarEmail' que:")
    println("1. Reciba una lista de emails")
    println("2. Reciba una condición: (Email) -> Boolean")
    println("3. Reciba callbacks onFound: (Email) -> Unit y onNotFound: () -> Unit")

    buscarEmail(
        emails,
        condicion = { it.subject.contains("Urgente") },
        onFound = { email -> println("Encontrado: ${email.subject}") },
        onNotFound = { println("No se encontró email urgente") }
    )



}
fun buscarEmail(
    emails: List<Email>,
    condicion: (Email) -> Boolean,
    onFound: (Email) -> Unit,
    onNotFound: () -> Unit
) {
    val emailEncontrado = emails.find(condicion)
    if (emailEncontrado != null) {
        onFound(emailEncontrado)
    } else {
        onNotFound()
    }
}


fun enviarEmail(
    email: Email,
    onSuccess:(Email, String) -> Unit,
    onError:(String, Int) -> Unit
){
    if(email.sender.contains("@")){
        val mensaje = "Enviado a ${email.sender}"
        onSuccess(email, mensaje)
    }
    else{
        onError("Email invalido: ${email.sender}", 400)
    }
}