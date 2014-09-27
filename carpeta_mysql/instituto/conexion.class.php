<?php
// creando la clase ManejoBD para manejar la base de datos
class ManejoBD{
	var $conect;  #atributo que contendra la conexion con al base de datos 
	var $BaseDatos; #atributo para el nombre de la base de datos
	var $Servidor;  #atributo para el nombre del servidor de  base de datos
	var $Usuario;  #atributo para el nombre del usuario 
	var $Clave;  #atributo para la clave del usuario 
	//creando el metodo constructor de la clase para asignar valores a las propiedades
	function ManejoBD(){
		$this->BaseDatos = "instituto"; # aignar valor a la propiedad $BaseDatos
		$this->Servidor = "localhost"; # aignar valor a la propiedad $Servidor
		$this->Usuario = "root";  # aignar valor a la propiedad $Usuario
		$this->Clave = "123456"; # aignar valor a la propiedad $Clave
	}
	/* creando el metodo conectar para conectarme con el Servidor de Base de Datos
	   y seleccionar la base de datos */
	 function conectar() 
	 {
		//conectarme con el servidor de base de datos
		$con=mysql_connect($this->Servidor,$this->Usuario,$this->Clave);
		// si hubo problemas al conectarme con el servidor de base de datos
		if (!$con)
		{
			die("Error al conectarme con el Servidor de Base de Datos");
		}
		//Seleccionar la base de datos
		$bd=mysql_select_db($this->BaseDatos,$con);
		//error al seleccionar la base de datos
		if (!$bd)
		{
			die("Error al seleccionar la Base de Datos");
		}
		//almaceno la conexion en la propiedad conect
		$this->conect=$con;
		//devuelvo la conexion desde donde fue invocada
		return true;	
	}

	 function cerrar() {
        // cerrando la conexion
        mysql_close();
    }	
}

?>

