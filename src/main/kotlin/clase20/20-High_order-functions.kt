/*

1. Las Funciones de Orden Superior (map, filter, forEach)
Son herramientas de fábrica que ya vienen con las listas de Kotlin. Su único trabajo es aplicar una lógica sobre los datos.
 No necesitas crear una función filtrarEmails() manualmente porque filter ya sabe cómo recorrer la lista; solo necesita que tú le digas la condición.

2. La Lambda (El bloque { })
Es el "manual de instrucciones" temporal.
No necesita nombre.
Se define en el momento.
Se enfoca en una sola tarea (ej. "¿Este email empieza con 'a'?").
3. La Variable como Resultado
no necesitas crear funciones complejas para todo. En Kotlin es muy común y elegante resolver procesos en una sola línea y guardar 
el resultado en una variable:
kotlin
// Todo el proceso ocurre aquí y se guarda en 'resultado'
val resultado = emails.filter { it.sender.contains("@") }.map { it.subject.uppercase() }
Usa el código con precaución.

¿Cuándo elegir cada una?
Si la lógica es...	Usa...

Simple (1 o 2 líneas)	Una lambda directamente dentro de filter o map.

Repetitiva (la usas en 5 archivos)	Una función normal (fun) y la pasas como referencia.

Compleja (muchos cálculos)	Una función normal para que el código sea legible.

Un último detalle sobre it
Como mencionaste antes que para objetos usas this y en lambdas it, recuerda que it es simplemente un nombre automático que Kotlin 
le da al objeto que está pasando por la lambda en ese momento para que no tengas que escribir (email -> email.sender).

*/



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
//          nombreFunc:(Email) ->  es para especificar valor de parametro de la lambda
    val formatearEmail:(Email) -> String = { email -> //  -> String =  significa retornará un string
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
        it.subject.first().lowercase() == "r"  //es objetos solemos usar this.propiedad pero para lambdas se usa it.propiedad
    }
    println("${emailWithSubjectR}")

    /*
    lambda es solo una pequeña pieza de lógica (el "cómo" hacer algo). No está diseñada para contener todo el estado del objeto ni para ser una estructura compleja. Su fuerza reside en ser:
    Anónima: No necesita un nombre porque se usa y se desecha ahí mismo.

    1. Efímera: Vive solo mientras la función de orden superior (map, filter, forEach) la está ejecutando.
    2. Por qué no hacer "Lambdas Gigantes"
    Técnicamente podrías escribir 100 líneas de código dentro de una lambda, pero es una mala práctica por dos razones:
    Complejidad: Se vuelve imposible de leer. Pierdes el rastro de qué es it o qué estás devolviendo.
    Reutilización: Si metes toda la lógica de filtrado, formateo y envío en una sola lambda dentro de un map, no podrás usar esa lógica en ninguna otra parte del programa.

    Solo es lambda el código que va dentro de las llaves { }. Lo que está antes del punto (como emailsFiltrados) es el objeto que contiene los datos.

    */
    emailsFiltrados.forEachIndexed { index,email->   //  esto es una lambda
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

//enviarEmail no es una lambda; es una función regular. Sin embargo, es una función de orden superior porque recibe lambdas como parámetros.

fun enviarEmail( 
    email: Email,
    onSuccess:(Email, String) -> Unit, //En Kotlin, Unit es un objeto real. Unit es un valor único. Si una función devuelve Unit, significa que sí terminó su trabajo correctamente.
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