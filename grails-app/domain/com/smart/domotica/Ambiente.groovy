package com.smart.domotica

class Ambiente {
	String nombre
	static hasMany = [controladores:Controlador]
    static constraints = {
    	nombre nullable:false, blank:false, unique:true, size:4..255
    }
}
