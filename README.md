# ☁️ Modelagem Bleach com Banco de Dados

Implementação em **Java** para treinar manipulações de banco de dados via código e interface gráfica.

Este projeto é uma extensão do repositório original [Modelagem Bleach](https://github.com/luc-llb/modelagem-bleach), que modela personagens e entidades do universo do anime **Bleach** utilizando orientação a objetos.

---

## 🆕 Atualizações desta Versão

* 🔗 **Persistência com Hibernate**:

  * Integração com **banco de dados MariaDB** para armazenar e consultar dados das entidades do sistema.

* 🖼️ **Interfaces Gráficas**:

  * Criação de janelas interativas para facilitar a visualização e manipulação dos dados.

---

## 💻 Tecnologias Utilizadas

* **Java 8**
* **Eclipse IDE**
* **Hibernate ORM**
* **MariaDB** (SGBD)
* **Swing** (para criação das interfaces)

---

## ⚙️ Como Executar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repo.git
```

2. Importe o projeto no **Eclipse IDE**.

3. Configure o **banco de dados MariaDB**:

   * Crie um banco de dados com nome apropriado (ex: `bleach_db`).
   * Atualize as credenciais e URL de conexão no arquivo de configuração do Hibernate (`hibernate.cfg.xml`).

4. Certifique-se de ter as seguintes dependências no classpath:

   * Hibernate Core
   * JDBC Driver do MariaDB

5. Execute a classe principal ou as telas desejadas diretamente pela IDE.

---

## 📚 Referência

Projeto baseado no repositório [Modelagem Bleach](https://github.com/luc-llb/modelagem-bleach), desenvolvido para a disciplina **Laboratório de Banco de Dados (ECOT13A)** na **Universidade Federal de Itajubá (UNIFEI)**.

Esta extensão foca na aplicação prática de técnicas de persistência e modelagem de bancos de dados.
