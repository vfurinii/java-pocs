# 📁 Java CSV File Manager - POC

Este projeto é uma **Prova de Conceito (POC)** em Java para demonstrar o **gerenciamento de arquivos CSV**, incluindo leitura, escrita e manipulação básica de dados tabulares.

🔗 Repositório: [github.com/vfurinii/java-pocs/tree/main/file-manager](https://github.com/vfurinii/java-pocs/tree/main/file-manager)

---

## 🎯 Objetivos

- Gerar arquivos `.csv` programaticamente.
- Ler e interpretar arquivos `.csv` existentes.
- Aplicar manipulações simples nos dados (como filtros, ordenações ou agregações).
- Servir como base para integrações com outros sistemas baseados em dados tabulares.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17** (ou compatível)
- **Maven**
- **Apache Commons CSV** ou **OpenCSV** *(dependendo da sua lib)*
- **JUnit 5** (testes unitários)

---

## 📁 Estrutura do Projeto

file-manager/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── com/vfurinii/filemanager/
│ │ └── CSVManager.java
│ └── test/
│ └── java/
│ └── com/vfurinii/filemanager/
│ └── CsvManagerTest.java
├── pom.xml
└── README.md


---

## ▶️ Como Executar

### Clonar o repositório

```bash
git clone https://github.com/vfurinii/java-pocs.git
cd java-pocs/file-manager

```
### Compilar e Executar
```bash 
mvn clean install
mvn exec:java -Dexec.mainClass="com.vfurinii.filemanager.Main"

