Feature: Sign in
  Como cliente de la pagina web My Store
  necesito iniciar sesion
  para poder comprar ropa en la tienda

  Background:
    Given que el cliente está en la página principal de la tienda virtual Your y navega hasta Sign in

  @Scenario1
  Scenario: Crear cuenta
    When el cliente vaya a crear la cuenta, llene los datos obligatorios y los envie
    Then el sistema lo deja dentro del inicio de sesion

  @Scenario2
  Scenario: Inicio de sesion
    When el cliente autentique el inicio de sesion
    Then el cliente inicia sesion en la pagina web