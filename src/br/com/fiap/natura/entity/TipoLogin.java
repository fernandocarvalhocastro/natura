package br.com.fiap.natura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Fernando C. Castro
 * @since 28/04/2017
 */
@Entity
@Table(name="T_NAT_TIPO_LOGIN")
@SequenceGenerator(name="seqTipoLogin", sequenceName="SQ_TP_LOGIN", allocationSize=1)
public class TipoLogin {

	@Id
	@GeneratedValue(generator="seqTipoLogin", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_tipo_login")
	private int codigo;
	
	@Column(name="ds_tipo_login")
	private String descricao;

	public TipoLogin() {
		super();
	}

	public TipoLogin(String descricao) {
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

}
