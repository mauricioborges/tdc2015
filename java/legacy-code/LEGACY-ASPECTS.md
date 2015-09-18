# Aspectos do sistema legado

* sem injeção de dependencia. todo mundo usa new!
* sem uso de interface
* classezona
* metodo gigante
* uso de recursos das camadas inferiores em qualquer lugar
* uso de MVC (people love MVC)

# o que é o sistema legado?


Um cadastro de produto e pedido
Nao pode ter produto com mesmo nome ou ean code (case insensitive)
Nome descrição preco marca ean apelido unidademedida
Sql (sqlite ou mysql)...mais enterprise

==

tocar generator
==
java -jar legacy-code.jar

> informe a opção: 1-produto, 2-pedido, 0-sair
1 <ENTER>

Produtos: 1-lista, 2-cria, 3-altera, 4-remove, 0-volta