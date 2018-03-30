package com.smart.domotica

import grails.gorm.services.Service

@Service(Controlador)
interface ControladorService {

    Controlador get(Serializable id)

    List<Controlador> list(Map args)

    Long count()

    void delete(Serializable id)

    Controlador save(Controlador controlador)

}