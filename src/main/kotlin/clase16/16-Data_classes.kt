package clase16

class EmailNormal(val asunto:String, val remitente:String, var leido: Boolean)
data class EmailData(val asunto: String, val remitente: String, var leido: Boolean)

fun main(){

    val emailNormal1 = EmailNormal("Reunión", "jefe@empresa.com", false)
    val emailCopia = emailNormal1
    val emailNormal2 = EmailNormal("Reunion", "jefe@empresa.com", false)

    val emailData1 = EmailData("Reunión", "jefe@empresa.com", false)
    val emailData2 = EmailData("Reunión", "jefe@empresa.com", false)

    println("Clase normal 1: ${emailNormal1}")
    println("Clase normal 2: ${emailNormal2}")
    println("Data clase: ${emailData1}")

    println("COmparacion Clase normal: ${emailNormal1 == emailCopia}")
    println("Comparacion Data clase: ${emailData1 == emailData2}")


    val email1Copia= emailData1.copy( asunto = "Reunion[Copia]")
    println("Esta es una copia ${email1Copia}")

    //destructuring
    val (asunto1 , remitente, leido) = email1Copia

    println("Valores asunto:${asunto1} remitente:$remitente  es leido:$leido")

    println("hachcode data 1: ${emailData1.hashCode()}")
    println("hachcode data 2: ${emailData2.hashCode()}")

    println("\n=== EJERCICIO ===")
    println("Crea data class 'Contacto' con nombre y email")
    println("Crea dos instancias y verifica si son iguales ")
    println("Copia una de las instancias en otra variable y cambia uno de sus valores")

    val contacto1 = Contacto("María", "maria@email.com")
    val contacto2 = Contacto("María", "maria@email.com")

    println("Iguales: ${contacto1 == contacto2}")  // true

    val contactoCopia = contacto1.copy(email = "maria.nueva@email.com")
    println("Copia: $contactoCopia")
}

data class Contacto(val nombre: String, val email: String)