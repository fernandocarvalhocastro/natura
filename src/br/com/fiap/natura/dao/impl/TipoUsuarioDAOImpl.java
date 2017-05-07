package br.com.fiap.natura.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.TipoUsuarioDAO;
import br.com.fiap.natura.entity.TipoUsuario;

public class TipoUsuarioDAOImpl extends GenericDAOImpl<TipoUsuario, Integer> implements TipoUsuarioDAO{

	public TipoUsuarioDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
