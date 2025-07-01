// **Foco em Abstração:** seus alunos devem visualizar o herói como um objeto genérico que expõe apenas o necessário e esconde detalhes internos.
//
// - **Atributos (privados):** nome, classe, nível, vida atual, vida máxima, experiência e lista de itens.
//    - *Objetivo:* enxergar o herói como portador de características essenciais.
// - **Métodos Públicos:**
//    1. **Construtores:** receber nome e nível inicial. Deve usar `this` para associar parâmetros aos atributos.
//    2. **Getters (Acessores):** para leitura controlada de cada atributo (nome, nível, vida atual e status de vivo).
//    3. **Setters (Modificadores) limitados:** para atributos que podem mudar fora da lógica de negócio (por exemplo, vida atual).
//    4. **Método de Ataque (abstrato):** definido sem implementação na classe base, obrigando subclasses a detalhar a fórmula.
//    5. **Métodos Auxiliares:**
//        - **receberDano(int):** aplicar redução de vida e atualizar status de vivo.
//        - **ganharExperiencia(int):** agregar experiência, checar subida de nível automática e restaurar vida.
//        - **adicionarItem(Item):** adicionar item ao inventário e registrar descrição.
//        - **listarInventario():** iterar sobre a lista de itens e exibir cada um.
//    6. **toString():** sobrescrita para apresentar resumo do herói em linha única (nome, nível, vida, experiência).
// - **Uso de ``:** sempre que atributos internos coincidirem com nomes de parâmetro, garantir clareza usando `this.atributo`.
// - **Visibilidade e Encapsulamento:**
//    - Todos os atributos devem ser `private`.
//    - Métodos que combatem regras de negócio (`receberDano`, `ganharExperiencia`, etc.) são `public`.
//    - Nenhum atributo é exposto diretamente: todo acesso deve passar por método.
//
// *O aluno deve compreender que abstração não é apenas criar classes, mas definir quais detalhes 
// ficam escondidos e quais operações a classe disponibiliza aos consumidores.*
package model;

public class heroi {

}
