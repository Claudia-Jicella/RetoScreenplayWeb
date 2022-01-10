# new feature
# Tags: optional

Feature: cotizacion de prendas de vestir en la pagina Your Logo
  Como cliente de la pagina your logo
  necesito cotizar prendas de vestir
  para poder realizar la compra

  Background:
    Given que el cliente está en la página principal de la tienda virtual Your

  @Scenario1
  Scenario: Servicio al cliente
    When selecciona Contac us la opcion Servicio al cliente e ingrese los campos obligatorios
    Then el sistema debera mostrar un mensaje de confimacion de envio de la solicitud

  @Scenario2
  Scenario: Webmaster
    When seleccione Contac us la opcion Webmaster e ingrese los campos obligatorios
    Then la pagina debera imprimir en pantalla la confirmacion de la solicitud

