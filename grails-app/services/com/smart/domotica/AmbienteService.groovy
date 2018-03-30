package com.smart.domotica

import grails.gorm.services.Service

@Service(Ambiente)
interface AmbienteService {

    Ambiente get(Serializable id)

    List<Ambiente> list(Map args)

    Long count()

    void delete(Serializable id)

    Ambiente save(Ambiente ambiente)

}