# Sobre

Trilha Java: "Put that Groovy on it: introduzindo testes em código Java legado usando Groovy"

Código legado Java pode ser testado, e nesta palestra vamos ver exemplos de técnicas de escrita de testes usando Groovy.

Disse Michael Feathers que "O principal fato que distingue o código legado do não-legado são os testes (...)". O Java, por sua abrangência e extensão de uso, criou muito código legado. A proposta desta palestra é apresentar exemplos de escrita de testes em Groovy para projetos Java de código legado. As facilidades do Groovy para criação de DSLs, o uso de Mixins e metaclasses pode facilitar a introdução  de testes em código legado de maneira mais produtiva. Let's groove together!

# Tópicos

## Teste é comunicação

* Mais do que verificação, o teste deve comunicar sua intenção e seus resultados

## Como mexer em código legado sem explodir tudo?

Michael Feathers dá altas ideias:
* Testes de caracterização
* Refactoring "seguro"(com testes == seguro. sem testes == "seguro")

## Antes de começar

* não há mágica: se seu código tá na zoeira, vai continuar na zoeira
* minor refactorings automáticos/simples são necessários, não tem como fugir deles
* lembre-se do CLASSPATH. Ele é traiçoeiro

## Preparando o terreno

* Criando um bom build. Gradle to the rescue!
* Eliminando dependências
* Limpando a área
* sim...sem testes por enquanto (exemplificar que é possível, utilizando Powermockito ou mecanismos de metaClass para código Groovy, escrever testes  sem mexer no código. Mas isso acaba sendo um pouco ineficaz e lento)

## Testando

* Teste em Java
* O mesmo teste em Groovy
* O mesmo teste em Groovy + Spock
* Diferenças (tomara que vocês achem tão legal quanto eu acho)

## O que mais dá prá fazer?

* Simplicidade!
* Mock w/o external fmwks
* Spock == DSL
* assertions muito massa! (expressividade)
* Traits
* metaClasses

## Conclusão



## Fontes
* a apresentação do amigo do lemão!
* o livro do feathers
* http://docs.groovy-lang.org/docs/latest/html/documentation/core-domain-specific-languages.html
