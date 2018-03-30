package com.smart.domotica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EntradaServiceSpec extends Specification {

    EntradaService entradaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Entrada(...).save(flush: true, failOnError: true)
        //new Entrada(...).save(flush: true, failOnError: true)
        //Entrada entrada = new Entrada(...).save(flush: true, failOnError: true)
        //new Entrada(...).save(flush: true, failOnError: true)
        //new Entrada(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //entrada.id
    }

    void "test get"() {
        setupData()

        expect:
        entradaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Entrada> entradaList = entradaService.list(max: 2, offset: 2)

        then:
        entradaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        entradaService.count() == 5
    }

    void "test delete"() {
        Long entradaId = setupData()

        expect:
        entradaService.count() == 5

        when:
        entradaService.delete(entradaId)
        sessionFactory.currentSession.flush()

        then:
        entradaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Entrada entrada = new Entrada()
        entradaService.save(entrada)

        then:
        entrada.id != null
    }
}
