<?php
/*
 * Autor : jorge nolasco valenzuela
 * Programa : listado_alumno.php
 * Funcionalidad : lista los alumnos y sus respectivas calificaciones  
 */

// array para JSON 
$response = array();


// incluir la clase conexion.class.php
require_once("conexion.class.php");

// conectandose con el servidor de BD 
$db = new ManejoBD();
// Seleccionar la BD instituto
$db->conectar();

// recuperar los alumnos y sus calificaciones mediante sentencia ANSI
$result = mysql_query("SELECT alumno.idalumno,alumno.nombre,notas.nota FROM alumno,notas WHERE alumno.idalumno=notas.idalumno") or die(mysql_error());


// existe por lo menos 1 registro
if (mysql_num_rows($result) > 0) {
 
    $response["alumnos"] = array();
    
    while ($row = mysql_fetch_array($result)) {
        // llenar el arreglo con los registros

        $alumnos = array();      
        $alumnos["idalumno"] = $row["idalumno"];
        $alumnos["nombre"] = $row["nombre"];
        $alumnos["nota"] = $row["nota"];
		
		/*
		echo $alumnos["idalumno"];
		echo $alumnos["nombre"];
		echo $alumnos["nota"];
         */
		     
        array_push($response["alumnos"], $alumnos);
    }
    // exito
    $response["success"] = 1;
    // echo exito JSON
    echo json_encode($response);
} else {
    // fracaso
    $response["success"] = 0;
    $response["message"] = "Fracaso";

    // echo no usuarios JSON
    echo json_encode($response);
}
?>
