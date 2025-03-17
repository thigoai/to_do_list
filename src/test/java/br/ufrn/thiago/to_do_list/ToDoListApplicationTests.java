package br.ufrn.thiago.to_do_list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.ufrn.thiago.to_do_list.entity.Todo;

@SpringBootTest
class ToDoListApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("todo 1", "desc todo 1", false, 1);
		
		webTestClient
			.post()
			.uri(uri:"/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().esOk()
			.expectBody()
			.jsonPath(expression:"$").isArray()
			.jsonPath(expression:"$.length()").isEqualTo(expectedValue:1)
			.jsonPath(expression:"$").isArray()
			.jsonPath(expression:"$[0].nome").isEqualTo(todo.getNome())
			.jsonPath(expression:"$[0].descrisao").isEqualTo(todo.getDescricao())
			.jsonPath(expression:"$[0].realizado").isEqualTo(todo.getRealizado())
			.jsonPath(expression:"$[0].prioridade").isEqualTo(todo.getPrioridade())
		;
	}

	@Test
	void testCreateTodoFailure() {
	}
}
