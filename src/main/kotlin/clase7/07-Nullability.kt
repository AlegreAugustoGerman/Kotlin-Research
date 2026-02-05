package clase7

fun main () {
val miEmail: String="maria@email.com"
// Variable para email  nombre opcional
val miNombre: String?= null
// usar operador elvis ?: mostrar anonimo si es null
val nombreMostrar= miNombre ?: "Anonimo"
// usar ? para obtener la longitud del nombre de forma segura
val longitudNombre=miNombre?.length ?: 0  //campo opcional si devuelve nulo operador elvis hace que devuelva 0

println("Email: $miEmail - Usuario: $nombreMostrar - Longitud: $longitudNombre")

/* LLAMADO SEGURO con ? campo que pueda llegar null como seguro para que no rompa ejecución

var opcional:string?=null  si está como null para acceder sin error  agregue ?
var longitudOpcional=opcional?.length

para acceder a lenght en un opcional que puede ser null
necesito acceder seguramente por eso agrego ?

println ("longitud :$longitudOpcional ") //resultado longitud null


OTRA FORMA DE MANEJAR NULL PARA GENERAR LOS CODIGOS POR EJEMPLO DE ERROR con Elvis
en lugar de null el numero de error
*/
}