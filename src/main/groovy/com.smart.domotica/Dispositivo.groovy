package com.smart.domotica

abstract class Dispositivo {
	String nombre
   	Integer identificador
   	static belongsTo = Controlador

   	static constraints = {
   		nombre blank:false, nullable: false, size: 4..50
    	identificador blank:false, nullable:false, maxSize: 255, minSize: 0
    }
}
