package br.mil.eb.dec.sigpima.model.entity.questionario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.mil.eb.dec.sigpima.model.entity.AbstractPojo;

@Entity
@Table(schema = "sigpima", name = "tb_questio_pergunta")
public class Pergunta extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long codigo;

	@Column
	private String pergunta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupo")
	private Grupo grupo;

	@OneToMany(mappedBy = "resposta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OpcoesResposta> resposta;

	public Pergunta() {
	}

	public Pergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
