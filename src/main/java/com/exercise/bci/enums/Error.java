package com.exercise.bci.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Enumeracion de Errores
 */
public enum Error {

    INTERNAL_SERVER_ERROR("500", "Error desconocido", "Error no contemplado por el api"),
    BAD_REQUEST("400", "Problema en el request", "Algun dato es incorrecto"),
    NOT_FOUND("404", "Recurso no encontrado", "No se pudo encontrar la informacion requerida"),
	USER_EXISTS("409", "Usuario existente", "Ya existe el Usuario que se desea dar de alta"),
	EMAIL_NOT_VALID("412", "Email inválido", "El e-mial tiene un formato inválido"),
	PASSWORD_NOT_VALID("407", "Clave inválido", "La clave debe tener solo una Mayúscula y solamente dos números, en combinación con letras; largo máximo de 12 y mínimo de 8.");

    private final String codigo;
    private final String titulo;
    private final String detalle;

    private static final Map<String, Error> resolverMapper = crearResolverMapper();

	Error(String codigo, String titulo, String detalle) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.detalle = detalle;
	}

	private static Map<String, Error> crearResolverMapper() {
        return Arrays.stream(values()).collect(Collectors.toMap(Error::getCodigo, errores -> errores));
    }

    public static Error obtenerErrorPorId(final String codigoEstado) {
        return resolverMapper.getOrDefault(codigoEstado, Error.INTERNAL_SERVER_ERROR);
    }
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getDetalle() {
		return this.detalle;
	}
}
