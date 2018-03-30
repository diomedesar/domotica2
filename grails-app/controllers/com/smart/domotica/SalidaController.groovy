package com.smart.domotica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SalidaController {

    SalidaService salidaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond salidaService.list(params), model:[salidaCount: salidaService.count()]
    }

    def show(Long id) {
        respond salidaService.get(id)
    }

    def create() {
        respond new Salida(params)
    }

    def save(Salida salida) {
        if (salida == null) {
            notFound()
            return
        }

        try {
            salidaService.save(salida)
        } catch (ValidationException e) {
            respond salida.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'salida.label', default: 'Salida'), salida.id])
                redirect salida
            }
            '*' { respond salida, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond salidaService.get(id)
    }

    def update(Salida salida) {
        if (salida == null) {
            notFound()
            return
        }

        try {
            salidaService.save(salida)
        } catch (ValidationException e) {
            respond salida.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'salida.label', default: 'Salida'), salida.id])
                redirect salida
            }
            '*'{ respond salida, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        salidaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'salida.label', default: 'Salida'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'salida.label', default: 'Salida'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
