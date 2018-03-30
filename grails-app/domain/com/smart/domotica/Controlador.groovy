package com.smart.domotica

class Controlador {
	String nombre
	String estado
	static hasMany = [entradas:Entrada, salidas: Salida]
	static belongsTo = Ambiente

    static constraints = {
    	nombre nullable:false, blank:false, unique:true, size:4..255
    	estado nullable:false, blank:false, inList: ["Disponible", "No Disponible"]
    }

    def controladores = {
    	return entradas + salidas
    }
}