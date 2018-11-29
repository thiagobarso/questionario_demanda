package br.mil.eb.dec.sigpima.model.entity.questionario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.mil.eb.dec.sigpima.model.entity.AbstractPojo;

@Entity
@Table(schema = "sigpima", name = "tb_resposta_om")
public class RespostaOm extends AbstractPojo {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long codigo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_reposta_escolhida")
	private OpcoesResposta respostaEscolhida;
	
	@Column(name = "codom")
	private String codom;
	
	@Column(name = "idt_pessoa_resposta")
	private String identidade;
	
	@Column(name = "dt_inclusao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;
	
	@Column(name = "dt_envio_homologacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvioHomologacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCodom() {
		return codom;
	}

	public void setCodom(String codom) {
		this.codom = codom;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataEnvioHomologacao() {
		return dataEnvioHomologacao;
	}

	public void setDataEnvioHomologacao(Date dataEnvioHomologacao) {
		this.dataEnvioHomologacao = dataEnvioHomologacao;
	}

	public RespostaOm() {
		super();
	}

	public OpcoesResposta getRespostaEscolhida() {
		return respostaEscolhida;
	}

	public void setRespostaEscolhida(OpcoesResposta respostaEscolhida) {
		this.respostaEscolhida = respostaEscolhida;
	}



}
