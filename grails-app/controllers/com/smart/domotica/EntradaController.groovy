package com.smart.domotica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EntradaController {

    EntradaService entradaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond entradaService.list(params), model:[entradaCount: entradaService.count()]
    }

    def show(Long id) {
        respond entradaService.get(id)
    }

    def create() {
        respond new Entrada(params)
    }

    def save(Entrada entrada) {
        if (entrada == null) {
            notFound()
            return
        }

        try {
            entradaService.save(entrada)
        } catch (ValidationException e) {
            respond entrada.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'entrada.label', default: 'Entrada'), entrada.id])
                redirect entrada
            }
            '*' { respond entrada, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond entradaService.get(id)
    }

    def update(Entrada entrada) {
        if (entrada == null) {
            notFound()
            return
        }

        try {
            entradaService.save(entrada)
        } catch (ValidationException e) {
            respond entrada.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'entrada.label', default: 'Entrada'), entrada.id])
                redirect entrada
            }
            '*'{ respond entrada, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        entradaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'entrada.label', default: 'Entrada'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrada.label', default: 'Entrada'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
