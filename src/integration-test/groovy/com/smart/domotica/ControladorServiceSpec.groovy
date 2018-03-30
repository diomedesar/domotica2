package com.smart.domotica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ControladorServiceSpec extends Specification {

    ControladorService controladorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Controlador(...).save(flush: true, failOnError: true)
        //new Controlador(...).save(flush: true, failOnError: true)
        //Controlador controlador = new Controlador(...).save(flush: true, failOnError: true)
        //new Controlador(...).save(flush: true, failOnError: true)
        //new Controlador(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //controlador.id
    }

    void "test get"() {
        setupData()

        expect:
        controladorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Controlador> controladorList = controladorService.list(max: 2, offset: 2)

        then:
        controladorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        controladorService.count() == 5
    }

    void "test delete"() {
        Long controladorId = setupData()

        expect:
        controladorService.count() == 5

        when:
        controladorService.delete(controladorId)
        sessionFactory.currentSession.flush()

        then:
        controladorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Controlador controlador = new Controlador()
        controladorService.save(controlador)

        then:
        controlador.id != null
    }
}
