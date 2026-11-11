# Portfólio do Trabalho de Graduação – Vinicius P. de Pádua

## Sumário

- [Sobre mim](#sobre-mim)
- [Visão geral da jornada](#visão-geral-da-jornada)
- [1º semestre – Calculadora em VisualG (Desenvolvedor)](#1º-semestre--calculadora-em-visualg-desenvolvedor)
- [2º semestre – Sistema de Gerenciamento de Horários (Scrum Master)](#2º-semestre--sistema-de-gerenciamento-de-horários-scrum-master)
- [3º semestre – Proficio, mapeamento de competências (Product Owner)](#3º-semestre--proficio-mapeamento-de-competências-product-owner)
- [4º semestre – Trivio, gestão de manutenções (Desenvolvedor)](#4º-semestre--trivio-gestão-de-manutenções-desenvolvedor)
- [Competências desenvolvidas](#competências-desenvolvidas)
- [Considerações finais](#considerações-finais)

## Sobre mim

<img src="assets/foto.jpg" alt="Foto de Vinicius P. de Pádua" width="180" align="right">

Sou Vinicius P. de Pádua, estudante da Fatec São José dos Campos, e este portfólio reúne os projetos que desenvolvi do primeiro ao quarto semestre do curso. Neles passei por três papéis do Scrum (desenvolvedor, Scrum Master e Product Owner) e trabalhei com um parceiro real, a Altave, em dois semestres.

<!-- TODO: complementar com o nome do curso, a motivação para a área, os interesses profissionais e seus contatos (e-mail, LinkedIn, GitHub). -->

<br clear="right">

## Visão geral da jornada

Em quatro semestres, os projetos evoluíram de um programa de console em VisualG para plataformas web completas com backend, frontend e banco de dados, e meu papel mudou a cada ciclo.

| Semestre | Projeto | Meu papel | Parceiro | Tecnologias principais | Repositório |
| --- | --- | --- | --- | --- | --- |
| 1º | Calculadora em VisualG | Desenvolvedor | Fatec | VisualG, Git, ClickUp | [link](https://github.com/IsaacOliveiraSouza/Aplicacao_Projeto_Integragor_Fatec) |
| 2º | Gerenciador de horários de aula (SINAPSE) | Scrum Master | Fatec | Java, MySQL, Jira | [link](https://github.com/vp-p/gerenciador-horario-aula) |
| 3º | Proficio, mapeamento de competências | Product Owner | Altave | Java, Spring, TypeScript, MySQL, Docker | [link](https://github.com/Concord-API/API-3) |
| 4º | Trivio, gestão de manutenções | Desenvolvedor | Altave | Java, Spring, Vue.js, Oracle, Docker | [link](https://github.com/Concord-API/API-4) |

## 1º semestre – Calculadora em VisualG (Desenvolvedor)

No primeiro semestre, atuei como desenvolvedor da equipe "The Buggers" em uma calculadora de console feita em VisualG, entregue em três sprints com todo o backlog concluído.

**Contexto.** O Projeto Integrador do primeiro semestre da Fatec pedia uma ferramenta capaz de executar operações matemáticas essenciais, usando o VisualG (ambiente de pseudocódigo em Portugol) para praticar lógica de programação. Foi meu primeiro contato com desenvolvimento em equipe e com o fluxo do Scrum.

**Solução.** A aplicação tem interface textual e reúne as seguintes funcionalidades:

- operações básicas (soma, subtração, multiplicação e divisão) e operações múltiplas;
- fatorial e função de segundo grau;
- conversão entre bases numéricas (decimal ↔ binário, binário ↔ octal e binário ↔ hexadecimal);
- concatenação de duas strings;
- juros simples e compostos.

**Organização do trabalho.** O backlog tinha 11 itens com prioridade Alta, Média ou Baixa, distribuídos em três sprints: a primeira entregou a interface de texto e as operações básicas, a segunda o fatorial e os juros simples, e a terceira a função de segundo grau, os juros compostos, as conversões de base e a concatenação. Cada sprint foi encerrada com uma Sprint Review documentada no repositório.

**Tecnologias e ferramentas.** VisualG, Git e GitHub para versionamento e ClickUp para a gestão das tarefas.

**Minha contribuição.** Implementei na calculadora a operação de subtração (setembro de 2024), os juros simples (outubro) e os juros compostos (novembro) e, ao final do projeto, ajustei a formatação da interface de texto (dezembro de 2024).

**Aprendizados.** Lógica de programação e estruturas de controle, divisão de requisitos em tarefas pequenas, versionamento com Git e a rotina de planejamento, execução e revisão de uma sprint.

Repositório: [Aplicacao_Projeto_Integragor_Fatec](https://github.com/IsaacOliveiraSouza/Aplicacao_Projeto_Integragor_Fatec)

## 2º semestre – Sistema de Gerenciamento de Horários (Scrum Master)

No segundo semestre, como Scrum Master da equipe SINAPSE, conduzi o desenvolvimento de um sistema em Java e MySQL para a coordenação da Fatec definir os horários de aula de cada professor sem conflitos.

**Contexto.** O projeto nasceu da necessidade de a coordenação montar a grade de horários de cada semestre sem sobrepor aulas, por exemplo um professor alocado em duas disciplinas ao mesmo tempo. A equipe tinha sete integrantes: um Product Owner, eu como Scrum Master e cinco desenvolvedores.

**Solução.** O sistema cobre o ciclo completo de montagem da grade:

- cadastro de cursos, disciplinas, professores, semestres e horários (aulas de 50 minutos, com posicionamento configurável por curso);
- registro das aulas com prevenção automática de conflitos e sugestão de alocações a partir do que já foi definido;
- visualização da grade em tabela e exportação para Excel;
- login por e-mail e senha, definição de disponibilidade dos professores e cadastro do coordenador de cada curso.

O backlog reuniu 11 histórias de usuário (SIN-6 a SIN-16), estimadas em pontos e priorizadas, e foi distribuído ao longo de quatro sprints. O repositório também traz o modelo entidade-relacionamento, o manual do usuário e o guia de instalação.

**Cronograma.**

| Etapa | Período |
| --- | --- |
| Kick-off | 26/02/2025 a 28/02/2025 |
| Sprint 1 | 10/03/2025 a 30/03/2025 |
| Sprint 2 | 07/04/2025 a 27/04/2025 |
| Sprint 3 | 05/05/2025 a 25/05/2025 |
| Feira de Soluções | 29/05/2025 |

**Tecnologias e ferramentas.** Java, MySQL e MySQL Workbench para a modelagem, IntelliJ IDEA como IDE, Git e GitHub para versionamento, Jira para a gestão do backlog e Slack para a comunicação.

**Meu papel.** Como Scrum Master, fui responsável por facilitar as cerimônias do Scrum, manter o Jira atualizado, remover impedimentos e garantir que o time respeitasse os combinados de permanência, como as reuniões semanais de segunda e quarta-feira e a comunicação nos canais oficiais.

<!-- TODO: ajustar com as cerimônias e situações que você de fato conduziu. -->

**Contribuições técnicas e de documentação.** Além de conduzir o Scrum, trabalhei diretamente no repositório:

- na documentação, abri o repositório, escrevi o README com o Product Backlog, registrei o burndown da sprint 1 e desenhei o wireframe da tela de cadastro de professor;
- no banco de dados, criei o modelo no MySQL Workbench e o atualizei em abril de 2025;
- no código, implementei a tela de cadastro de semestres na primeira sprint e, depois, trabalhei na aplicação com telas em FXML: tela de cadastro de disciplinas, grade horária com a coluna de horários, classes de domínio (Aula, Curso, Disciplina e Professor), DAOs e controllers, além da correção na instanciação de Aula.

**Aprendizados.** Facilitação de cerimônias ágeis, acompanhamento de progresso por pontos de história, modelagem relacional, programação orientada a objetos em Java e comunicação com o Product Owner e com o cliente final, a coordenação.

Repositório: [gerenciador-horario-aula](https://github.com/vp-p/gerenciador-horario-aula)

## 3º semestre – Proficio, mapeamento de competências (Product Owner)

No terceiro semestre, como Product Owner da equipe Concord, representei a necessidade do parceiro Altave e priorizei o backlog do Proficio, uma plataforma que funciona como um "LinkedIn interno" para mapear as habilidades dos colaboradores de uma empresa.

**Contexto.** Em organizações grandes, saber quem domina qual tecnologia ou competência costuma depender de conversas informais. O Proficio centraliza essas informações para que gestores identifiquem talentos, montem equipes e acompanhem a evolução de cada pessoa. A equipe tinha seis integrantes: eu como Product Owner, um Scrum Master e quatro desenvolvedores.

**Solução.** A plataforma reúne as seguintes funcionalidades:

- perfis de colaboradores com habilidades técnicas e comportamentais, certificações e experiência;
- tags e avaliações feitas por gestores, além de autoavaliação das habilidades;
- busca e filtro de colaboradores por habilidade;
- visualização da distribuição de habilidades, com níveis de proficiência em números e cores;
- cadastro de habilidades ainda inexistentes, com atualização automática dos indicadores;
- login com controle de acesso por perfil e liderança de squad dentro de um time.

**Cronograma.**

| Sprint | Período | Objetivo |
| --- | --- | --- |
| Sprint 1 | 08/09/2025 a 28/09/2025 | Construir a base da aplicação e as funcionalidades essenciais |
| Sprint 2 | 06/10/2025 a 26/10/2025 | Desenvolver as funcionalidades principais e refinar o fluxo |
| Sprint 3 | 03/11/2025 a 23/11/2025 | Concluir épicos, testar e estabilizar o sistema |

**Organização técnica.** O repositório é dividido em backend, frontend e documentação, ligados por submódulos Git. O time adotou branches por sprint e por tarefa, commits semânticos (`feat`, `fix`, `docs`, `chore`) e GitHub Projects para acompanhar épicos e subtarefas.

**Tecnologias.** Java com Spring no backend, TypeScript, JavaScript, HTML, CSS e Tailwind CSS no frontend, MySQL como banco de dados, Docker, Git e GitHub, com IntelliJ IDEA e VS Code como ambientes de desenvolvimento.

**Meu papel.** Como Product Owner, fui a ponte entre o parceiro e o time: levantei as necessidades da Altave, transformei-as em histórias de usuário com prioridade (Alta, Média ou Baixa) e estimativa, e ordenei o backlog de cada sprint, como o filtro de colaboradores por habilidade e a visualização de proficiência, que ficaram com prioridade alta na terceira sprint.

<!-- TODO: acrescentar reuniões com a Altave, decisões de priorização e validações que você conduziu. -->

**Contribuições registradas.** Grande parte do meu trabalho está na documentação do repositório principal, e também escrevi código no backend:

- documentação: Product Backlog e Sprint Backlog, critérios de aceitação, dicionário do backlog, Definition of Ready e Definition of Done, vínculo das histórias aos épicos, cronograma do projeto, estrutura de branches e padrão de commits, modelos MER e DER e o guia de instalação;
- backend (API3-Backend), na funcionalidade de perfil: mapeamento entre colaborador e equipe (chaves estrangeiras e relacionamento um-para-muitos), `EquipeService`, controller, view models e DTOs de equipe, e a contagem de colaboradores por equipe (outubro de 2025).

**Aprendizados.** Escrita de histórias de usuário, priorização por valor para o cliente, gestão de expectativas com um parceiro real, visão de produto e integração entre backend e frontend em repositórios separados.

Repositório: [Concord-API/API-3](https://github.com/Concord-API/API-3)

## 4º semestre – Trivio, gestão de manutenções (Desenvolvedor)

No quarto semestre, de novo em parceria com a Altave, atuei como desenvolvedor do Trivio, uma plataforma para planejar e acompanhar a manutenção de equipamentos espalhados pelo mundo e cobertos por contratos com diferentes empresas.

**Contexto.** Coordenar equipes técnicas em muitos locais, com contratos e exigências distintas, é difícil sem uma visão centralizada. O Trivio permite cadastrar equipamentos, planejar manutenções recorrentes e organizar as intervenções por localização, duração estimada e prioridade. Voltei a trabalhar com a mesma equipe base do semestre anterior, agora com sete integrantes e outro Product Owner.

**Solução.** O backlog tinha 12 histórias de usuário, distribuídas em três sprints:

| Sprint | Período | Entregas principais |
| --- | --- | --- |
| Sprint 1 | 16/03 a 05/04/2026 | Gestão de técnicos, de equipamentos (local e habilidades exigidas) e dos requisitos que cada Tech Lead atende |
| Sprint 2 | 13/04 a 03/05/2026 | Visão pessoal do técnico, geração automática de manutenções recorrentes, disponibilidade online e manutenções no mapa |
| Sprint 3 | 11/05 a 31/05/2026 | Registro da manutenção pelo técnico, monitoramento pelo administrador, processos personalizados por contrato, alertas em tela e tema da conta |

Cada sprint foi documentada no repositório e acompanhada de um vídeo de demonstração. A entrega final inclui o manual do usuário com o catálogo de funcionalidades e o guia de instalação.

**Tecnologias.** Java com Spring no backend, Vue.js, JavaScript, HTML e CSS no frontend, banco de dados Oracle, Docker, Git, GitHub e VS Code. Backend e frontend ficam em repositórios separados, ligados ao repositório principal por submódulos Git.

**Minha contribuição.** Meus commits estão no backend (API4-Backend) e giram em torno da geração automática de manutenções preventivas, a história de manutenções recorrentes do backlog. Para isso apliquei o padrão de projeto Observer.

**Destaque: Observer na criação automática de manutenções.** Cada contrato tem uma recorrência de manutenção, e a próxima preventiva deve ser criada quando a atual é concluída. Em vez de colocar essa regra dentro do serviço de manutenções, separei o evento de quem reage a ele (abril de 2026):

- `MaintenanceObserver` é a interface com o método `updateStatus(Maintenance)`. O commit que a criou registra o objetivo de escalar por polimorfismo, ou seja, novas reações entram como novas implementações.
- `MaintenancePublisher` é o sujeito. É um componente Spring que recebe por construtor a lista de observers disponíveis e oferece `subscribe`, `unsubscribe` e `notifyObservers`.
- `MaintenanceServiceImpl` recebe o publisher por injeção no construtor e chama `notifyObservers` quando a manutenção muda.
- `MaintenanceCreatorObserver` é o observer concreto. Quando o status é concluído, ele consulta (`existsNextMaintenance`) se já há uma manutenção ativa posterior no contrato e, se não houver, cria uma preventiva agendada com a data anterior somada à recorrência do contrato.

**Evolução na terceira sprint (28 e 29 de maio de 2026).** Removi o bloqueio que impedia gerar nova manutenção a partir de uma concluída, fiz a nova manutenção herdar latitude e longitude da anterior e implementei a validação da criação. Por fim, ao concluir uma manutenção a API passou a devolver uma sugestão da próxima (`NextMaintenanceSuggestionDTO`) e ganhou um endpoint de confirmação.

**Aprendizados.** Desenvolvimento backend com Java e Spring, aplicação do padrão Observer para desacoplar regras de negócio, consultas JPA, uso de banco Oracle, conteinerização com Docker, trabalho com repositórios separados e submódulos, e a experiência de ver o produto por outro papel depois de ter sido Product Owner no semestre anterior.

Repositório: [Concord-API/API-4](https://github.com/Concord-API/API-4)

## Competências desenvolvidas

O conjunto dos quatro projetos me deu uma base técnica que cresceu a cada semestre e experiência em três papéis diferentes do Scrum.

| Área | O que desenvolvi | Onde apliquei |
| --- | --- | --- |
| Programação | Lógica de programação, orientação a objetos em Java, APIs com Spring e padrões de projeto como o Observer | 1º, 2º, 3º e 4º semestres |
| Banco de dados | Modelagem relacional, MySQL e Oracle | 2º, 3º e 4º semestres |
| Ferramentas | Git e GitHub, Docker, IntelliJ IDEA, VS Code | Todos os semestres |
| Gestão ágil | Facilitação de cerimônias, backlog, histórias de usuário, estimativa e priorização com ClickUp, Jira e GitHub Projects | 1º, 2º e 3º semestres |
| Comportamentais | Comunicação com clientes e parceiros, trabalho em equipe, organização e cumprimento de prazos | Todos os semestres |

## Considerações finais

Os quatro semestres mostraram que entregar software é tanto uma questão de organização e comunicação quanto de código. Ser Scrum Master e Product Owner antes de voltar ao papel de desenvolvedor mudou a forma como leio um backlog e como converso com quem usa o produto.

Daqui em diante, pretendo aprofundar o desenvolvimento full stack e a arquitetura de aplicações corporativas.

<!-- TODO: ajustar com seus objetivos e os próximos semestres. -->
