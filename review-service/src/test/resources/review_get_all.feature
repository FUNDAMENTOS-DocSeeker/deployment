Feature: Obtener todas las revisiones

  Scenario: El usuario solicita todas las revisiones
    Given el servicio de revisiones está disponible
    When el usuario hace una solicitud para obtener todas las revisiones
    Then se devuelven todas las revisiones existentes
    And la respuesta tiene el código de estado 200
