package br.mil.eb.dec.sigpima.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.mil.eb.dec.sigpima.model.entity.questionario.Grupo;

public class GrupoDao {
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;

		// Obtém o factory a partir da unidade de persistência.
		factory = Persistence.createEntityManagerFactory("questionario");
		// Cria um entity manager.
		entityManager = factory.createEntityManager();
		// Fecha o factory para liberar os recursos utilizado.

		return entityManager;
	}

	public Grupo salvar(Grupo item) throws Exception {
		EntityManager entityManager = getEntityManager();
		try {
			// Inicia uma transação com o banco de dados.
			entityManager.getTransaction().begin();
			System.out.println("Salvando Grupo.");
			// Verifica se a pessoa ainda não está salva no banco de dados.
			if (item.getCodigo() == null) {
				// Salva os dados da pessoa.
				entityManager.persist(item);
			} else {
				// Atualiza os dados da pessoa.
				item = entityManager.merge(item);
			}
			// Finaliza a transação.
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return item;
	}

	public void excluir(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			// Inicia uma transação com o banco de dados.
			entityManager.getTransaction().begin();
			// Consulta a pessoa na base de dados através do seu ID.
			Grupo item = entityManager.find(Grupo.class, id);
			System.out.println("Excluindo os dados de: " + item.getNome());
			// Remove a pessoa da base de dados.
			entityManager.remove(item);
			// Finaliza a transação.
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	public Grupo consultarPorId(Long id) {
		EntityManager entityManager = getEntityManager();
		Grupo item = null;
		try {
			// Consulta uma pessoa pelo seu ID.
			item = entityManager.find(Grupo.class, id);
		} finally {
			entityManager.close();
		}
		return item;
	}
}
