package clase8

fun main() {
    // usaremos readLine() leer input, trim limpiar espacios extras  ? acceso seguro

    println("Sistema de EMAIL")
    print("Ingresa tu email:")
    val email= readLine()?:"Sin Email"

    print("Ingresa el Destinatario:")
    val destinatario= readLine()?:"Sin Email"

    print("Ingresa el Asunto:")
    val asunto= readLine()?:"Sin Asunto"

    println("Para: $destinatario")
    println("Asunto:$asunto")

    print ("Ingrese el mensaje:")
    val mensajeSinLimpiar= readLine()
    val mensajeLimpio= mensajeSinLimpiar?.trim()
}