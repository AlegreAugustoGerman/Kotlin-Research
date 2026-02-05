package clase18

class EmailInvalidException(message: String): Exception(message)


fun main(){

    val emails = listOf<String>("juan@empresa.com", "carlosempresa.com","maria@empresa.com")
    var esExitoso = false
    try {
        //emails[10]
        throw ClassNotFoundException("Email Processor not found")
        esExitoso = true
        println(".....")
    }
    catch (e:ArrayIndexOutOfBoundsException){
        println("Indice de emails no valido")
    }
    catch (e: ClassNotFoundException){
        println("ClassNotFoundException Email processor")
    }
    finally {
        println("Finalizo el procesamiento de correos fue exitoso?:$esExitoso")
    }

    try {
        for (email in emails){
            if (!email.contains("@"))
                throw EmailInvalidException("Email invalido no tiene @: ${email}")
        }
    }
    catch (e: EmailInvalidException){
        println("Mensaje de error ${e.message}")
    }

    println("\n=== EJERCICIO ===")
    println("Crea función 'dividir(a, b)' que maneje división por cero")
    println(dividir(10, 2))
    println(dividir(10, 0))

}

fun dividir(a: Int, b: Int): Int? {
    return try {
        val resultado =  a / b
        resultado
    } catch (e: ArithmeticException) {
        println("Error: División por cero")
        null
    }
}