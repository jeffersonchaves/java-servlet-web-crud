## DESENVOLVIMENTO WEB JAVA

Este projeto foi desenvolvido como uma "toy application" com o objetivo de explorar aspectos do desenvolvimento de aplicações para web.
Embora feito em java, os conceitos de HTPP empregados, práticas e padrões de conexão com o banco de dados, os padrões de projeto e a arquitetura utilizada  para a aplicação **podem ser estendidos** para qualquer projeto ou linguagem de programação. 


## ☕ Modelo

Este projeto foi realizado tendo como base o Java Development Kit (openjdk) em sua versão 11.0.16. Versões diferentes podem trazer problemas.

Este modelo é pode ser baixado e importado em seu Eclipse IDE:

1.  Open File->Import.
2.  Select "Existing Projects into Workspace" from the Selection Wizard.
3.  Select Next to get the Import Wizzard. Browse to find the location of the Project.
4.  Make sure the Project you want is checked, then hit Finish.

Caso tenha problemas em executar o projeto, minha sugestão é:

 1. Corrija a versão do Java em Build Path -> Configure Build Path
 2. Clique em Project --> Clean 
 3. Rode o projeto novamente.

Casos os passos acima não resolvam os problemas, um novo projeto pode ser criado e as classes e outros recursos podem ser copiados e colados. 

**BANCO DE DADOS**

Banco de dados utilizado: MySql 8


```

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

INSERT INTO `categories` VALUES (1,'Computers'),(2,'Electronics'),(3,'Fashion'),(4,'Books');


DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `price` double NOT NULL,
  `description` text NOT NULL,
  `imageUri` varchar(1024) NOT NULL,
  `categoryId` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `products_ibfk_1` (`categoryId`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

INSERT INTO `products` VALUES (1,'Fone de Ouvido JBL',456,'O móvel conta com uma superfície de 135cm para facilitar a organização do seu espaço de trabalho ou de estudo.','scratch.jpg',1),(3,'Fone de Ouvido Philips',249,'Bluetooth / Som JBL Pure Bass / Tempo de reprodução de até 50 horas / Chamadas viva voz / Acesso ao assistente de voz do seu dispositivo.','Captura de tela de 2022-08-22 11-58-52.png',1),(4,'Mesa de escritório',399,'O móvel conta com uma superfície de 135cm para facilitar a organização do seu espaço de trabalho ou de estudo.','rutogalore-batman.gif',4);
```
