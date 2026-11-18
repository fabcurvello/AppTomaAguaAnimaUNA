<h1 align="center">💧 Toma Água — Android Nativo com Java</h1>

<p align="center">
  App didático de Android nativo usado nas aulas de <strong>Desenvolvimento Mobile com Android nativo (Java)</strong> que ministrei na <strong>Faculdade UNA de Sete Lagoas (Ânima Educação)</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Android-3DDC84?style=flat&logo=android&logoColor=white" alt="Android" />
  <img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Android%20Studio-3DDC84?style=flat&logo=androidstudio&logoColor=white" alt="Android Studio" />
  <img src="https://img.shields.io/badge/status-conclu%C3%ADdo-success?style=flat" alt="Status: concluído" />
  <img src="https://img.shields.io/badge/UNA%20Sete%20Lagoas-%C3%82nima%20Educa%C3%A7%C3%A3o-1F3A93?style=flat" alt="UNA Sete Lagoas - Ânima Educação" />
</p>

---

## Sobre este repositório

O **Toma Água** foi desenvolvido junto com os alunos nas aulas de **Desenvolvimento Mobile com Android nativo (Java)** que ministrei na **Faculdade UNA de Sete Lagoas (Ânima Educação)**.

O app tem uma missão simples e útil: lembrar o usuário de beber água. Ele escolhe um horário, escreve uma mensagem opcional e toca em **"Criar Alarme"**. O app então abre o relógio do próprio celular com o alarme já preenchido.

O resultado aparece na hora, no aplicativo de alarmes do aparelho, e isso empolga a turma. É o momento em que o aluno percebe que o app dele conversa com o sistema operacional e com outros aplicativos. A partir daí, o conceito de **Intent** deixa de ser abstrato.

Esta é a versão do app desenvolvida com as turmas da UNA Sete Lagoas, Ânima Educação, em 2025. Ela foi atualizada para o SDK 35 e tem interface edge-to-edge.

> ✅ **Projeto concluído:** o app está completo e serve como gabarito para revisão e prática dos alunos.

## Como o app funciona

| Ação do usuário | O que acontece |
|---|---|
| Toca no relógio **"00:00"** | Abre um `TimePickerDialog` para escolher hora e minuto |
| Escreve uma mensagem (opcional) | Vira o rótulo do alarme. Se ficar vazia, o app usa **"!!! TOMA ÁGUA !!!"** |
| Toca em **"Criar Alarme"** | O teclado é fechado e uma Intent abre o app de alarmes com tudo preenchido |
| Não há app de alarme no aparelho | Um `Toast` avisa o usuário |

## O que se aprende com este app

- **Intent implícita:** `new Intent(AlarmClock.ACTION_SET_ALARM)` para pedir ao sistema que outro app execute a ação
- **Passagem de dados com extras:** `putExtra()` com `AlarmClock.EXTRA_HOUR`, `EXTRA_MINUTES` e `EXTRA_MESSAGE`
- **Verificação antes de disparar:** `resolveActivity(getPackageManager())` para confirmar que existe um app capaz de tratar a Intent
- **Permissões no AndroidManifest:** declaração de `com.android.alarm.permission.SET_ALARM`
- **Diálogos de seleção de horário:** `TimePickerDialog` com `Calendar` para iniciar no horário atual
- **Formatação de dados:** `String.format("%02d")` para exibir a hora sempre com dois dígitos
- **Cliques definidos no XML:** `android:onClick` no `TextView` do relógio e no `Button`
- **Experiência do usuário:** fechar o teclado com `InputMethodManager` e dar feedback com `Toast`
- **Lógica em Java:** atributos, métodos, decisão com `if/else` e valor padrão para entrada vazia

## Tecnologias

| Categoria | Ferramentas |
|---|---|
| Plataforma | Android nativo |
| Linguagem | Java |
| IDE | Android Studio |
| Layout | XML com ConstraintLayout |
| Configuração | compileSdk 35 · minSdk 29 (Android 10) |

Pacote: `com.fabriciocurvello.apptomaaguaanimauna`

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/fabcurvello/AppTomaAguaAnimaUNA.git
   ```
2. Abra a pasta do projeto no **Android Studio** e aguarde a sincronização do Gradle.
3. Execute em um emulador ou em um celular Android com a depuração USB ativada.

> Para testar a criação do alarme, use um emulador ou aparelho que tenha o app Relógio instalado.

## Desafios para praticar

- Permitir escolher os dias da semana do alarme com `AlarmClock.EXTRA_DAYS`
- Criar o alarme sem abrir a interface do relógio com `AlarmClock.EXTRA_SKIP_UI`
- Adicionar um botão que cria vários lembretes ao longo do dia
- Mostrar na tela o último alarme criado

## Sobre o professor

**Fabricio Curvello** é desenvolvedor e professor de desenvolvimento de software. Leciona no SENAI-RJ desde 1997, em cursos de programação, banco de dados, web e desenvolvimento fullstack, e no Centro Universitário IBMR desde 2018, nos cursos de Análise e Desenvolvimento de Sistemas, Ciência da Computação e Gestão de TI.

No desenvolvimento mobile, usa apps curtos, visuais e com propósito claro para ensinar Android nativo com Java. A ideia é que cada conceito apareça funcionando na tela do celular do aluno, o que mantém a turma motivada e torna a prática de código mais eficiente.

- LinkedIn: [linkedin.com/in/fabriciocurvello](https://www.linkedin.com/in/fabriciocurvello)
- YouTube: [@fabriciocurvello](https://www.youtube.com/@fabriciocurvello)
- GitHub: [github.com/fabcurvello](https://github.com/fabcurvello)
- Currículo Lattes: [lattes.cnpq.br/2406072276749635](http://lattes.cnpq.br/2406072276749635)

---

<p align="center">
  Material de apoio às aulas de Desenvolvimento Mobile da Faculdade UNA de Sete Lagoas (Ânima Educação).
</p>
