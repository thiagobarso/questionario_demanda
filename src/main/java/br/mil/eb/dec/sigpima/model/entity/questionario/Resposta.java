package br.mil.eb.dec.sigpima.model.entity.questionario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.mil.eb.dec.sigpima.model.entity.AbstractPojo;

@Entity
@Table(schema = "sigpima", name = "tb_resposta")
public class Resposta extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long codigo;

	@Column
	private String resposta;

	@Column
	private String tipo;

	@OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OpcoesResposta> perguntas;

	public Resposta(String resposta, String tipo) {
		this.resposta = resposta;
		this.tipo = tipo;
	}

	public Resposta() {
	}

	@Override
	public Long getCodigo() {
		return codigo;
	}

	@Override
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
