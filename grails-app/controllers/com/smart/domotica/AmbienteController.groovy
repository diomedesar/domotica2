package com.smart.domotica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AmbienteController {

    AmbienteService ambienteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ambienteService.list(params), model:[ambienteCount: ambienteService.count()]
    }

    def show(Long id) {
        respond ambienteService.get(id)
    }

    def create() {
        respond new Ambiente(params)
    }

    def save(Ambiente ambiente) {
        if (ambiente == null) {
            notFound()
            return
        }

        try {
            ambienteService.save(ambiente)
        } catch (ValidationException e) {
            respond ambiente.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ambiente.label', default: 'Ambiente'), ambiente.id])
                redirect ambiente
            }
            '*' { respond ambiente, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ambienteService.get(id)
    }

    def update(Ambiente ambiente) {
        if (ambiente == null) {
            notFound()
            return
        }

        try {
            ambienteService.save(ambiente)
        } catch (ValidationException e) {
            respond ambiente.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ambiente.label', default: 'Ambiente'), ambiente.id])
                redirect ambiente
            }
            '*'{ respond ambiente, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ambienteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ambiente.label', default: 'Ambiente'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ambiente.label', default: 'Ambiente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
