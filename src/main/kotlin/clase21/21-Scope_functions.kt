package clase21

import java.util.UUID
import javax.security.auth.Subject

data class Email(
    val id:String,
    var subject: String,
    var body: String,
    var isRead: Boolean = false
)

/*CADA SCOP FUNCTION TIENEN SUS VENATAJAS Y FORMAS DE SER USADO ANTE LA DUDA REVISAR DOCUMENTACION
POR LAS DIFERENCIAS ENTRE IT , THIS COMO COMBINAR CORRECTAMENTE LAS LAMBDA PARA SIMPLIFICAR CODIGO

IT ES CUANDO LA INSTANCIA DEL OBJETO SIRVE SOLO COMO PARAMETRO
THIS CUANDO NECESITAMOS ACCEDER COMO CON RUN O APLLY PARA MODIFICAR 

CUANDO USAR ENTONCES LAS SCOPE FUNCTIONS, CON QUE OBJETIVO SI QUIERO MODIFICAR O ACTUALIZAR UN OBJETO
SI QUIERO INSTANCIAR CREAR OBJETO O MODIFICAR EL INSTANCIADO , SI QUIERO SOLO MODIFICAR UN HIJO O APLICAR POLIMORFISMO
COMO SE LOGRA EL DINAMISMO CON LAMBDA COMO POR EJEMPLO SI CREO UN VAL QUE OBTENGA EL ESTADO ANTERIOR A LA MODIFICACION 
ENTONCES EL CUANDO PORQUE Y DONDE DEPENDE DE COMO VIENE ESTRUCTURADO EL CONTEXTO EN CODIGO DE LO QUE SE TRATE CON LA SCOP FUNCTION
QUE PASA SI OBTIENE POR API O DE FUNCIONES TRADICIONALES SI ES UNA OPERACION SIMPLE PERO SI CRECE DESPUES COMO ADAPTO O DECIDO NO SEGUIR 
CON LAMBDA Y VOLVERLO FUNCION SI NECESITO QUE SEA REUTILIZABLE PODRÍA NOMBRARLO COMO FUNCION DALRE UN VALOR Y DENTRO HACER LA LAMBDA ¿?
*/

fun main(){

    println("1. LET") //permite verificar nullabilidad en un objeto para extraer un valor o transformaciones entre tipos de objeto

    val emailId:String = UUID.randomUUID().toString()

    /*
    UUID: Es la clase de Java/Kotlin que maneja identificadores de 128 bits.
    .randomUUID(): Genera un identificador aleatorio basado en criptografía robusta (Versión 4).
    .toString(): Convierte ese valor numérico complejo en una cadena de texto legible (ejemplo: 550e8400-e29b-41d4-a716-446655440000). 

    ¿Para qué se usa en la práctica?
    Identificar filas en Bases de Datos: En lugar de usar números simples (1, 2, 3), usas un UUID para que, si unes dos bases de datos, no haya conflictos de IDs.
    Nombres de Archivos: Si permites que los usuarios suban fotos, puedes renombrarlas con un UUID para evitar que dos archivos se llamen igual y se sobrescriban.
        */

    val email = emailId.let{

        Email(
            id = it,
            subject = "Reunion",
            body = "Mensaje",
        )
    }

    println("Transformafos $emailId a un $email")

    println("2. APPLY") // tomará la instancia del objeto y podrá aplicar modificaciones sobre parametros

    val email2= Email(
        id = UUID.randomUUID().toString(),
        subject = "Reunion",
        body = "Mensaje",
    ).apply { // patrron en diseño de software "builder" que es ir modificando parametros del objeto con
        subject = "Fiesta fin de año"  // funciones pero en kotlin se utiliza la scope function apply para esto   
    }

    println("email2 $email2")

// este scope function  run
    println("3. RUN") // acceder a propiedades del objeto podemos marcarlo como true , devolver un valor en la ultima sentencia del bloque

    val email3= Email(  // una clase email  definida pero...
        id = UUID.randomUUID().toString(),
        subject = "Oferta",
        body = "Oferta de trabajo",
    )
    val asunto = email3.run { // al aplicar run 
        isRead = true //cambio de valor
        subject = subject.uppercase() // operacioón
        "Email procesado:$subject" // valor de retorno 
    }


    //with es una función muy particular porque es la única de las 5 que no se llama con un punto (objeto.with),
    //sino que el objeto se pasa como argumento.
    println("4. WITH") 

    val email4= Email(
        id = UUID.randomUUID().toString(),
        subject = "Importante",
        body = "Mensaje urgente",
    )
    val summary = with(email4){ //with utilizar cuando se deben hacer multiples operaciones sobre un mismo objeto
        isRead = true
        //  ... aqui irían las operaciones configuraciones bloques funcionales extensas con base en un objeto 
        "ID:${id}, Asunto $subject , Leído:$isRead"
    }
    println("El resumen de $email4 es: $summary")

    println("5. ALSO")

    val email5= Email(
        id = UUID.randomUUID().toString(),
        subject = "Importante",
        body = "Mensaje urgente",
    ).also {  // es para escenarios donde necesito acciones complementarias no necesariamente relacionado al objeto
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