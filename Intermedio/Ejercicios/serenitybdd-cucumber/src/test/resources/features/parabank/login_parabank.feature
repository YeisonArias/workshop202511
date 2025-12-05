# Feature para Login Parabank
@ReTest
Feature: Login Parabank
  Como usuario de Parabank
  Quiero iniciar sesión
  Para acceder a mis productos

  @Test
  Scenario: Login Exitoso Parabank
    Given que el usuario esta en la pagina de login de Parabank
    When el usuario ingresa sus credenciales
    Then el usuario es redirigido a la pagina de bienvenida

  @Test2
  Scenario: Login Exitoso Parabank
    Given que el usuario esta en la pagina de login de Parabank
    When el usuario el usuario "john" y la clave "demo"
    Then el usuario visualiza el mensaje de bienvenida "Welcome John Smith"

  @Test3
  Scenario Outline: Login Exitoso Parabank
    Given que el usuario esta en la pagina de login de Parabank
    When el usuario el usuario "<user>" y la clave "<password>"
    Then el usuario visualiza el mensaje de bienvenida "<mensaje>"
  Examples:
  | user | password | mensaje             |
  | john | demo     | Welcome John Smith  |
  | john | demo     | Welcome             |
