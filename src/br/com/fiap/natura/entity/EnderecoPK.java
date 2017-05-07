package br.com.fiap.natura.entity;

import java.io.Serializable;

public class EnderecoPK implements Serializable{
	private int usuario;
	private int codigo; // Codigo do endereço

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
