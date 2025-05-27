# ❄️ Sistema de Doações de Inverno

Uma plataforma que conecta cidadãos a ONGs, permitindo doações de itens e valores monetários para ajudar pessoas em situação de vulnerabilidade durante o inverno.

---

## 🛠️ Tecnologias Utilizadas

- ✅ Java 17  
- ✅ Quarkus 3.2.5  
- ✅ Hibernate ORM + Panache  
- ✅ RESTEasy Reactive  
- ✅ Oracle Database

---

## 🧱 Arquitetura do Projeto

```
src/main/java/br/sistemadoacoes/
├── model       → Entidades JPA (Usuario, Ong, Doacao)
├── dto         → Objetos de transferência (DTOs)
├── resource    → Endpoints REST
├── bo          → Camada de regras de negócio (Business Object)
└── exception   → Tratamento de exceções personalizadas
```

---

## 🔁 Endpoints da API

### 📌 Usuários

| Método | Rota             | Descrição                   |
|--------|------------------|-----------------------------|
| POST   | `/usuarios`      | Cadastra um novo usuário    |
| GET    | `/usuarios`      | Lista todos os usuários     |
| POST   | `/usuarios/login`| Realiza login               |

**Exemplo JSON (POST /usuarios):**
```json
{
  "nome": "João",
  "email": "joao@email.com",
  "senha": "123456",
  "tipo": "cidadao",
  "telefone": "11999999999"
}
```

---

### 📌 ONGs

| Método | Rota                | Descrição                        |
|--------|---------------------|----------------------------------|
| POST   | `/ongs`             | Cadastra uma nova ONG           |
| GET    | `/ongs/{id}/doacoes`| Lista doações recebidas pela ONG|

**Exemplo JSON (POST /ongs):**
```json
{
  "nome": "ONG Frio Zero",
  "email": "contato@friozero.org",
  "telefone": "1122223333",
  "site": "https://friozero.org",
  "endereco": "Rua A, 123",
  "cnpj": "12.345.678/0001-99"
}
```

---

### 📌 Doações

| Método | Rota        | Descrição               |
|--------|-------------|-------------------------|
| POST   | `/doacoes`  | Realiza uma nova doação |
| GET    | `/doacoes`  | Lista todas as doações  |

**Exemplo JSON (POST /doacoes):**
```json
{
  "tipoDoacao": "Cobertores e alimentos",
  "valor": 100.0,
  "usuarioId": 1,
  "ongId": 1
}
```

---

## ⚠️ Observações

- O projeto utiliza **DTOs** para entrada de dados, separando a lógica de entidades.
- Toda a lógica de negócio é concentrada na **camada BO**.
- Tratamento de erros com exceções personalizadas (`RecursoNaoEncontradoException`).
- API organizada e preparada para integração futura com um front-end moderno.

---

## 👨‍💻 Desenvolvedor

**Madjer Henrique Finamor**  
🔗 [GitHub](https://github.com/MadjerFin)  
🔗 [LinkedIn](https://www.linkedin.com/in/madjer-finamor-51196117b/)