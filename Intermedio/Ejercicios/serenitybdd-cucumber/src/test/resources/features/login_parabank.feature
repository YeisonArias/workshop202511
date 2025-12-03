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

