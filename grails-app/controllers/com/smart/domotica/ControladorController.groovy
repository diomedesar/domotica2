package com.smart.domotica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ControladorController {

    ControladorService controladorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond controladorService.list(params), model:[controladorCount: controladorService.count()]
    }

    def show(Long id) {
        respond controladorService.get(id)
    }

    def create() {
        respond new Controlador(params)
    }

    def save(Controlador controlador) {
        if (controlador == null) {
            notFound()
            return
        }

        try {
            controladorService.save(controlador)
        } catch (ValidationException e) {
            respond controlador.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'controlador.label', default: 'Controlador'), controlador.id])
                redirect controlador
            }
            '*' { respond controlador, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond controladorService.get(id)
    }

    def update(Controlador controlador) {
        if (controlador == null) {
            notFound()
            return
        }

        try {
            controladorService.save(controlador)
        } catch (ValidationException e) {
            respond controlador.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'controlador.label', default: 'Controlador'), controlador.id])
                redirect controlador
            }
            '*'{ respond controlador, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        controladorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'controlador.label', default: 'Controlador'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'controlador.label', default: 'Controlador'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def verga(){
        println "Verga"
        return null
    }
}
