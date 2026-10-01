// 0 - nome do pacote

// 1 - bibliotecas
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test; // Classe Resposta do REST-Assured

import static io.restassured.RestAssured.given; // função given

// 2 - classe
public class TestPet {

    // 2.1 - atributos
    static String ct = "application/json"; // Content-Type
    static String uriPet = "https://petstore.swagger.io/v2/pet"; // Base URL + endpoint
    static int petId = 95; // Código esperado do pet

    // 2.2 - funções e métodos
    // 2.2.1 - funções e métodos comuns / uteis
    // Função de leitura do arquivo JSON
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    // 2.2.2 - métodos de teste
    @Test
    public void testPostPet() throws IOException {
        // Configura

        // carregar os dados do arquivo JSON do pet ￼￼￼
        String jsonBody = lerArquivoJson("src/test/resources/json/pet1.json");

        // Entrada - petId que está definido no nível da classe

        // Começa o teste via Rest-Assured
        given() // Dado que
                .contentType(ct) // O tipo do conteudo é
                .log().all() // Mostre tudo na ida
                .body(jsonBody) // Envie o corpo da requisição
                // Executa
                .when() // Quando
                .post(uriPet) // Chamamos o endpoint faznedo um POST
                // Valida
                .then() // Então
                .log().all() // Mostre tudo na volta
                .statusCode(200) // O código de resposta é 200
                .body("name", is("Snoopy")) // Verifica se o nome é Snoopy
                .body("id", is(petId)) // Verifica o código do pet
                .body("category.name", is("cachorro")) // Verifica se é cachorro
                .body("tags[0].name", is("vacinado")) // Verifica se está vacinado
        ; // Fim do given

    }

    @Test
    public void testGetPet() {
        // Configura

        // Entrada - petId que está definido no nível da classe

        // Saídas / Resultados esperados

        String petName = "Snoopy"; // Nome do pet esperado
        String categoryName = "cachorro"; // Categoria do pet esperado
        String tagName = "vacinado"; // Tag do pet esperado

        given()
                .contentType(ct) // O tipo do conteudo é
                .log().all() // Mostre tudo na ida
                // Quando é get ou delete não tem body
                // Executa
                .when() // Quando
                .get(uriPet + "/" + petId) // Montar o endpoint da URI/<petId>
                // Valida
                .then() // Então
                .log().all() // Mostre tudo na volta
                .statusCode(200) // O código de resposta é 200
                .body("name", is("Snoopy")) // Verifica se o nome é Snoopy
                .body("id", is(petId)) // Verifica o código do pet
                .body("category.name", is("cachorro")) // Verifica se é cachorro
                .body("tags[0].name", is("vacinado")) // Verifica se está vacinado

        ; // Fim do given

    }
}
