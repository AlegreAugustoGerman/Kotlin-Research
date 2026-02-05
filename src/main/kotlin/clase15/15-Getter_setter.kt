package clase15

class Email( val remitente: String, val mensaje:String){
    var asunto: String=""
        set(value) {
            field = if (value.trim().isNotEmpty()) value.trim() else "Sin asunto"
        }

    val esImportante: Boolean
        get() = asunto.contains("urgente", ignoreCase = true)

}

fun main(){
    val email1 = Email("juan@gmail.com","Este es un mensaje de correo")

    email1.asunto= "    "

    println( "El asunto es: ${email1.asunto}")

    email1.asunto= "URGENTE-Reunion jueves"

    println( "El correo es importante?: ${email1.esImportante}")

    println("\n=== EJERCICIO ===")
    println("Crea clase 'Contacto' con:")
    println("- Setter para email: validar que contenga '@' para agregarlo. En caso contrario dejarlo vacio")
    println("- Propiedad calculada 'esValido'")

    val contacto = Contacto("Juan")
    contacto.email = "juanemail.com"
    println("Email: ${contacto.email}, Válido: ${contacto.esValido}")
}

class Contacto(val nombre: String) {
    var email: String = ""
        set(value) {
            field = if (value.contains("@")) value else ""
        }

    val esValido: Boolean
        get() = email.contains("@") && email.contains(".com")
}