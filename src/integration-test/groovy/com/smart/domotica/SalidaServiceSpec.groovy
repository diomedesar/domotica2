package com.smart.domotica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SalidaServiceSpec extends Specification {

    SalidaService salidaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Salida(...).save(flush: true, failOnError: true)
        //new Salida(...).save(flush: true, failOnError: true)
        //Salida salida = new Salida(...).save(flush: true, failOnError: true)
        //new Salida(...).save(flush: true, failOnError: true)
        //new Salida(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //salida.id
    }

    void "test get"() {
        setupData()

        expect:
        salidaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Salida> salidaList = salidaService.list(max: 2, offset: 2)

        then:
        salidaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        salidaService.count() == 5
    }

    void "test delete"() {
        Long salidaId = setupData()

        expect:
        salidaService.count() == 5

        when:
        salidaService.delete(salidaId)
        sessionFactory.currentSession.flush()

        then:
        salidaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Salida salida = new Salida()
        salidaService.save(salida)

        then:
        salida.id != null
    }
}
