package br.com.fiap.natura.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Fernando C. Castro
 * @since 28/04/2017
 * 
 * Classe de tipo de usuário de software.
 */
@Entity
@Table(name="T_NAT_TIPO_USUARIO")
@SequenceGenerator(name="seqTipoUsuario", sequenceName="SQ_TP_USUARIO", allocationSize=1)
public class TipoUsuario {
	@Id
	@GeneratedValue(generator="seqTipoUsuario",strategy=GenerationType.SEQUENCE)
	@Column(name="cd_usuario")
	private int codigo;
	
	@Column(name="ds_tipo_usuario", nullable=false, length=50)
	private String descricao;

	@OneToMany(mappedBy="tipoUsuario" , cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void adicionarUsuario(Usuario usuario){
		usuario.setTipoUsuario(this);
		usuarios.add(usuario);
		this.setUsuarios(usuarios);
	}
	
	public TipoUsuario() {
		super();
	}

	public TipoUsuario(String descricao) {
		super();
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
