package class25

import java.util.Date

sealed class EmailStatus(val statusId:Int){
    data class Sent(val enviadoA:String): EmailStatus(0)
    data class Failed(val error:String): EmailStatus(1)
    data object Draft: EmailStatus(2)
    data class Scheduled(val enviadoA:String, val time: String): EmailStatus(3)
}

data class Email(val id: String, val asunto: String, val remitente: String)

fun procesarEmail(estado: Int, email: Email): EmailStatus{
    return when (estado){
        0-> EmailStatus.Sent(email.remitente)
        1 -> EmailStatus.Failed("error")
        2 -> EmailStatus.Draft
        3-> EmailStatus.Scheduled(email.remitente, Date().time.toString())
        else -> EmailStatus.Failed("error")
    }

}

fun main(){

    val email = Email(0.toString(), asunto = "Email", "correo@correo.com")
    val emailStatus = procesarEmail(3,email)


    when(emailStatus){
        EmailStatus.Draft -> {
            println("Estado Draft")
        }
        is EmailStatus.Failed -> println("Estado Failed ${emailStatus.error}")
        is EmailStatus.Scheduled -> println("Estado Scheduled")
        is EmailStatus.Sent -> println("Estado Enviado. Em email fue enviado a ${emailStatus.enviadoA}")
    }

    println("\n=== EJERCICIO ===")
    println("Crea sealed class 'EmailFolder' con:")
    println("1. Propiedad compartida 'count: Int'")
    println("2. Data object Inbox con count = 10")
    println("3. Data class Spam(senderDomain: String) con count = 5")
    println("4. Data object Sent con count = 3")

}

sealed class EmailFolder(val count: Int) {
    data object Inbox : EmailFolder(10)
    data class Spam(val senderDomain: String) : EmailFolder(5)
    data object Sent : EmailFolder(3)
}



sealed interface EmailAction {
    // Propiedad que pueden implementar las subclases
    val actionType: String

    // Data class para enviar emails
    data class Send(
        val recipient: String,
        val subject: String
    ) : EmailAction {
        override val actionType: String = "SEND"
    }

    // Data class para eliminar emails
    data class Delete(val emailId: String) : EmailAction {
        override val actionType: String = "DELETE"
    }

    // Data object para guardar borrador
    data object SaveDraft : EmailAction {
        override val actionType: String = "DRAFT"
    }

    // Data object para actualizar
    data object Refresh : EmailAction {
        override val actionType: String = "REFRESH"
    }
}