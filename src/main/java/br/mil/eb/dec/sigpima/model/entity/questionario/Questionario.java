package br.mil.eb.dec.sigpima.model.entity.questionario;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.mil.eb.dec.sigpima.model.entity.AbstractPojo;

@Entity
@Table(schema = "sigpima", name = "tb_questionario")
public class Questionario extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private Long codigo;

    @Column
    private String nome;
    
    @OneToMany(mappedBy = "questionario")
    private List<Grupo> grupo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Grupo> getGrupo() {
		return grupo;
	}

	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}

	public Questionario() {
		super();
	}

	public Questionario(Long codigo, String nome, List<Grupo> grupo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.grupo = grupo;
	}
	
	public Questionario(String nome) {
		super();
		this.nome = nome;
	}
       
    
}
