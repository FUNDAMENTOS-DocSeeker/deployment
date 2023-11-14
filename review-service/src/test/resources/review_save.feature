Feature: Guardar una nueva revisión

  Scenario: El usuario guarda una nueva revisión
    Given el servicio de revisiones está disponible
    When el usuario envía una nueva revisión
    Then se crea una nueva revisión en la base de datos
    And la respuesta contiene los detalles de la nueva revisión
    And la respuesta tiene el código de estado 201
