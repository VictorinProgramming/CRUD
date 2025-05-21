package com.projeto.crud.exception;

/**
 * Exceção personalizada para indicar que um recurso (entidade) não foi encontrado.
 * Pode ser usada em qualquer serviço que faça buscas por ID, por exemplo.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
