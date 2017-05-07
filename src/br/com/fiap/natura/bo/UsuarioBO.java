package br.com.fiap.natura.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.xml.bind.DataBindingException;

import br.com.fiap.natura.dao.UsuarioDAO;
import br.com.fiap.natura.dao.impl.UsuarioDAOImpl;
import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.exceptions.CommitException;
import br.com.fiap.natura.exceptions.IdNotFoundException;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class UsuarioBO {

	/**
	 * 
	 * @param usuario
	 * @throws CommitException
	 * 
	 *             Cadastra um usuário local de software
	 */
	public void cadastrar(Usuario usuario) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);

		try {
			dao.inserir(usuario);
			dao.salvar();
		} catch (CommitException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param usuario
	 * @throws CommitException
	 * 
	 *             Atualiza registro de usuário
	 */
	public void editar(Usuario usuario) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);

		try {
			dao.atualizar(usuario);
			dao.salvar();
		} catch (CommitException e) {
		} finally {
			em.close();
		}
	}

	public Usuario buscar(int codigo) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);

		Usuario usuario = dao.buscar(codigo);
		em.close();
		return usuario;
	}

	public void deletar(int codigo) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);

		try {
			dao.remover(codigo);
			dao.salvar();	
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		} catch (CommitException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @return lista de usuário
	 * 
	 *         Lista todos usuários cadastrados no banco de dados(Consultores e
	 *         clientes)
	 * @throws Exception
	 */
	public List<Usuario> listar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		List<Usuario> lista = dao.listar();
		em.close();
		return lista;
	}

	/**
	 * 
	 * @param usuario
	 * @return usuario
	 * @throws Exception
	 * 
	 *             Autentica usuário local de software. Caso o usuario exista,
	 *             retorne os dados do usuário
	 */
	public Usuario autenticarUsuarioLocal(Usuario usuario) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		try {
			UsuarioDAO dao = new UsuarioDAOImpl(em);
			return dao.autenticarUsuarioLocal(usuario);
		} catch (NoResultException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}
}
