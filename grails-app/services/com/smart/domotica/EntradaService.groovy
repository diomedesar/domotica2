package com.smart.domotica

import grails.gorm.services.Service

@Service(Entrada)
interface EntradaService {

    Entrada get(Serializable id)

    List<Entrada> list(Map args)

    Long count()

    void delete(Serializable id)

    Entrada save(Entrada entrada)

}