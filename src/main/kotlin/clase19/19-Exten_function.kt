package clase19
//extender funciones nombrandolas por ejemplo String.isValidEmail , String.emailDomain etc
fun String.isValidEmail(): Boolean{
    return this.contains("@") && this.contains(".")
}
fun String.addSignatureToName(companyName:String): String{
    return "${this}\n\n--\n${companyName.uppercase()}"
}

val String.emailDomain: String
    get() = this.substringAfter("@") // el string siguiente al caracter si lo encuentra , si no tiene devuelve todo el email

data class Email(
    val subject: String,
    val sender: String,
    val body: String,
    var isRead: Boolean //para poder modificar aplicando isread
)

fun Email.markAsRead(){
    this.isRead= true
    println("Email ${this.subject} marcado como leido") //accediendo a la propiedad de Email .subject
}

fun main(){

    val email = "juan@empresa.com"
    email.isValidEmail()

    println("El email es: ${email}")
    println("Es un email valido ?: ${email.isValidEmail()}")

    val nombreRemitente = "Juan Gaines"
    println(nombreRemitente.addSignatureToName("Empresa 1"))
    println("El dominio del correo es: ${email.emailDomain}")

    val correoDataClass = Email("Reunion", "jefe@empresa.com", "Reunion de proveedores aplazada.", isRead = false)
    println(correoDataClass)
    correoDataClass.markAsRead()
    println(correoDataClass)

    println("\n=== EJERCICIO ===")
    println("Crea extension functions para String:")
    println("1. capitalize() - primera letra mayúscula")
    println("2. wordCount() - contar palabras")

    val texto = "hola mundo kotlin"
    println("Capitalizado: ${texto.capitalize()}")
    println("Palabras: ${texto.wordCount()}")
}

fun String.capitalize(): String {
    return if (this.isNotEmpty()) {
        this.first().uppercase() + this.substring(1)
    } else this
}

fun String.wordCount(): Int {
    return this.split(" ").filter { it.isNotBlank() }.size
}