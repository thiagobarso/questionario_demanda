package br.mil.eb.dec.sigpima;

import br.mil.eb.dec.sigpima.model.dao.OpcoesRespostaDao;
import br.mil.eb.dec.sigpima.model.dao.PerguntaDao;
import br.mil.eb.dec.sigpima.model.dao.RespostaDao;
import br.mil.eb.dec.sigpima.model.entity.questionario.OpcoesResposta;
import br.mil.eb.dec.sigpima.model.entity.questionario.Pergunta;
import br.mil.eb.dec.sigpima.model.entity.questionario.Resposta;

public class Main {

	public static void main(String[] args) {

		PerguntaDao perguntaDao = new PerguntaDao();
		RespostaDao respostaDao = new RespostaDao();

		OpcoesRespostaDao opcoesRespostaDao = new OpcoesRespostaDao();

		Pergunta pergunta = perguntaDao.consultarPorId(2l);
		Resposta resposta = respostaDao.consultarPorId(1l);

		OpcoesResposta resposta2 = opcoesRespostaDao.consultarPorPerguntaResposta(pergunta, resposta);
		System.out.println(resposta2.getId().toString());

	}

}