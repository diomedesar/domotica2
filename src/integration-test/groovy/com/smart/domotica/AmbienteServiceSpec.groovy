package com.smart.domotica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AmbienteServiceSpec extends Specification {

    AmbienteService ambienteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ambiente(...).save(flush: true, failOnError: true)
        //new Ambiente(...).save(flush: true, failOnError: true)
        //Ambiente ambiente = new Ambiente(...).save(flush: true, failOnError: true)
        //new Ambiente(...).save(flush: true, failOnError: true)
        //new Ambiente(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ambiente.id
    }

    void "test get"() {
        setupData()

        expect:
        ambienteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ambiente> ambienteList = ambienteService.list(max: 2, offset: 2)

        then:
        ambienteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ambienteService.count() == 5
    }

    void "test delete"() {
        Long ambienteId = setupData()

        expect:
        ambienteService.count() == 5

        when:
        ambienteService.delete(ambienteId)
        sessionFactory.currentSession.flush()

        then:
        ambienteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ambiente ambiente = new Ambiente()
        ambienteService.save(ambiente)

        then:
        ambiente.id != null
    }
}
