package com.smart.domotica

import grails.gorm.services.Service

@Service(Salida)
interface SalidaService {

    Salida get(Serializable id)

    List<Salida> list(Map args)

    Long count()

    void delete(Serializable id)

    Salida save(Salida salida)

}