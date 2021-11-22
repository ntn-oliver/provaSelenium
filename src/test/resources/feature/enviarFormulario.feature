#Author: ntn_oliver@hotmail.com
@regressivos 
Feature: Enviar cotacao
  Como usuario quero fazer uma cotacao para avaliar o preco
  
  Background: Acessar o site
  Given que o usuario acesse o site de cotacao "http://sampleapp.tricentis.com/101/index.php"

 @automobile @positivo
  Scenario: Enviar uma nova cotacao
    And clicar no na opcao desejada
    When preencher os dados do veiculo "Audi","2000", "11/01/2021", "4", "Diesel", "60000", "523265","45000",
    And preencher os dados do seguro "David", "Santos", "12/12/2000", "avenida 9 de julho, 5300", "Brazil", "01406200", "S�o Paulo", "Employee", "www.david.com.br"
    And preencher os dados do produto  "12/12/2022", "10000", "Super Bonus", "Full", "Yes"
    And preencher o preco
    And enviar cotacao "ntn_oliver@hotmail.com", "11985652565", "david123", "David123", "David123"
    Then validamos cotacao