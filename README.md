#Configuração para Conexão com o Banco de Dados
Deve ser efetuado o download do MySQL Installer Community no link abaixo: 

[MySql Installer Community](https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-8.0.36.0.msi)

E seguir os passos abaixo:

Basicamente, após a inicialização do instalador, deve-se clicar em 'Next' continuadamente, sendo apenas necessário customização no momento de definir a senha do usuário 'root' e adicionar outros usuários.

![tutorial](images/img-01.png)
Clicar em 'Next'
![tutorial](images/img-02.png)
Clicar em 'Execute'
![tutorial](images/img-03.png)
Clicar em 'Next'
![tutorial](images/img-04.png)
Clicar em 'Next'
![tutorial](images/img-05.png)
Clicar em 'Next'
![tutorial](images/img-06.png)
Escolher a senha do usuário root
![tutorial](images/img-07.png)
Adicionar usuários novos
![tutorial](images/img-08.png)
Clicar em 'Next'
![tutorial](images/img-09.png)
Clicar em 'Next'
![tutorial](images/img-10.png)
Clicar em 'Next'
![tutorial](images/img-11.png)
Clicar em 'Execute'
![tutorial](images/img-12.png)
Clicar em 'Finish'
![tutorial](images/img-13.png)
Clicar em 'Next' e após essa tela, haverá outra para clicar em finish.

Após essa instalação, deve-se criar uma conexão pelo dbeaver, escolher a opção url e colar a url configurada no application properties, que é:
`jdbc:mysql://localhost:3306/?allowPublicKeyRetrieval=true&useSSL=false` e colocar algum usuário e senha configurados.
![tutorial](images/img-14.png)
![tutorial](images/img-15.png)

Após essa configuração, o projeto se conectará ao banco de dados sem problemas.


