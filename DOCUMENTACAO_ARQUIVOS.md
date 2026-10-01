# 📋 Documentação dos Arquivos - Projeto de Teste Web

## 📋 Requisitos da Lista de Exercícios

**4.1** - Crie um script simples que valide um produto do início (listagem) ao carrinho  
**4.2** - Organize esse mesmo script em Cucumber com Examples  
**4.3** - Organize esse mesmo script em Page Objects

---

## 🔍 Análise Detalhada de Cada Arquivo

### 🎯 4.1 - Script Simples

#### `SimpleTest.java` (Localização: `src/test/java/`)
- **O que faz**: Teste JUnit puro que implementa todo o fluxo de validação em um único método
- **Responsabilidade**: Executa o fluxo completo: Login → Listagem → Detalhes → Carrinho
- **Atende ao requisito**: ✅ **4.1** - Script simples que valida produto do início ao carrinho
- **Características**:
  - Usa apenas Selenium WebDriver
  - Não usa Page Objects nem Cucumber
  - Configuração preventiva anti-modal
  - Validações com `assertEquals()`
  - Teste independente em JUnit 5

---

### 🎯 4.2 - Cucumber com Examples

#### `ComprarProdutos.feature` (Localização: `src/test/resources/features/`)
- **O que faz**: Define cenários em linguagem natural (Gherkin) com **Examples**
- **Responsabilidade**: Especifica o comportamento esperado em português
- **Atende ao requisito**: ✅ **4.2** - Organiza o script em Cucumber com Examples
- **Características**:
  - BDD (Behavior Driven Development)
  - `Esquema do Cenário` com tabela de `Exemplos`
  - Testa múltiplos produtos (Backpack, Bike Light)
  - Linguagem natural em português

#### `ComprarProdutosSteps.java` (Localização: `src/test/java/steps/`)
- **O que faz**: Implementa as definições de steps (Given, When, Then)
- **Responsabilidade**: Conecta as frases do Gherkin com código Selenium
- **Atende ao requisito**: ✅ **4.2** - Implementação técnica dos steps do Cucumber
- **Características**:
  - Anotações `@Dado`, `@Quando`, `@Então`
  - Configuração Chrome preventiva anti-modal
  - Lógica de navegação e validação direta com Selenium
  - Métodos de setup e teardown do WebDriver

#### `TestRunner.java` (Localização: `src/test/java/steps/`)
- **O que faz**: Configura e executa os testes Cucumber
- **Responsabilidade**: Runner que conecta features com steps
- **Características**:
  - `@CucumberOptions` apontando para features e steps
  - Plugin de relatórios HTML
  - Configuração de execução dos cenários

---

### 🎯 4.3 - Page Objects

#### `ComprarProdutosPO.feature` (Localização: `src/test/resources/featuresPO/`)
- **O que faz**: Mesma funcionalidade do 4.2, mas para Page Objects
- **Responsabilidade**: Define cenários que usarão Page Objects
- **Atende ao requisito**: ✅ **4.3** - Cucumber organizado com Page Objects
- **Características**:
  - Idêntica ao 4.2 em termos de cenários
  - Executada por steps que usam Page Objects

#### `ComprarProdutosPOSteps.java` (Localização: `src/test/java/stepsPO/`)
- **O que faz**: Steps que **usam Page Objects** ao invés de Selenium direto
- **Responsabilidade**: Conecta Gherkin com Page Objects
- **Atende ao requisito**: ✅ **4.3** - Steps implementados usando Page Objects
- **Características**:
  - Instancia as páginas: `loginPage`, `inventoryPage`, `productDetailsPage`, `cartPage`
  - Chama métodos das páginas ao invés de `driver.findElement()`
  - Configuração Chrome preventiva anti-modal
  - Separação clara entre lógica de teste e interação com elementos

#### `TestRunnerPO.java` (Localização: `src/test/java/stepsPO/`)
- **O que faz**: Runner específico para testes com Page Objects
- **Responsabilidade**: Executa features que usam Page Objects
- **Características**:
  - Aponta para `featuresPO/` e `stepsPO/`
  - Configuração independente do runner padrão

---

### 📁 Classes Page Objects (Localização: `src/test/java/pages/`)

#### `BasePage.java`
- **O que faz**: Classe base para todas as páginas
- **Responsabilidade**: Funcionalidades comuns (construtor, wait, etc.)
- **Características**:
  - Construtor que recebe WebDriver
  - WebDriverWait configurado
  - Métodos utilitários comuns

#### `LoginPage.java`
- **O que faz**: Encapsula elementos e ações da página de login
- **Responsabilidade**: 
  - `fazerLogin(usuario, senha)` - Executa o login
  - `obterMensagemErro()` - Captura mensagens de erro
- **Elementos encapsulados**:
  - Campo usuário (`user-name`)
  - Campo senha (`password`)
  - Botão login (`login-button`)

#### `InventoryPage.java`
- **O que faz**: Encapsula elementos e ações da página de produtos
- **Responsabilidade**:
  - `selecionarProduto(nomeProduto)` - Seleciona produto por nome
  - `obterNomeProduto(nomeProduto)` - Obtém nome do produto
  - `obterPrecoProduto(nomeProduto)` - Obtém preço do produto
  - `clicarNoProduto(nomeProduto)` - Navega para detalhes
- **Elementos encapsulados**:
  - Lista de produtos (`inventory_item`)
  - Nomes dos produtos (`inventory_item_name`)
  - Preços dos produtos (`inventory_item_price`)

#### `ProductDetailsPage.java`
- **O que faz**: Encapsula elementos e ações da página de detalhes
- **Responsabilidade**:
  - `obterNomeProduto()` - Obtém nome na página de detalhes
  - `obterPrecoProduto()` - Obtém preço na página de detalhes
  - `adicionarAoCarrinho()` - Adiciona produto ao carrinho
  - `obterDescricaoProduto()` - Obtém descrição do produto
- **Elementos encapsulados**:
  - Nome do produto (`inventory_details_name`)
  - Preço do produto (`inventory_details_price`)
  - Botão adicionar (`add-to-cart`)

#### `CartPage.java`
- **O que faz**: Encapsula elementos e ações da página do carrinho
- **Responsabilidade**:
  - `obterNomeProduto()` - Obtém nome do produto no carrinho
  - `obterPrecoProduto()` - Obtém preço do produto no carrinho
  - `irParaCarrinho()` - Navega para o carrinho
  - `removerProduto()` - Remove produto do carrinho
- **Elementos encapsulados**:
  - Link do carrinho (`shopping_cart_link`)
  - Itens do carrinho (`cart_item`)
  - Nomes no carrinho (`inventory_item_name`)
  - Preços no carrinho (`inventory_item_price`)

---

## 🏗️ Estrutura de Diretórios

```
src/test/java/
├── SimpleTest.java                    ✅ 4.1 - Script Simples (JUnit puro)
├── steps/
│   ├── ComprarProdutosSteps.java      ✅ 4.2 - Cucumber Steps (Selenium direto)
│   └── TestRunner.java                ✅ 4.2 - Cucumber Runner
├── stepsPO/
│   ├── ComprarProdutosPOSteps.java    ✅ 4.3 - Page Object Steps (usa Page Objects)
│   └── TestRunnerPO.java              ✅ 4.3 - Page Object Runner
└── pages/
    ├── BasePage.java                  ✅ 4.3 - Classe base para páginas
    ├── LoginPage.java                 ✅ 4.3 - Página de login
    ├── InventoryPage.java             ✅ 4.3 - Página de produtos
    ├── ProductDetailsPage.java        ✅ 4.3 - Página de detalhes
    └── CartPage.java                  ✅ 4.3 - Página do carrinho

src/test/resources/
├── features/
│   └── ComprarProdutos.feature        ✅ 4.2 - Cenários Cucumber
└── featuresPO/
    └── ComprarProdutosPO.feature      ✅ 4.3 - Cenários para Page Objects
```

---

## 🎯 Resumo por Implementação

| Implementação | Arquivos | Função | Requisito Atendido |
|---------------|----------|---------|-------------------|
| **4.1 - Script Simples** | `SimpleTest.java` | JUnit puro, tudo em um método | ✅ Script simples |
| **4.2 - Cucumber Examples** | `ComprarProdutos.feature`<br>`ComprarProdutosSteps.java`<br>`TestRunner.java` | BDD com Examples, steps diretos | ✅ Cucumber + Examples |
| **4.3 - Page Objects** | `ComprarProdutosPO.feature`<br>`ComprarProdutosPOSteps.java`<br>`TestRunnerPO.java`<br>`pages/*.java` | BDD + Page Objects pattern | ✅ Cucumber + Page Objects |

---

## 🔄 Fluxo de Validação (Comum às 3 implementações)

1. **Setup**: Configuração Chrome anti-modal
2. **Login**: Acesso com `standard_user` / `secret_sauce`
3. **Listagem**: Captura nome e preço do produto
4. **Detalhes**: Navega e valida mesmo nome/preço
5. **Carrinho**: Adiciona e valida consistência
6. **Validação**: `assertEquals()` entre todas as etapas
7. **Teardown**: Fechamento do browser

---

## 🏆 Resultados dos Testes

- **SimpleTest**: `Tests run: 1, Failures: 0, Errors: 0` (~3s)
- **TestRunner**: `Tests run: 2, Failures: 0, Errors: 0` (~6s)  
- **TestRunnerPO**: `Tests run: 2, Failures: 0, Errors: 0` (~17s)
- **Total**: `Tests run: 5, Failures: 0, Errors: 0, Skipped: 0`

---

## 🔧 Configurações Anti-Modal

Todas as implementações usam configurações preventivas do Chrome:
- `--disable-save-password-bubble`
- `--disable-features=PasswordManager,AutofillServerCommunication`
- `credentials_enable_service: false`
- `profile.password_manager_enabled: false`

**Resultado**: Modal "Mude sua senha" eliminada definitivamente! ✅

---

**Todas as 3 implementações fazem a MESMA validação, mas com arquiteturas diferentes!** 🚀

Data de criação: 01 de outubro de 2025