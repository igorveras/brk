Feature: Atendimento por Cidade

  Scenario Outline: Localizar cidade de Limeira
    Given que acesse o site da BRK ambiental
    And clicar em ENCONTRAR SUA CIDADE
    And selecionar o estado de <estado>
    When selecionar a cidade de <cidade>
    And fechar o quadro de aviso
    Then validar a mensagem da cidade <cidade>

    Examples: 
      | cidade         | estado      |
      | "Limeira - SP" | "São Paulo" |
